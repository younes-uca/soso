import {Component, OnInit} from '@angular/core';
import {PurchaseAdminService} from 'src/app/controller/service/admin/purchase/PurchaseAdmin.service';
import {PurchaseDto} from 'src/app/controller/model/purchase/Purchase.model';
import {PurchaseCriteria} from 'src/app/controller/criteria/purchase/PurchaseCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {ProductDto} from 'src/app/controller/model/purchase/Product.model';
import {ProductAdminService} from 'src/app/controller/service/admin/purchase/ProductAdmin.service';
import {PurchaseItemDto} from 'src/app/controller/model/purchase/PurchaseItem.model';
import {PurchaseItemAdminService} from 'src/app/controller/service/admin/purchase/PurchaseItemAdmin.service';
import {ClientDto} from 'src/app/controller/model/purchase/Client.model';
import {ClientAdminService} from 'src/app/controller/service/admin/purchase/ClientAdmin.service';


@Component({
  selector: 'app-purchase-list-admin',
  templateUrl: './purchase-list-admin.component.html'
})
export class PurchaseListAdminComponent extends AbstractListController<PurchaseDto, PurchaseCriteria, PurchaseAdminService>  implements OnInit {

    override fileName = 'Purchase';


    clients: Array<ClientDto>;


    constructor( private purchaseService: PurchaseAdminService  , private productService: ProductAdminService, private purchaseItemService: PurchaseItemAdminService, private clientService: ClientAdminService) {
        super(purchaseService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('Purchase').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
                this.loadClient();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'reference', header: 'Reference'},
            {field: 'purchaseDate', header: 'Purchase date'},
            {field: 'image', header: 'Image'},
            {field: 'total', header: 'Total'},
            {field: 'client?.fullName', header: 'Client'},
        ];
    }


    public async loadClient(){
       this.clientService.findAllOptimized().subscribe(clients => this.clients = clients, error => console.log(error))
    }

	public override initDuplicate(res: PurchaseDto) {
        if (res.purchaseItems != null) {
             res.purchaseItems.forEach(d => { d.Purchase = null; d.id = null; });
        }
	}


   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Reference': e.reference ,
                'Purchase date': this.datePipe.transform(e.purchaseDate , 'dd/MM/yyyy hh:mm'),
                 'Image': e.image ,
                 'Total': e.total ,
                 'Description': e.description ,
                'Client': e.client?.fullName ,
            }
        });

        this.criteriaData = [{
            'Reference': this.criteria.reference ? this.criteria.reference : environment.emptyForExport ,
            'Purchase date Min': this.criteria.purchaseDateFrom ? this.datePipe.transform(this.criteria.purchaseDateFrom , this.dateFormat) : environment.emptyForExport ,
            'Purchase date Max': this.criteria.purchaseDateTo ? this.datePipe.transform(this.criteria.purchaseDateTo , this.dateFormat) : environment.emptyForExport ,
            'Image': this.criteria.image ? this.criteria.image : environment.emptyForExport ,
            'Total Min': this.criteria.totalMin ? this.criteria.totalMin : environment.emptyForExport ,
            'Total Max': this.criteria.totalMax ? this.criteria.totalMax : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
        //'Client': this.criteria.client?.fullName ? this.criteria.client?.fullName : environment.emptyForExport ,
        }];
      }
}

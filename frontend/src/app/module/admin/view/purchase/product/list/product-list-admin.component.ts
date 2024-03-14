import {Component, OnInit} from '@angular/core';
import {ProductAdminService} from 'src/app/controller/service/admin/purchase/ProductAdmin.service';
import {ProductDto} from 'src/app/controller/model/purchase/Product.model';
import {ProductCriteria} from 'src/app/controller/criteria/purchase/ProductCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';



@Component({
  selector: 'app-product-list-admin',
  templateUrl: './product-list-admin.component.html'
})
export class ProductListAdminComponent extends AbstractListController<ProductDto, ProductCriteria, ProductAdminService>  implements OnInit {

    override fileName = 'Product';




    constructor( private productService: ProductAdminService  ) {
        super(productService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('Product').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'code', header: 'Code'},
            {field: 'reference', header: 'Reference'},
        ];
    }





   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Code': e.code ,
                 'Reference': e.reference ,
            }
        });

        this.criteriaData = [{
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
            'Reference': this.criteria.reference ? this.criteria.reference : environment.emptyForExport ,
        }];
      }
}

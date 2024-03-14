import {Component, OnInit} from '@angular/core';
import {ClientAdminService} from 'src/app/controller/service/admin/purchase/ClientAdmin.service';
import {ClientDto} from 'src/app/controller/model/purchase/Client.model';
import {ClientCriteria} from 'src/app/controller/criteria/purchase/ClientCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';



@Component({
  selector: 'app-client-list-admin',
  templateUrl: './client-list-admin.component.html'
})
export class ClientListAdminComponent extends AbstractListController<ClientDto, ClientCriteria, ClientAdminService>  implements OnInit {

    override fileName = 'Client';




    constructor( private clientService: ClientAdminService  ) {
        super(clientService);
    }

    ngOnInit(): void {
        this.activateSecurityConstraint('Client').subscribe(() => {
            if (true || this.listActionIsValid){
                this.findPaginatedByCriteria();
                this.initExport();
                this.initCol();
            }
        });
    }


    public override  initCol() {
        this.cols = [
            {field: 'fullName', header: 'Full name'},
            {field: 'email', header: 'Email'},
        ];
    }





   public  override prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Full name': e.fullName ,
                 'Email': e.email ,
            }
        });

        this.criteriaData = [{
            'Full name': this.criteria.fullName ? this.criteria.fullName : environment.emptyForExport ,
            'Email': this.criteria.email ? this.criteria.email : environment.emptyForExport ,
        }];
      }
}

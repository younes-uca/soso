import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {ClientAdminService} from 'src/app/controller/service/admin/purchase/ClientAdmin.service';
import {ClientDto} from 'src/app/controller/model/purchase/Client.model';
import {ClientCriteria} from 'src/app/controller/criteria/purchase/ClientCriteria.model';
@Component({
  selector: 'app-client-create-admin',
  templateUrl: './client-create-admin.component.html'
})
export class ClientCreateAdminComponent extends AbstractCreateController<ClientDto, ClientCriteria, ClientAdminService>  implements OnInit {



   private _validClientFullName = true;
   private _validClientEmail = true;

    constructor( private clientService: ClientAdminService ) {
        super(clientService);
    }

    ngOnInit(): void {
    }





    public override setValidation(value: boolean){
        this.validClientFullName = value;
        this.validClientEmail = value;
    }



    public override validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateClientFullName();
        this.validateClientEmail();
    }

    public validateClientFullName(){
        if (this.stringUtilService.isEmpty(this.item.fullName)) {
        this.errorMessages.push('Full name non valide');
        this.validClientFullName = false;
        } else {
            this.validClientFullName = true;
        }
    }
    public validateClientEmail(){
        if (this.stringUtilService.isEmpty(this.item.email)) {
        this.errorMessages.push('Email non valide');
        this.validClientEmail = false;
        } else {
            this.validClientEmail = true;
        }
    }






    get validClientFullName(): boolean {
        return this._validClientFullName;
    }

    set validClientFullName(value: boolean) {
         this._validClientFullName = value;
    }
    get validClientEmail(): boolean {
        return this._validClientEmail;
    }

    set validClientEmail(value: boolean) {
         this._validClientEmail = value;
    }



}

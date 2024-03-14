import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {PurchaseAdminService} from 'src/app/controller/service/admin/purchase/PurchaseAdmin.service';
import {PurchaseDto} from 'src/app/controller/model/purchase/Purchase.model';
import {PurchaseCriteria} from 'src/app/controller/criteria/purchase/PurchaseCriteria.model';

import {ProductDto} from 'src/app/controller/model/purchase/Product.model';
import {ProductAdminService} from 'src/app/controller/service/admin/purchase/ProductAdmin.service';
import {PurchaseItemDto} from 'src/app/controller/model/purchase/PurchaseItem.model';
import {PurchaseItemAdminService} from 'src/app/controller/service/admin/purchase/PurchaseItemAdmin.service';
import {ClientDto} from 'src/app/controller/model/purchase/Client.model';
import {ClientAdminService} from 'src/app/controller/service/admin/purchase/ClientAdmin.service';
@Component({
  selector: 'app-purchase-view-admin',
  templateUrl: './purchase-view-admin.component.html'
})
export class PurchaseViewAdminComponent extends AbstractViewController<PurchaseDto, PurchaseCriteria, PurchaseAdminService> implements OnInit {

    purchaseItems = new PurchaseItemDto();
    purchaseItemss: Array<PurchaseItemDto> = [];

    constructor(private purchaseService: PurchaseAdminService, private productService: ProductAdminService, private purchaseItemService: PurchaseItemAdminService, private clientService: ClientAdminService){
        super(purchaseService);
    }

    ngOnInit(): void {
    }


    get product(): ProductDto {
       return this.productService.item;
    }
    set product(value: ProductDto) {
        this.productService.item = value;
    }
    get products(): Array<ProductDto> {
       return this.productService.items;
    }
    set products(value: Array<ProductDto>) {
        this.productService.items = value;
    }
    get client(): ClientDto {
       return this.clientService.item;
    }
    set client(value: ClientDto) {
        this.clientService.item = value;
    }
    get clients(): Array<ClientDto> {
       return this.clientService.items;
    }
    set clients(value: Array<ClientDto>) {
        this.clientService.items = value;
    }


}

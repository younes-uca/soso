import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {ProductAdminService} from 'src/app/controller/service/admin/purchase/ProductAdmin.service';
import {ProductDto} from 'src/app/controller/model/purchase/Product.model';
import {ProductCriteria} from 'src/app/controller/criteria/purchase/ProductCriteria.model';

@Component({
  selector: 'app-product-view-admin',
  templateUrl: './product-view-admin.component.html'
})
export class ProductViewAdminComponent extends AbstractViewController<ProductDto, ProductCriteria, ProductAdminService> implements OnInit {


    constructor(private productService: ProductAdminService){
        super(productService);
    }

    ngOnInit(): void {
    }




}

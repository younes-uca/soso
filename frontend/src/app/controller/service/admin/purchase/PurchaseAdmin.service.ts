import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {PurchaseDto} from 'src/app/controller/model/purchase/Purchase.model';
import {PurchaseCriteria} from 'src/app/controller/criteria/purchase/PurchaseCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class PurchaseAdminService extends AbstractService<PurchaseDto, PurchaseCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/purchase/');
    }

    public constrcutDto(): PurchaseDto {
        return new PurchaseDto();
    }

    public constrcutCriteria(): PurchaseCriteria {
        return new PurchaseCriteria();
    }
}

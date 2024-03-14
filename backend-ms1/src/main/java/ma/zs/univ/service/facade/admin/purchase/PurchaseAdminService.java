package ma.zs.univ.service.facade.admin.purchase;

import java.util.List;
import ma.zs.univ.bean.core.purchase.Purchase;
import ma.zs.univ.dao.criteria.core.purchase.PurchaseCriteria;
import ma.zs.univ.zynerator.service.IService;



public interface PurchaseAdminService extends  IService<Purchase,PurchaseCriteria>  {

    List<Purchase> findByClientId(Long id);
    int deleteByClientId(Long id);
    long countByClientEmail(String email);




}

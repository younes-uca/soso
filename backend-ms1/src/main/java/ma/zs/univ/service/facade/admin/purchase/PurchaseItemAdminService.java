package ma.zs.univ.service.facade.admin.purchase;

import java.util.List;
import ma.zs.univ.bean.core.purchase.PurchaseItem;
import ma.zs.univ.dao.criteria.core.purchase.PurchaseItemCriteria;
import ma.zs.univ.zynerator.service.IService;



public interface PurchaseItemAdminService extends  IService<PurchaseItem,PurchaseItemCriteria>  {

    List<PurchaseItem> findByProductId(Long id);
    int deleteByProductId(Long id);
    long countByProductCode(String code);
    List<PurchaseItem> findByPurchaseId(Long id);
    int deleteByPurchaseId(Long id);
    long countByPurchaseReference(String reference);




}

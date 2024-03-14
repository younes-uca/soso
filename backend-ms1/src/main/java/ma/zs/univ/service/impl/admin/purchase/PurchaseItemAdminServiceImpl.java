package ma.zs.univ.service.impl.admin.purchase;


import ma.zs.univ.bean.core.purchase.PurchaseItem;
import ma.zs.univ.dao.criteria.core.purchase.PurchaseItemCriteria;
import ma.zs.univ.dao.facade.core.purchase.PurchaseItemDao;
import ma.zs.univ.dao.specification.core.purchase.PurchaseItemSpecification;
import ma.zs.univ.service.facade.admin.purchase.PurchaseItemAdminService;
import ma.zs.univ.zynerator.service.AbstractServiceImpl;
import ma.zs.univ.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.univ.service.facade.admin.purchase.PurchaseAdminService ;
import ma.zs.univ.bean.core.purchase.Purchase ;
import ma.zs.univ.service.facade.admin.purchase.ProductAdminService ;
import ma.zs.univ.bean.core.purchase.Product ;

import java.util.List;
@Service
public class PurchaseItemAdminServiceImpl extends AbstractServiceImpl<PurchaseItem, PurchaseItemCriteria, PurchaseItemDao> implements PurchaseItemAdminService {






    public void findOrSaveAssociatedObject(PurchaseItem t){
        if( t != null) {
            t.setProduct(productService.findOrSave(t.getProduct()));
            t.setPurchase(purchaseService.findOrSave(t.getPurchase()));
        }
    }

    public List<PurchaseItem> findByProductId(Long id){
        return dao.findByProductId(id);
    }
    public int deleteByProductId(Long id){
        return dao.deleteByProductId(id);
    }
    public long countByProductCode(String code){
        return dao.countByProductCode(code);
    }
    public List<PurchaseItem> findByPurchaseId(Long id){
        return dao.findByPurchaseId(id);
    }
    public int deleteByPurchaseId(Long id){
        return dao.deleteByPurchaseId(id);
    }
    public long countByPurchaseReference(String reference){
        return dao.countByPurchaseReference(reference);
    }






    public void configure() {
        super.configure(PurchaseItem.class, PurchaseItemSpecification.class);
    }


    @Autowired
    private PurchaseAdminService purchaseService ;
    @Autowired
    private ProductAdminService productService ;

    public PurchaseItemAdminServiceImpl(PurchaseItemDao dao) {
        super(dao);
    }

}

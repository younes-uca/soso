package ma.zs.univ.service.impl.admin.purchase;


import ma.zs.univ.bean.core.purchase.Purchase;
import ma.zs.univ.dao.criteria.core.purchase.PurchaseCriteria;
import ma.zs.univ.dao.facade.core.purchase.PurchaseDao;
import ma.zs.univ.dao.specification.core.purchase.PurchaseSpecification;
import ma.zs.univ.service.facade.admin.purchase.PurchaseAdminService;
import ma.zs.univ.zynerator.service.AbstractServiceImpl;
import ma.zs.univ.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zs.univ.service.facade.admin.purchase.PurchaseItemAdminService ;
import ma.zs.univ.bean.core.purchase.PurchaseItem ;
import ma.zs.univ.service.facade.admin.purchase.ClientAdminService ;
import ma.zs.univ.bean.core.purchase.Client ;

import java.util.List;
@Service
public class PurchaseAdminServiceImpl extends AbstractServiceImpl<Purchase, PurchaseCriteria, PurchaseDao> implements PurchaseAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Purchase create(Purchase t) {
        Purchase saved= super.create(t);
        if (saved != null && t.getPurchaseItems() != null) {
                t.getPurchaseItems().forEach(element-> {
                    element.setPurchase(saved);
                    purchaseItemService.create(element);
            });
        }
        return saved;

    }

    public Purchase findWithAssociatedLists(Long id){
        Purchase result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setPurchaseItems(purchaseItemService.findByPurchaseId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        purchaseItemService.deleteByPurchaseId(id);
    }


    public void updateWithAssociatedLists(Purchase purchase){
    if(purchase !=null && purchase.getId() != null){
            List<List<PurchaseItem>> resultPurchaseItems= purchaseItemService.getToBeSavedAndToBeDeleted(purchaseItemService.findByPurchaseId(purchase.getId()),purchase.getPurchaseItems());
            purchaseItemService.delete(resultPurchaseItems.get(1));
            ListUtil.emptyIfNull(resultPurchaseItems.get(0)).forEach(e -> e.setPurchase(purchase));
            purchaseItemService.update(resultPurchaseItems.get(0),true);
        }
    }




    public Purchase findByReferenceEntity(Purchase t){
        return  dao.findByReference(t.getReference());
    }
    public void findOrSaveAssociatedObject(Purchase t){
        if( t != null) {
            t.setClient(clientService.findOrSave(t.getClient()));
        }
    }

    public List<Purchase> findByClientId(Long id){
        return dao.findByClientId(id);
    }
    public int deleteByClientId(Long id){
        return dao.deleteByClientId(id);
    }
    public long countByClientEmail(String email){
        return dao.countByClientEmail(email);
    }

    public List<Purchase> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Purchase.class, PurchaseSpecification.class);
    }


    @Autowired
    private PurchaseItemAdminService purchaseItemService ;
    @Autowired
    private ClientAdminService clientService ;

    public PurchaseAdminServiceImpl(PurchaseDao dao) {
        super(dao);
    }

}

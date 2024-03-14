package  ma.zs.univ.dao.specification.core.purchase;

import ma.zs.univ.dao.criteria.core.purchase.PurchaseCriteria;
import ma.zs.univ.bean.core.purchase.Purchase;
import ma.zs.univ.zynerator.specification.AbstractSpecification;


public class PurchaseSpecification extends  AbstractSpecification<PurchaseCriteria, Purchase>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("purchaseDate", criteria.getPurchaseDate(), criteria.getPurchaseDateFrom(), criteria.getPurchaseDateTo());
        addPredicate("image", criteria.getImage(),criteria.getImageLike());
        addPredicateBigDecimal("total", criteria.getTotal(), criteria.getTotalMin(), criteria.getTotalMax());
        addPredicateFk("client","id", criteria.getClient()==null?null:criteria.getClient().getId());
        addPredicateFk("client","id", criteria.getClients());
        addPredicateFk("client","email", criteria.getClient()==null?null:criteria.getClient().getEmail());
    }

    public PurchaseSpecification(PurchaseCriteria criteria) {
        super(criteria);
    }

    public PurchaseSpecification(PurchaseCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

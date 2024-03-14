package  ma.zs.univ.dao.specification.core.purchase;

import ma.zs.univ.dao.criteria.core.purchase.PurchaseItemCriteria;
import ma.zs.univ.bean.core.purchase.PurchaseItem;
import ma.zs.univ.zynerator.specification.AbstractSpecification;


public class PurchaseItemSpecification extends  AbstractSpecification<PurchaseItemCriteria, PurchaseItem>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("price", criteria.getPrice(), criteria.getPriceMin(), criteria.getPriceMax());
        addPredicateBigDecimal("quantity", criteria.getQuantity(), criteria.getQuantityMin(), criteria.getQuantityMax());
        addPredicateFk("product","id", criteria.getProduct()==null?null:criteria.getProduct().getId());
        addPredicateFk("product","id", criteria.getProducts());
        addPredicateFk("product","code", criteria.getProduct()==null?null:criteria.getProduct().getCode());
        addPredicateFk("purchase","id", criteria.getPurchase()==null?null:criteria.getPurchase().getId());
        addPredicateFk("purchase","id", criteria.getPurchases());
        addPredicateFk("purchase","reference", criteria.getPurchase()==null?null:criteria.getPurchase().getReference());
    }

    public PurchaseItemSpecification(PurchaseItemCriteria criteria) {
        super(criteria);
    }

    public PurchaseItemSpecification(PurchaseItemCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

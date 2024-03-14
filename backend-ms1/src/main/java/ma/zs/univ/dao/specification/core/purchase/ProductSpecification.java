package  ma.zs.univ.dao.specification.core.purchase;

import ma.zs.univ.dao.criteria.core.purchase.ProductCriteria;
import ma.zs.univ.bean.core.purchase.Product;
import ma.zs.univ.zynerator.specification.AbstractSpecification;


public class ProductSpecification extends  AbstractSpecification<ProductCriteria, Product>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
    }

    public ProductSpecification(ProductCriteria criteria) {
        super(criteria);
    }

    public ProductSpecification(ProductCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

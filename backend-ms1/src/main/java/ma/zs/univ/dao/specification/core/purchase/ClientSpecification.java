package  ma.zs.univ.dao.specification.core.purchase;

import ma.zs.univ.dao.criteria.core.purchase.ClientCriteria;
import ma.zs.univ.bean.core.purchase.Client;
import ma.zs.univ.zynerator.specification.AbstractSpecification;


public class ClientSpecification extends  AbstractSpecification<ClientCriteria, Client>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("fullName", criteria.getFullName(),criteria.getFullNameLike());
        addPredicate("email", criteria.getEmail(),criteria.getEmailLike());
    }

    public ClientSpecification(ClientCriteria criteria) {
        super(criteria);
    }

    public ClientSpecification(ClientCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

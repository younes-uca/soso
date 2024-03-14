package ma.zs.univ.zynerator.service;

import ma.zs.univ.zynerator.audit.AuditBusinessObjectEnhanced;
import ma.zs.univ.zynerator.criteria.BaseCriteria;
import ma.zs.univ.zynerator.repository.AbstractRepository;

public abstract class AbstractReferentielServiceImpl<T extends AuditBusinessObjectEnhanced, CRITERIA extends BaseCriteria, REPO extends AbstractRepository<T, Long>> extends AbstractServiceImpl<T, CRITERIA, REPO> {

    public AbstractReferentielServiceImpl(REPO dao) {
        super(dao);
    }

}

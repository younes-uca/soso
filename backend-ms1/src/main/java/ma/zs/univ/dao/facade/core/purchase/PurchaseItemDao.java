package ma.zs.univ.dao.facade.core.purchase;

import ma.zs.univ.zynerator.repository.AbstractRepository;
import ma.zs.univ.bean.core.purchase.PurchaseItem;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface PurchaseItemDao extends AbstractRepository<PurchaseItem,Long>  {

    List<PurchaseItem> findByProductId(Long id);
    int deleteByProductId(Long id);
    long countByProductCode(String code);
    List<PurchaseItem> findByPurchaseId(Long id);
    int deleteByPurchaseId(Long id);
    long countByPurchaseReference(String reference);


}

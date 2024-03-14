package ma.zs.univ.service.impl.admin.purchase;


import ma.zs.univ.bean.core.purchase.Product;
import ma.zs.univ.dao.criteria.core.purchase.ProductCriteria;
import ma.zs.univ.dao.facade.core.purchase.ProductDao;
import ma.zs.univ.dao.specification.core.purchase.ProductSpecification;
import ma.zs.univ.service.facade.admin.purchase.ProductAdminService;
import ma.zs.univ.zynerator.service.AbstractServiceImpl;
import ma.zs.univ.zynerator.service.Attribute;
import ma.zs.univ.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class ProductAdminServiceImpl extends AbstractServiceImpl<Product, ProductCriteria, ProductDao> implements ProductAdminService {
public static final List<Attribute> ATTRIBUTES = new ArrayList();
    static{


    ATTRIBUTES.add(new Attribute("code"));

    ATTRIBUTES.add(new Attribute("reference"));
    }






    public Product findByReferenceEntity(Product t){
        return  dao.findByCode(t.getCode());
    }


    public List<Product> findAllOptimized() {
        return dao.findAllOptimized();
    }


    @Override
    protected List<Attribute> getAttributes() {
        return ATTRIBUTES;
    }



    public void configure() {
        super.configure(Product.class, ProductSpecification.class);
    }



    public ProductAdminServiceImpl(ProductDao dao) {
        super(dao);
    }

}

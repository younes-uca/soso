package ma.zs.univ.service.impl.admin.purchase;


import ma.zs.univ.bean.core.purchase.Client;
import ma.zs.univ.dao.criteria.core.purchase.ClientCriteria;
import ma.zs.univ.dao.facade.core.purchase.ClientDao;
import ma.zs.univ.dao.specification.core.purchase.ClientSpecification;
import ma.zs.univ.service.facade.admin.purchase.ClientAdminService;
import ma.zs.univ.zynerator.service.AbstractServiceImpl;
import ma.zs.univ.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class ClientAdminServiceImpl extends AbstractServiceImpl<Client, ClientCriteria, ClientDao> implements ClientAdminService {






    public Client findByReferenceEntity(Client t){
        return  dao.findByEmail(t.getEmail());
    }


    public List<Client> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Client.class, ClientSpecification.class);
    }



    public ClientAdminServiceImpl(ClientDao dao) {
        super(dao);
    }

}

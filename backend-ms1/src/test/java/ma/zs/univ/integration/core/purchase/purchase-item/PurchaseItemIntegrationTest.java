package ma.zs.univ.integration.core.purchase.purchase-item;

import com.intuit.karate.junit4.Karate;
import org.junit.runner.RunWith;

public class PurchaseItemIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("PurchaseItemHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}

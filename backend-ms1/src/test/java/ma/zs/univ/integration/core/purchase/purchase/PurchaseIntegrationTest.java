package ma.zs.univ.integration.core.purchase.purchase;

import com.intuit.karate.junit4.Karate;
import org.junit.runner.RunWith;

public class PurchaseIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("PurchaseHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}

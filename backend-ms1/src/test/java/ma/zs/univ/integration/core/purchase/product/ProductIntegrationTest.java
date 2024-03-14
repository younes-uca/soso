package ma.zs.univ.integration.core.purchase.product;

import com.intuit.karate.junit4.Karate;
import org.junit.runner.RunWith;

public class ProductIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("ProductHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}

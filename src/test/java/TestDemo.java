import Utils.JSONClass;
import org.testng.annotations.Test;

public class TestDemo extends BaseTest{

    JSONClass demoData;
    @Test
    public void testDependency(){
        demoData = new JSONClass("demoData.json");

        homePage
            .given()
                    .userAlreadyRegistered(demoData)
                .and()
                    .userAlreadyLoggedIn(demoData)
            .when();


    }
}

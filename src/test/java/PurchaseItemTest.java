import Utils.JSONClass;
import org.testng.annotations.Test;

public class PurchaseItemTest extends BaseTest{

    JSONClass jsonData;

    @Test
    public void testPurchaseItem(){
        jsonData = new JSONClass("checkoutData.json");

       homePage
            .given()
                    .userAlreadyRegistered(jsonData)
                .and()
                    .userAlreadyLoggedIn(jsonData)
            .when()
                    .chooseSoftwareCategory(0)
                    .validateCategoryPage()
                    .clickOnWindowsProProduct()
                    .clickWindowsAddToCart()
                    .validateProductAdded()
                    .navigateToShoppingCartPage()
                    .NavigateToCheckoutPage()
                    .confirmOrderDetails(jsonData.readJson("country"),
                       jsonData.readJson("city"), jsonData.readJson("address1"),
                       jsonData.readJson("postalCode"), jsonData.readJson("phoneNumber"))
            .then()
                    .validateSuccessfulOrder();


    }
}

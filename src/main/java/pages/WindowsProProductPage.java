package pages;

import Utils.FindClass;
import io.qameta.allure.Step;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


public class WindowsProProductPage {

    private WebDriver driver;
    public WindowsProProductPage(WebDriver driver){
        this.driver = driver;
    }

    private final By addToCartWindowsProduct = By.xpath("//button[@id='add-to-cart-button-11']");
    private final By alertMsg = By.xpath("//div[@class='bar-notification success']");

    private final By closeAlertMsg = By.xpath("//span[@title='Close']");

    private final By shoppingCartIcon = By.className("ico-cart");
 //   private final By goToCartButton = By.xpath("//button[@class='button-1 cart-button']");

    @Step
    public WindowsProProductPage clickWindowsAddToCart(){
        driver.findElement(addToCartWindowsProduct).click();
        return this;
    }
    @Step
    public WindowsProProductPage validateProductAdded(){
        Assert.assertTrue(driver.findElement(alertMsg).isDisplayed());

        return this;
    }
    public WindowsProProductPage clickCloseMsg(){

        driver.findElement(closeAlertMsg).click();
        return this;
    }
    @SneakyThrows
    public WindowsProProductPage clickShoppingCartIcon(){
        Thread.sleep(2000);
        driver.findElement(shoppingCartIcon).click();
        return this;
    }
    @Step
    public ShoppingCartPage navigateToShoppingCartPage(){
        clickCloseMsg()
        .clickShoppingCartIcon();
        return new ShoppingCartPage(driver);
    }

    public ShoppingCartPage navigatesdToShoppingCartPage(){


        return new ShoppingCartPage(driver);
    }


//    public WindowsProProductPage hoverShoppingCartIcon()  {
//
//        Actions action = new Actions(driver);
//        action.moveToElement(findElementWithFluentWait(driver,shoppingCartIcon)).perform();
//        return this;
//    }

//    public ShoppingCartPage clickGoToCart(){
//        findElementWithFluentWait(driver,goToCartButton).click();
//        return new ShoppingCartPage(driver);
//    }





}

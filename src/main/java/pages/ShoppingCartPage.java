package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ShoppingCartPage {

    private WebDriver driver;
    public ShoppingCartPage(WebDriver driver){
        this.driver = driver;
    }



    private final By checkOutButton = By.id("checkout");
    private final By termOfSeviceBox = By.id("termsofservice");

    public ShoppingCartPage clickTermOfServiceBox(){
        driver.findElement(termOfSeviceBox).click();
        return this ;
    }
    public ShoppingCartPage clickCheckOutBtn(){
        driver.findElement(checkOutButton).click();
        return this;
    }
    @Step
    public CheckOutPage NavigateToCheckoutPage(){
        clickTermOfServiceBox()
        .clickCheckOutBtn();
        return new CheckOutPage(driver) ;
    }




}

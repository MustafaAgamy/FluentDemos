package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ConfirmRegisterPage {

    private WebDriver driver;
    public ConfirmRegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By resultMsg = By.className("result");
    private final By continueBtn = By.xpath("//a[@class='button-1 register-continue-button']");

    public ConfirmRegisterPage validateSuccessfulRegister(){
       Assert.assertTrue(driver.findElement(resultMsg).isDisplayed());
       Assert.assertTrue(driver.findElement(resultMsg).getText().contains("Completed"));

       return this;
    }

    @Step
    public HomePage clickContinueBtn(){
        driver.findElement(continueBtn).click();
        return new HomePage(driver);
    }
}

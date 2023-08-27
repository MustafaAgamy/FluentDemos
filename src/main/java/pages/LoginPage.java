package pages;

import io.qameta.allure.Param;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginPage {

    private WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    private final By emailField = By.id("Email");
    private final By passwordField =By.id("Password");
    private final By confLoginBtn = By.xpath("//button[@class=\"button-1 login-button\"]");

    public LoginPage then(){
        return this;
    }

    @Step
    public LoginPage fillLoginData(String email, String password){
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }
    @Step
    public HomePage clickConfLoginBtn(){

        driver.findElement(confLoginBtn).click();
        return new HomePage(driver);
    }

    public boolean checkProductResults(){
        boolean correctProduct = false;
        List<WebElement> webElementList = driver.findElements(passwordField);
        for(int i = 0; i < webElementList.size(); i++){
            String webElementName = webElementList.get(i).getText();
            if(webElementName.equalsIgnoreCase("Apartment")
                || webElementName.equalsIgnoreCase("StandaloneVilla")){
                correctProduct = true;
            }
            else {
                correctProduct = false;
                break;
            }
        }
        return correctProduct;
    }


}

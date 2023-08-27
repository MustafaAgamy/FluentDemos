package pages;

import Utils.JSONClass;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class PreConditionsPage {

    private WebDriver driver;

    public PreConditionsPage(WebDriver driver){
        this.driver = driver;
    }
    HomePage homePage;

    @Step
    public PreConditionsPage userAlreadyRegistered(JSONClass jsonData){
        homePage = new HomePage(driver);

        homePage.clickRegisterBtn()
                .register(jsonData.readJson("firstName"),
                        jsonData.readJson("lastName"), jsonData.readJson("birthDay"),
                        jsonData.readJson("birthMonth"), jsonData.readJson("birthYear"),
                        jsonData.readJson("email"), jsonData.readJson("password"))
                .clickContinueBtn();
        return this;
    }

    @Step
    public PreConditionsPage userAlreadyLoggedIn(JSONClass jsonData){
        homePage = new HomePage(driver);

        homePage.clickLoginBtn()
                .fillLoginData(
                        jsonData.readJson("email"),
                        jsonData.readJson("password"))
                .clickConfLoginBtn();
        return this;
    }

    public HomePage when(){
        return new HomePage(driver);
    }

    public PreConditionsPage and(){
        return this;
    }

}

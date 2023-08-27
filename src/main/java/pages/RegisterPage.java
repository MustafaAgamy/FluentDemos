package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {
    private WebDriver driver;
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By genderFemaleRadio = By.id("gender-female");
    private final By fireNameField = By.id("FirstName");
    private final By lastNameField = By.id("LastName");
    private final By birthDayDropDown = By.name("DateOfBirthDay");
    private final By birthMonthDropDown = By.name("DateOfBirthMonth");
    private final By birthYearDropDown = By.name("DateOfBirthYear");
    private final By emailField = By.id("Email");
    private final By passwordField = By.id("Password");
    private final By confirmPasswordField = By.id("ConfirmPassword");
    private final By confirmRegisterBtn = By.id("register-button");



    @Step
    public ConfirmRegisterPage register(String firstName, String lastName, String birthDay,
                                 String birthMonth, String birthYear, String email, String password){
        driver.findElement(genderFemaleRadio).click();
        driver.findElement(fireNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        fillBirthInfo(birthDay, birthMonth, birthYear);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(confirmPasswordField).sendKeys(password);
        clickConfirmRegBtn();
        return new ConfirmRegisterPage(driver);
    }

    public ConfirmRegisterPage clickConfirmRegBtn(){
        driver.findElement(confirmRegisterBtn).click();
        return new ConfirmRegisterPage(driver);
    }

    private RegisterPage fillBirthInfo(String birthDay, String birthMonth, String birthYear){
        WebElement birthDayList = driver.findElement(birthDayDropDown);
        Select select = new Select(birthDayList);
        select.selectByValue(birthDay);

        WebElement birthMonthList = driver.findElement(birthMonthDropDown);
        Select select1 = new Select(birthMonthList);
        select1.selectByValue(birthMonth);


        WebElement birthYearList = driver.findElement(birthYearDropDown);
        Select select2 = new Select(birthYearList);
        select2.selectByValue(birthYear);

        return this;
    }
}

package pages;

import Utils.FindClass;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    private final By registerBtn = By.className("ico-register");
    private final By loginBtn = By.className("ico-login");
    private final By welcomeMsg = By.xpath("//div[@class=\"topic-block-title\"]//h2");
    private  final By searchField = By.xpath("//input[@id=\"small-searchterms\"]");
    private  final By searchButton = By.xpath("//button[@type=\"submit\"]");
    private  final By elementTitle = By.xpath("//h2[@class=\"product-title\"]/a");

    private  final By currency = By.id("customerCurrency");
    private  final By elementPrice = By.xpath("//span[@class='price actual-price']");


    private final By computerCategories = By.xpath("//ul[@class=\"top-menu notmobile\"]/li/a");
    private final By softwareCategory = By.xpath("(//ul[@class=\"sublist first-level\"]/li/a)[3]");




    public PreConditionsPage given(){
        return new PreConditionsPage(driver);
    }
    public HomePage then(){
        return this;
    }

    public HomePage navigateToUrl(String url){
        driver.navigate().to(url);
        return this;
    }

    @Step
    public RegisterPage clickRegisterBtn(){
        driver.findElement(registerBtn).click();
        return new RegisterPage(driver);
    }

    @Step
    public LoginPage clickLoginBtn(){
        driver.findElement(loginBtn).click();
        return new LoginPage(driver);
    }
    public HomePage validateSuccessfulLogin(){
        Assert.assertTrue(driver.findElement(welcomeMsg).isDisplayed());
        Assert.assertTrue(driver.findElement(welcomeMsg).getText().contains("Welcome"));

        return this;
    }

    public SoftwareCategoriesPage searchForProduct(String productName){
        driver.findElement(searchField).sendKeys(productName);
        driver.findElement(searchButton).click();
        return new SoftwareCategoriesPage(driver);
    }
    public String productTitleText(int index){
        return   driver.findElements(elementTitle).get(index).getText();
    }

    public int productSize(){
        return  driver.findElements(elementTitle).size();
    }

    //Change currency
    public HomePage selectCurrency(String typeOfCurrency) {
        Select selectDay = new Select(driver.findElement(currency));
        selectDay.selectByVisibleText(typeOfCurrency);
        return this;
    }
    public String productPricesText(int index){

        return driver.findElements(elementPrice).get(index).getText();
    }
    public int elementPricesSize(){

        return driver.findElements(elementPrice).size();
    }

    //Select Categories


    public  HomePage hoverCategory(int index){

        Actions action =  new Actions(driver);
        action.moveToElement(driver.findElements(computerCategories).get(index)).perform();
        return this;
    }

    public HomePage clickSoftware(){
        driver.findElement(softwareCategory).click();
        return this;
    }

    @Step
    public SoftwareCategoriesPage chooseSoftwareCategory(int index){
        hoverCategory(index)
        .clickSoftware();
        return new SoftwareCategoriesPage(driver);
    }

    public String elementOuterHtml(){
        System.out.println(driver.findElement(registerBtn).getAttribute("outerHTML"));
        return driver.findElement(registerBtn).getAttribute("outerHTML");
    }

    public String elementInnerHtml(){
        System.out.println(driver.findElement(registerBtn).getAttribute("innerHTML"));
        return driver.findElement(registerBtn).getAttribute("innerHTML");
    }





}

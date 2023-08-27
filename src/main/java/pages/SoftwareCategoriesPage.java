package pages;

import Utils.FindClass;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class SoftwareCategoriesPage {

   private WebDriver driver;

  public   SoftwareCategoriesPage(WebDriver driver){
        this.driver = driver;
    }

    private final By pageSoftwareTitle = By.xpath("//div[@class=\"page-title\"]/h1");

    private final By windowsEightBtn =  By.xpath("//h2[@class='product-title']//a[@href='/windows-8-pro']");

    @Step
    public SoftwareCategoriesPage validateCategoryPage(){

        Assert.assertTrue(driver.findElement(pageSoftwareTitle).getText().contains("Software"));

        return this;
    }

    @Step
    public WindowsProProductPage clickOnWindowsProProduct(){

        driver.findElement(windowsEightBtn).click();

        return new WindowsProProductPage(driver);
    }










}

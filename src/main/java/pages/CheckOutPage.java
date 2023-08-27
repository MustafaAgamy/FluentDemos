package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class CheckOutPage {

   private WebDriver driver;

    public CheckOutPage(WebDriver driver) {

        this.driver = driver;
    }

    private final By countryField = By.xpath("//select[@data-trigger=\"country-select\"]");
    private final By cityField = By.xpath("//input[@id=\"BillingNewAddress_City\"]");
    private final  By addressField = By.xpath("//input[@id=\"BillingNewAddress_Address1\"]");

    private final By postalCodeField = By.xpath("//input[@id=\"BillingNewAddress_ZipPostalCode\"]");
    private final By phoneNumberField = By.xpath("//input[@id=\"BillingNewAddress_PhoneNumber\"]");

    private final By saveBuildingAddressBtn = By.xpath("//button[@onclick=\"Billing.save()\"]");
    private final By saveShippingBtn = By.xpath("//button[@onclick='ShippingMethod.save()']");

    private final By savePaymentBtn = By.xpath("//button[@onclick='PaymentMethod.save()']");
    private final By savePaymentInfoBtn = By.xpath("//button[@onclick='PaymentInfo.save()']");
    private final By confirmOrderBtn = By.xpath("//button[@onclick='ConfirmOrder.save()']");
    private  final By successOrderMsg = By.xpath("//div[@class='section order-completed']//div[@class='title']");


    public CheckOutPage buildingAddress(String country, String city, String address, String postalCode, String phoneNumber){

        Select selectCountry = new Select(driver.findElement(countryField));
        selectCountry.selectByValue(country);

        driver.findElement(cityField).sendKeys(city);

        driver.findElement(addressField).sendKeys(address);

        driver.findElement(postalCodeField).sendKeys(postalCode);

        driver.findElement(phoneNumberField).sendKeys(phoneNumber);

        driver.findElement(saveBuildingAddressBtn).click();

        return this;
    }
    public CheckOutPage clickShippingMethod(){
        driver.findElement(saveShippingBtn).click();
        return this;
    }
    public CheckOutPage clickPaymentMethod(){
        driver.findElement(savePaymentBtn).click();
        return this;
    }
    public CheckOutPage clickPaymentInfo(){
        driver.findElement(savePaymentInfoBtn).click();
        return this;
    }
    public CheckOutPage clickConfirmOrder(){
        driver.findElement(confirmOrderBtn).click();
        return this;
    }

    @Step
    public CheckOutPage confirmOrderDetails(String country, String city, String address, String postalCode, String phoneNumber){
        buildingAddress(country, city, address, postalCode, phoneNumber)
        .clickShippingMethod()
        .clickPaymentMethod()
        .clickPaymentInfo()
        .clickConfirmOrder();
        return this;
    }
    public CheckOutPage then(){
        return this;
    }

    @Step
    public final CheckOutPage validateSuccessfulOrder(){
        Assert.assertTrue(driver.findElement(successOrderMsg).getText().contains("successfully"));

        return this;
    }



}

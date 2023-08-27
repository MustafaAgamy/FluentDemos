package Utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.ArrayList;

public class FindClass {


    private static final int WAIT_TIME_OUT = 10000;
    private static final int POLLING_DELAY = 500;

    public static WebElement elementToBePresent(WebDriver driver, By by) {
        return findElement(driver, by, "present");
    }
    public static WebElement elementToBeClickable(WebDriver driver, By by) {
        return findElement(driver, by, "click");
    }
    public static WebElement elementToBeVisible(WebDriver driver, By by) {
            return findElement(driver, by, "visible");
    }

    public static WebElement findElement(WebDriver driver, By by, String action) {

        var ignoredExceptions = ignoredExceptions();
        var wait = new FluentWait<>(driver).withTimeout(Duration.ofMillis(20000))
                .pollingEvery(Duration.ofMillis(500))
                .ignoreAll(ignoredExceptions);

        wait.until((ExpectedCondition<Boolean>) webDriver -> {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            boolean jqueryComplete = (Boolean) js.executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
            boolean javascriptComplete = (Boolean) js.executeScript("return document.readyState === 'complete';");
            return jqueryComplete && javascriptComplete;
        });

        switch (action.toLowerCase()){

            case "visible" -> {
                return wait.until(ExpectedConditions.refreshed(
                        ExpectedConditions.visibilityOfElementLocated(by)));
            }
            case "click" ->  {
                ignoredExceptions.add(ElementClickInterceptedException.class);
                return wait.until(ExpectedConditions.refreshed(
                        ExpectedConditions.elementToBeClickable(by)));
            }
            default -> {
                return wait.until(ExpectedConditions.refreshed(
                        ExpectedConditions.presenceOfElementLocated(by)));
            }
        }
    }

    public static ArrayList<Class<? extends Exception>> ignoredExceptions() {
        ArrayList<Class<? extends Exception>> ignoredExceptions = new ArrayList<>();
        ignoredExceptions.add(NoSuchElementException.class);
        ignoredExceptions.add(StaleElementReferenceException.class);
        ignoredExceptions.add(ElementNotInteractableException.class);
        ignoredExceptions.add(JavascriptException.class);
        ignoredExceptions.add(InvalidElementStateException.class);
        ignoredExceptions.add(org.openqa.selenium.interactions.MoveTargetOutOfBoundsException.class);

        return ignoredExceptions;
    }
}

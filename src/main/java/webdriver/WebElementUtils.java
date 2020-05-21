package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.util.List;

import static properties.PropertiesManager.getTimeout;
import static webdriver.FluentWaitUtils.*;
import static java.time.Duration.ofSeconds;

public class WebElementUtils extends SetupDriver {

    public static void click(By element) {
        elementToBeClickable(element).click();
}

    public static void clear(By element) {
        visibilityOfElementLocated(element).clear();
    }

    public static String getAttribute(By element, String attribute) {
        return presenceOfElementLocated(element).getAttribute(attribute);
    }

    public static int size(By element) {
        return presenceOfElementLocated(element).findElements(element).size();
    }

    public static String getText(By element) {
        return presenceOfElementLocated(element).getText();
    }

    public static void sendKeys(By element, String text) {
        elementToBeClickable(element).sendKeys(text);
    }

    public static void clearAndSendKeys(By element, String text) {
        elementToBeClickable(element).clear();
        elementToBeClickable(element).sendKeys(text);
    }

    public static void mouseHover(By element) {
        new Actions(driver).moveToElement(elementToBeClickable(element)).build().perform();
    }

    public static void mouseHoverAndClick(By element) {
        new Actions(driver).moveToElement(elementToBeClickable(element)).build().perform();
        click(element);
    }

    public static void scrollJS(By element) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
                    presenceOfElementLocated(element));
    }

    public static void clickJS(By element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
                presenceOfElementLocated(element));
    }

    public static void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = driver1 -> {
            assert driver1 != null;
            return ((JavascriptExecutor) driver1).executeScript(
                    "return document.readyState").toString().equals("complete");
        };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, ofSeconds(getTimeout()));
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete." + error);
        }
    }

    public static void selectByIndex(By select, int index) {
        elementToBeClickable(select);
        new Select(driver.findElement(select)).selectByIndex(index);
    }

    public static void selectByValue(By select, String value) {
        elementToBeClickable(select);
        new Select(driver.findElement(select)).selectByValue(value);
    }

    public static void deselectByIndex(By select, int index) {
        elementToBeClickable(select);
        new Select(driver.findElement(select)).deselectByIndex(index);
    }

    public static void deselectByValue(By select, String value) {
        elementToBeClickable(select);
        new Select(driver.findElement(select)).deselectByValue(value);
    }

    public static List getOptions(By select) {
        elementToBeClickable(select);
        return new Select(driver.findElement(select)).getOptions();
    }

}

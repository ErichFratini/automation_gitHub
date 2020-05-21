package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;


import java.time.Duration;
import java.util.List;

import static properties.PropertiesManager.getTimeout;
import static java.time.Duration.ofSeconds;

public class FluentWaitUtils extends SetupDriver {

    public static WebElement visibilityOfElementLocated(By element) {
        return new FluentWait<>(driver)
                .withTimeout(ofSeconds(getTimeout()))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(Exception.class)
                .until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static WebElement elementToBeClickable(By element) {
        return new FluentWait<>(driver)
                .withTimeout(ofSeconds(getTimeout()))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(Exception.class)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement presenceOfElementLocated(By element) {
        return new FluentWait<>(driver)
                .withTimeout(ofSeconds(getTimeout()))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(Exception.class)
                .until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public static boolean attributeContains(By element, String attribute, String value) {
        return new FluentWait<>(driver)
                .withTimeout(ofSeconds(getTimeout()))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(Exception.class)
                .until(ExpectedConditions.attributeContains(element, attribute, value));
    }

    public static boolean invisibilityOfElementLocated(By element) {
        return new FluentWait<>(driver)
                .withTimeout(ofSeconds(getTimeout()))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(Exception.class)
                .until(ExpectedConditions.invisibilityOfElementLocated(element));
    }

    public static boolean textToBePresentInElementValue(By element, String text) {
        return new FluentWait<>(driver)
                .withTimeout(ofSeconds(getTimeout()))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(Exception.class)
                .until(ExpectedConditions.textToBePresentInElementValue(element, text));
    }

    public static boolean urlContains(String url) {
        return new FluentWait<>(driver)
                .withTimeout(ofSeconds(getTimeout()))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(Exception.class)
                .until(ExpectedConditions.urlContains(url));
    }

    public static WebDriver frameToBeAvailableAndSwitchToIt(By frame) {
        return new FluentWait<>(driver)
                .withTimeout(ofSeconds(getTimeout()))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(Exception.class)
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
    }

    public static List<WebElement> presenceOfAllElementsLocatedBy(By elements) {
        return new FluentWait<>(driver)
                .withTimeout(ofSeconds(getTimeout()))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(Exception.class)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(elements));
    }
}

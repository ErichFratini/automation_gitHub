package webdriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class SetupDriver {

    public static WebDriver driver;
    private static ChromeOptions chromeOptions = new ChromeOptions();
    private static final Logger logger = LogManager.getLogger();

    public static WebDriver getChromeDriver() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        chromedriver().setup();
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("enable-automation");
        //chromeOptions.addArguments("headless");
        chromeOptions.addArguments("no-sandbox");
        //chromeOptions.addArguments("disable-infobars");
        //chromeOptions.addArguments("disable-dev-shm-usage");
        //chromeOptions.addArguments("disable-browser-side-navigation");
        //chromeOptions.addArguments("disable-gpu");
        driver = new ChromeDriver(chromeOptions);
        logger.info("Iniciando Chrome");
        return driver;
    }

    public static void quitDriver(){
        driver.quit();
    }


}

package webUtility;

import flow.DataProviderFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static WebDriver driver;
    static BaseTest baseClass;
    LogFileMessage log = new LogFileMessage ();
    public BaseTest(WebDriver driver) {
        this.driver = driver;
    }

    public BaseTest() {
    }

    public static BaseTest getInstance() {
        if (baseClass == null) {
            baseClass = new BaseTest();
        }
        return baseClass;
    }

    public static WebDriverWait waitForElement() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        return wait;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void cleanUp() {

        if (getDriver() != null) {
            getDriver().close();
            getDriver().quit();
        }
    }

    public void navigateToURL() throws InterruptedException {
        driver.get(DataProviderFactory.getConfig().getPropvalue("envurl"));
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        Thread.sleep(3000);
    }

    public WebDriver setBrowser(String browser) {
        log.displayMesage("*********system browser name - " + browser);

        if (null == browser) {
            browser = "chrome";
        }
        if (driver == null) {
            try {
                if (browser.equalsIgnoreCase("chrome")) {
                    System.setProperty("webdriver.chrome.driver", DataProviderFactory.getConfig().getChromePropvalue());
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return driver;
    }
}


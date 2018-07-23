package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Created by user on 7/23/18.
 */
public class SeleniumDriver {
    private static ThreadLocal<WebDriver> driverThread = new ThreadLocal<WebDriver>();

    public static void initDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"/src/test/resources/driver/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("start-fullscreen");
        driverThread.set(new ChromeDriver(options));
    }
    public static WebDriver getDriver() {
        return driverThread.get();
    }

}

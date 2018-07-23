package setup; /**
 * Created by user on 7/23/18.
 */


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import static setup.SeleniumDriver.getDriver;


public class BaseTest {
    @BeforeMethod
    public void setupBaseMethod() {
        SeleniumDriver.initDriver();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDownBase() {
        getDriver().close();
    }
}

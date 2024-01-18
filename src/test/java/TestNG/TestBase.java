package TestNG;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.admin.AdminLoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.juaracoding.utils.Constant.ADMIN_URL;

public class TestBase {

    protected static WebDriver driver;

    @BeforeSuite
    public void setUpChrome() {
        initializeWebDriver("chrome");
    }

    @AfterSuite
    public void tearDown() {
        waitBeforeClosing(3);
        closeWebDriver();
    }

    private void initializeWebDriver(String browser) {
        DriverSingleton.getInstance(browser);
        driver = DriverSingleton.getDriver();
    }

    private void waitBeforeClosing(long seconds) {
        DriverSingleton.delay(seconds);
    }

    private void closeWebDriver() {
        DriverSingleton.closeObjectInstance();
    }
}

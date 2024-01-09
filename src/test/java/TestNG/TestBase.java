package TestNG;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.admin.AdminLoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.juaracoding.utils.Constant.ADMIN_URL;

public class TestBase {
    public static WebDriver driver;
    @BeforeSuite
    public void setUpChrome(){
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
    }

    @AfterSuite
    public void finish(){
        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }
}

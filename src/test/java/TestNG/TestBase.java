package TestNG;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    private static WebDriver driver;

    @BeforeSuite
    public void setUpChrome(){
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();

        String adminURL = "https://staging-hadir.ptkta.com/dashboards/dashboard";

        driver.get(adminURL);

    }

    @AfterSuite
    public void finish(){
        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }
}

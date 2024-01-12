package TestNG.admin;

import TestNG.TestBase;
import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.GlobalElementPage;
import com.juaracoding.pages.admin.AdminDashboardPage;
import com.juaracoding.pages.admin.AdminLoginPage;
import com.juaracoding.pages.admin.DivisiPage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.juaracoding.utils.Constant.ADMIN_URL;

public class DummyTest extends TestBase {
    public DivisiPage divisiPage;
    public AdminLoginPage adminLoginPage;
    public AdminDashboardPage adminDashboardPage;

    public  GlobalElementPage globalElementPage;

    @BeforeClass
    public void testEnvironmentSetUP(){
        setUpChrome();

        driver.get(ADMIN_URL);

        divisiPage = new DivisiPage();
        adminLoginPage = new AdminLoginPage();
        adminDashboardPage = new AdminDashboardPage();
        globalElementPage = new GlobalElementPage();
    }
    @AfterClass
    public void finish(){
        DriverSingleton.delay(1);
        DriverSingleton.closeObjectInstance();
    }

    private void scrollPageToBottom() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        DriverSingleton.delay(1);

    }

    @Test(priority = 1)
    public void testValidLogin(){
        globalElementPage.setEmail("admin@hadir.com");
        globalElementPage.setPassword("admin@hadir");
        adminLoginPage.clickAdminLoginButton();
        adminDashboardPage.clickManagementSideBar();
        adminDashboardPage.clickDivisiSideBar();
    }

    @Test(priority = 3)
    public void testMovePage(){
        System.out.println(divisiPage.getDivisiTitleText());
    }
}

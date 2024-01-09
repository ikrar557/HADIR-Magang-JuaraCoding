package TestNG.admin;

import TestNG.TestBase;
import com.beust.ah.A;
import com.juaracoding.pages.admin.AdminLoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdminLoginTest extends TestBase {

    public AdminLoginPage adminLoginPage;

    @BeforeClass
    public void testEnvironmentSetup(){
        setUpChrome();

        adminLoginPage = new AdminLoginPage();
    }

    @Test(priority = 1)
    public void testValidLogin(){
        adminLoginPage.setEmail("admin@hadir.com");
        adminLoginPage.setPassword("admin@hadir");
        adminLoginPage.clickLoginButton();
    }
}

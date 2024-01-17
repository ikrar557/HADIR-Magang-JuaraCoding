package TestNG.admin;

import TestNG.TestBase;
import com.juaracoding.pages.GlobalElementPage;
import com.juaracoding.pages.admin.AdminLoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.juaracoding.utils.Constant.ADMIN_URL;
public class AdminLoginTest extends TestBase {
    AdminLoginPage adminLoginPage;
    GlobalElementPage globalElementPage;
    @BeforeClass
    public void testSetUpEnvironmentChrome(){
        setUpChrome();
        driver.get(ADMIN_URL);
        adminLoginPage = new AdminLoginPage();
        globalElementPage = new GlobalElementPage();
    }
    @Test(priority = 1)
    public void testValidLogin(){
        globalElementPage.setEmail("admin@hadir.com");
        globalElementPage.setPassword("admin@hadir");
        adminLoginPage.clickAdminLoginButton();
    }
}

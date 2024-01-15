package TestNG.admin;

import TestNG.TestBase;
import TestNG.template.AdminLogin;
import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.GlobalElementPage;
import com.juaracoding.pages.admin.AdminJabatanPage;
import com.juaracoding.pages.admin.AdminLoginPage;
import com.juaracoding.pages.staff.StaffLoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Objects;

import static com.juaracoding.utils.Constant.JABATAN_URL;

public class AdminJabatanTest extends TestBase {

    private AdminLogin adminLogin;
    GlobalElementPage globalElementPage;
    AdminJabatanPage adminJabatanPage;
    @BeforeClass
    public void testSetUpEnvironmentChrome(){
        setUpChrome();
        globalElementPage = new GlobalElementPage();
        adminLogin = new AdminLogin(globalElementPage, driver, JABATAN_URL);
        adminJabatanPage = new AdminJabatanPage();
    }

    @Test()
    public void testValidLogin(){
        adminLogin.loginUser();
    }

    // search jabatan
    @Test(dependsOnMethods = "testValidLogin")
    public void testSearchJabatan(){
        adminJabatanPage.inputSearchField("99");
        adminJabatanPage.clickSearchButton();
        DriverSingleton.delay(1);
        Assert.assertTrue(adminJabatanPage.isJabatanExist("Test Search Jabatan"));
    }

    //reset search
    @Test(dependsOnMethods = "testSearchJabatan")
    public void testResetSearchJabatan(){
        adminJabatanPage.clickResetButton();
        DriverSingleton.delay(1);
        Assert.assertEquals(driver.getCurrentUrl(), JABATAN_URL);
    }

}

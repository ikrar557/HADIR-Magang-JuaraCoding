package TestNG.admin;

import TestNG.TestBase;
import TestNG.template.AdminLogin;
import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.GlobalElementPage;
import com.juaracoding.pages.admin.AdminJabatanPage;
import com.juaracoding.pages.admin.AdminLoginPage;
import com.juaracoding.pages.staff.StaffLoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Objects;

import static com.juaracoding.utils.Constant.JABATAN_URL;

public class AdminJabatanTest extends TestBase {

    GlobalElementPage globalElementPage;
    AdminJabatanPage adminJabatanPage;
    @BeforeClass
    public void testSetUpEnvironmentChrome(){
        setUpChrome();
        globalElementPage = new GlobalElementPage();
        AdminLogin adminLogin = new AdminLogin(globalElementPage, driver, JABATAN_URL);
        adminLogin.loginUser();
        adminJabatanPage = new AdminJabatanPage();
    }

    // search jabatan
    @Test()
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

    @Test(dependsOnMethods = "testResetSearchJabatan")
    public void testAddJabatan() {
        adminJabatanPage.clickTambahkanButton();
        adminJabatanPage.inputNameField("Boss");
        adminJabatanPage.inputLevelField("98");
        adminJabatanPage.clickSimpanButton();

        DriverSingleton.delay(1);
        Assert.assertEquals(adminJabatanPage.getPopUpContent(), "Berhasil Menambahkan Job Level");
    }
    @Test(dependsOnMethods = "testAddJabatan")
    public void testAddJabatanThenCancel() {
        adminJabatanPage.clickTambahkanButton();
        adminJabatanPage.inputNameField("Boss");
        adminJabatanPage.inputLevelField("98");
        adminJabatanPage.clickBatalButton();

        Assert.assertFalse(adminJabatanPage.isPopUpVisible());
    }
    @Test(dependsOnMethods = "testAddJabatanThenCancel")
    public void testDeleteJabatan() {
        DriverSingleton.delay(1);
        adminJabatanPage.inputSearchField("98");
        adminJabatanPage.clickSearchButton();
        DriverSingleton.delay(1);
        adminJabatanPage.clickVerticalEllipsisButton();
        DriverSingleton.delay(1);
        adminJabatanPage.clickDeleteButton();
        DriverSingleton.delay(1);
        adminJabatanPage.clickDeleteConfirmationButton();

        // TODO : FIX THIS, NEED TO BE EQUAL
        Assert.assertEquals(adminJabatanPage.getPopUpContent(), "Berhasil Delete Jabatan");
    }

}

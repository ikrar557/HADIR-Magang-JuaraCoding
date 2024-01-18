package TestNG.admin;

import TestNG.TestBase;
import TestNG.template.AdminLogin;
import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.GlobalElementPage;
import com.juaracoding.pages.admin.AdminJabatanPage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.*;


import static com.juaracoding.utils.Constant.JABATAN_URL;

public class AdminJabatanTest extends TestBase {
    private static final int DELAY_SECONDS = 1;

    GlobalElementPage globalElementPage;
    AdminJabatanPage adminJabatanPage;
    DriverSingleton driverSingleton;

    @BeforeClass
    public void testSetUpEnvironmentChrome(){
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
        DriverSingleton.delay(DELAY_SECONDS);
        Assert.assertTrue(adminJabatanPage.isJabatanExist("Test Search Jabatan"));
    }

    //reset search
    @Test(dependsOnMethods = "testSearchJabatan")
    public void testResetSearchJabatan(){
        adminJabatanPage.clickResetButton();
        DriverSingleton.delay(DELAY_SECONDS);
        Assert.assertEquals(driver.getCurrentUrl(), JABATAN_URL);
    }

    @Test(dependsOnMethods = "testResetSearchJabatan")
    public void testAddJabatan() {
        adminJabatanPage.clickTambahkanButton();
        adminJabatanPage.inputNameField("Boss");
        adminJabatanPage.inputLevelField("98");
        adminJabatanPage.clickSimpanButton();

        DriverSingleton.delay(DELAY_SECONDS);
        Assert.assertEquals(adminJabatanPage.getPopUpContent(), "Berhasil Menambahkan Job Level");
    }
    @Test(dependsOnMethods = "testAddJabatan")
    public void testAddJabatanNegative() {
        adminJabatanPage.clickTambahkanButton();
        adminJabatanPage.inputNameField("Boss");
        adminJabatanPage.inputLevelField("Atasan");
        adminJabatanPage.clickSimpanButton();
        DriverSingleton.delay(DELAY_SECONDS);
        Assert.assertEquals(adminJabatanPage.getPopUpContent(), "Gagal Menambahkan Job Level");
        DriverSingleton.delay(DELAY_SECONDS);
        adminJabatanPage.clickBatalButton();
        DriverSingleton.delay(DELAY_SECONDS);
    }

    @Test(dependsOnMethods = "testAddJabatan")
    public void testEditJabatan() {
        adminJabatanPage.inputSearchField("98");
        adminJabatanPage.clickSearchButton();
        DriverSingleton.delay(DELAY_SECONDS);
        adminJabatanPage.clickVerticalEllipsisButton();
        adminJabatanPage.clickEditButton();
        DriverSingleton.delay(DELAY_SECONDS);
        adminJabatanPage.nameField.clear();
        adminJabatanPage.inputNameField("Boss Besar");
        adminJabatanPage.clickSimpanButtonOnEdit();
        DriverSingleton.delay(DELAY_SECONDS);

        // assert when screen has "Boss Besar"
        Assert.assertTrue(adminJabatanPage.isJabatanExist("Boss Besar"));
    }

    @Test(dependsOnMethods = "testAddJabatanNegative")
    public void testDeleteJabatan() {
        adminJabatanPage.inputSearchField("98");
        adminJabatanPage.clickSearchButton();
        DriverSingleton.delay(DELAY_SECONDS);
        adminJabatanPage.clickVerticalEllipsisButton();
        adminJabatanPage.clickDeleteButton();
        DriverSingleton.delay(DELAY_SECONDS);
        adminJabatanPage.clickDeleteConfirmationButton();
        DriverSingleton.delay(DELAY_SECONDS);
        Assert.assertEquals(adminJabatanPage.getPopUpContent(), "Berhasil Delete Jabatan");
    }

    @Test(dependsOnMethods = "testDeleteJabatan")
    public void goNextPage() {
        driver.get(JABATAN_URL);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 800)");
        DriverSingleton.delay(DELAY_SECONDS);
        adminJabatanPage.clickNextPageButton();
        DriverSingleton.delay(DELAY_SECONDS);
        Assert.assertEquals(driver.getCurrentUrl(), JABATAN_URL + "?page=2");
    }

    @Test(dependsOnMethods = "goNextPage")
    public void goPreviousPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 800)");
        DriverSingleton.delay(DELAY_SECONDS);
        adminJabatanPage.clickPreviousPageButton();
        DriverSingleton.delay(DELAY_SECONDS);
        Assert.assertEquals(driver.getCurrentUrl(), JABATAN_URL + "?page=1");
    }

    @Test(dependsOnMethods = "goPreviousPage")
    public void goLastPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 800)");
        DriverSingleton.delay(DELAY_SECONDS);
        adminJabatanPage.clickLastPageButton();
        DriverSingleton.delay(DELAY_SECONDS);
        js.executeScript("window.scrollBy(0, 800)");
        Assert.assertTrue(adminJabatanPage.isButtonDisabled(adminJabatanPage.lastPageButton));
    }

    @Test(dependsOnMethods = "goLastPage")
    public void goFirstPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 800)");
        DriverSingleton.delay(DELAY_SECONDS);
        adminJabatanPage.clickFirstPageButton();
        DriverSingleton.delay(DELAY_SECONDS);
        js.executeScript("window.scrollBy(0, 800)");
        Assert.assertTrue(adminJabatanPage.isButtonDisabled(adminJabatanPage.firstPageButton));
    }

    @Test(dependsOnMethods = "goFirstPage")
    public void selectRowPerPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 800)");
        DriverSingleton.delay(DELAY_SECONDS);
        adminJabatanPage.clickRowPerPageDropdown();
        DriverSingleton.delay(DELAY_SECONDS);
        adminJabatanPage.clickRowPerPage5();
        DriverSingleton.delay(DELAY_SECONDS);
        Assert.assertEquals(driver.getCurrentUrl(), JABATAN_URL + "?page=1&per_page=5");
    }

}

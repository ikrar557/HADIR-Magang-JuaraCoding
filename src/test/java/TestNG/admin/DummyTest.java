package TestNG.admin;

import TestNG.TestBase;
import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.GlobalElementPage;
import com.juaracoding.pages.admin.AdminDashboardPage;
import com.juaracoding.pages.admin.AdminLoginPage;
import com.juaracoding.pages.admin.DivisiPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DummyTest extends TestBase {
    public DivisiPage divisiPage;
    public AdminLoginPage adminLoginPage;
    public AdminDashboardPage adminDashboardPage;

    public static GlobalElementPage globalElementPage = new GlobalElementPage();

    @BeforeClass
    public void testEnvironmentSetUP(){
        setUpChrome();

        divisiPage = new DivisiPage();
        adminLoginPage = new AdminLoginPage();
        adminDashboardPage = new AdminDashboardPage();
    }
    @AfterClass
    public void finish(){
        DriverSingleton.delay(1);
        DriverSingleton.closeObjectInstance();
    }

    @Test(priority = 1)
    public void testValidLogin(){
        globalElementPage.setEmail("admin@hadir.com");
        globalElementPage.setPassword("admin@hadir");
        adminLoginPage.clickAdminLoginButton();
        adminDashboardPage.clickManagementSideBar();
        adminDashboardPage.clickDivisiSideBar();
    }

//    @Test(priority = 2)
//    public void testAddNewSameDivision(){
//        divisiPage.clickAddNewDivisionButton();
//        divisiPage.setDivisionName("JC-SQA 12");
//        divisiPage.clickSaveNewDivisionButton();
//        DriverSingleton.delay(1);
//        divisiPage.clickAddNewDivisionButton();
//        divisiPage.setDivisionName("JC-SQA 12");
//        divisiPage.clickSaveNewDivisionButton();
//        DriverSingleton.delay(1);
//        divisiPage.setSearchName("JC-SQA 12");
//        divisiPage.clickSearchSubmitButton();
//        DriverSingleton.delay(1);
//        Assert.assertEquals(divisiPage.getCountOfTextInFirstColumn("JC-SQA 12"), 1);
//    }

    @Test(priority = 3)
    public void testCancelEditDivision(){
        // Cancel Edit
        divisiPage.setSearchName("JC-SQA 12");
        divisiPage.clickSearchSubmitButton();
        DriverSingleton.delay(1);
        divisiPage.clickEditOrDeleteRowButton();
        DriverSingleton.delay(1);
        divisiPage.clickEditRowButton();
        divisiPage.setDivisionName("JC-SQA Batch 12");
        divisiPage.clickCancelDeleteOrEditButton();

//        // Refresh the page
//        DriverSingleton.getDriver().navigate().refresh();

        // Valid edit
        divisiPage.clickEditRowButton();
        divisiPage.setDivisionName("JC-SQA Batch 12");
        divisiPage.clickSaveEditDivisionButton();
        DriverSingleton.delay(1);
    }



}

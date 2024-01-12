package TestNG.admin;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.GlobalElementPage;
import com.juaracoding.pages.admin.DivisiPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.plaf.PanelUI;

import static TestNG.TestBase.driver;

public class DivisiTest{

    public DivisiPage divisiPage;
    public GlobalElementPage globalElementPage;

    @BeforeClass
    public void testEnvironmentSetUP(){
        globalElementPage = new GlobalElementPage();
        divisiPage = new DivisiPage();
    }

    @Test(priority = 1)
    public void testCancelAddNewDivision(){
        divisiPage.clickAddNewDivisionButton();
        divisiPage.setDivisionName("JC-SQA 12");
        divisiPage.clickCancelAddNewDivisionButton();
        DriverSingleton.delay(1);
        divisiPage.setSearchName("JC-SQA 12");
        divisiPage.clickSearchSubmitButton();
        DriverSingleton.delay(1);

        Assert.assertEquals(divisiPage.getCountOfRowsInFirstColumn(), 0);
    }

    @Test(priority = 2)
    public void testAdd255MoreChar(){
        divisiPage.clickAddNewDivisionButton();
        divisiPage.setDivisionName("fpiicougncpztofjvzpkjlbsqexghfdeuykucvzewrlqhxbwfxvwojnbzzmwwzikhcyfansdedqcrxjdcxowntjyvgsboghzpkdjuonqfvcmhrjuqjighcsidaqbdtztywrjwfznjbpzjsosoxkgwxfjzjalrefiilkbrlambaevduzdeayescirtnozlxqyxvnstbvxjbnyuiaoqskpiksharedtubicqnqaltxhezjneipvvzcfoygfcznalqw");
        divisiPage.clickSaveNewDivisionButton();

        Assert.assertEquals(divisiPage.getErrorNewDivision(), "Gagal Menambahkan Divisi");
        divisiPage.clickCancelDeleteOrEditButton();
    }
    @Test(priority = 3)
    public void testAddNewDivision(){
        divisiPage.clickAddNewDivisionButton();
        divisiPage.setDivisionName("JC-SQA 12");
        divisiPage.clickSaveNewDivisionButton();
        DriverSingleton.delay(1);
        divisiPage.setSearchName("JC-SQA 12");
        divisiPage.clickSearchSubmitButton();
        DriverSingleton.delay(1);

        Assert.assertEquals(divisiPage.getTextFromTopmostRowFirstColumn(), "JC-SQA 12");
    }

    @Test(priority = 4)
    public void testAddNewSameDivision(){
        divisiPage.clickAddNewDivisionButton();
        divisiPage.setDivisionName("JC-SQA 12");
        divisiPage.clickSaveNewDivisionButton();
        DriverSingleton.delay(1);
        divisiPage.setSearchName("JC-SQA 12");
        divisiPage.clickSearchSubmitButton();
        DriverSingleton.delay(1);

        Assert.assertEquals(divisiPage.getCountOfTextInFirstColumn("JC-SQA 12"), 1);
    }

    @Test(priority = 5)
    public void testAddNewBlankNameDivision(){
        divisiPage.clickAddNewDivisionButton();
        divisiPage.setDivisionName("");
        divisiPage.clickSaveNewDivisionButton();

        Assert.assertEquals(divisiPage.getValidationMessage(), "Please fill out this field.");
        divisiPage.clickCancelAddNewDivisionButton();
    }

    @Test(priority = 6)
    public void testSearchInvalidDivision(){
        DriverSingleton.delay(1);
        divisiPage.setSearchName("Codingan");
        divisiPage.clickSearchSubmitButton();
        DriverSingleton.delay(1);

        Assert.assertEquals(divisiPage.getCountOfRowsInFirstColumn(), 0);
    }

    @Test(priority = 7)
    public void testResetSearch(){
        globalElementPage.clickResetSearchButton();
        DriverSingleton.delay(1);

        Assert.assertEquals(divisiPage.getTextFromSearchButton(), "");
    }
    @Test(priority = 8)
    public void testSearchValidDivision(){
        DriverSingleton.delay(1);
        divisiPage.setSearchName("JC-SQA 12");
        divisiPage.clickSearchSubmitButton();
        DriverSingleton.delay(1);

        Assert.assertEquals(divisiPage.getTextFromTopmostRowFirstColumn(), "JC-SQA 12");
    }

    @Test(priority = 9)
    public void testCancelEditDivision(){
        divisiPage.clickEditOrDeleteRowButton();
        DriverSingleton.delay(1);
        divisiPage.clickEditRowButton();
        divisiPage.setDivisionName("JC-SQA Batch 12");
        divisiPage.clickCancelDeleteOrEditButton();

        Assert.assertEquals(divisiPage.getCountOfTextInFirstColumn("JC-SQA 12"), 2);
    }

    @Test(priority = 10)
    public void testEditDivision(){
        divisiPage.clickEditRowButton();
        DriverSingleton.delay(1);
        divisiPage.setDivisionName("JC-SQA Batch 12");
        DriverSingleton.delay(1);
        divisiPage.clickSaveEditDivisionButton();

        driver.navigate().refresh();
        divisiPage.setSearchName("JC-SQA Batch 12");
        divisiPage.clickSearchSubmitButton();
        DriverSingleton.delay(1);

        Assert.assertEquals(divisiPage.getCountOfTextInFirstColumn("JC-SQA Batch 12"), 1);
    }

    @Test(priority = 11)
    public void testEditDivisionSameName(){
        globalElementPage.clickResetSearchButton();
        DriverSingleton.delay(1);
        divisiPage.setSearchName("JC-SQA 12");
        divisiPage.clickSearchSubmitButton();
        DriverSingleton.delay(1);
        divisiPage.clickEditOrDeleteRowButton();
        DriverSingleton.delay(1);
        divisiPage.clickEditRowButton();
        divisiPage.setDivisionName("JC-SQA Batch 12");
        DriverSingleton.delay(1);
        divisiPage.clickSaveEditDivisionButton();

        driver.navigate().refresh();
        divisiPage.setSearchName("JC-SQA Batch 12");

        // TODO: INFO!, It return failed because it should be give warning when there's identical division name
        Assert.assertEquals(divisiPage.getCountOfTextInFirstColumn("JC-SQA Batch 12"), 1);
    }

    @Test(priority = 12)
    public void testCancelDeleteDivision(){
        DriverSingleton.delay(1);
        divisiPage.setSearchName("JC-SQA Batch 12");
        divisiPage.clickSearchSubmitButton();
        DriverSingleton.delay(1);
        divisiPage.clickEditOrDeleteRowButton();
        divisiPage.clickDeleteRowButton();
        DriverSingleton.delay(1);
        divisiPage.clickCancelDeleteOrEditButton();

        Assert.assertEquals(divisiPage.getCountOfTextInFirstColumn("JC-SQA Batch 12"), 2);
    }

    @Test(priority = 13)
    public void testDeleteDivision(){
        divisiPage.clickDeleteRowButton();
        DriverSingleton.delay(1);
        divisiPage.clickConfirmDeleteDivisionRow();
        globalElementPage.clickResetSearchButton();
        divisiPage.setSearchName("JC-SQA Batch 12");
        divisiPage.clickSearchSubmitButton();
        DriverSingleton.delay(1);

        Assert.assertEquals(divisiPage.getCountOfTextInFirstColumn("JC-SQA Batch 12"), 1);
    }

    @Test(priority = 14)
    public void testFilterRowBy5(){
        globalElementPage.clickResetSearchButton();
        divisiPage.scrollPageToBottom();
        globalElementPage.clickSelectFilterByRow();
        globalElementPage.clickFilterRowBy5();
        DriverSingleton.delay(1);
        Assert.assertEquals(divisiPage.getCountOfRowsInFirstColumn(), 5);
    }
    @Test(priority = 15)
    public void testFilterRowBy10(){
        globalElementPage.clickSelectFilterByRow();
        globalElementPage.clickFilterRowBy10();
        DriverSingleton.delay(1);
        Assert.assertEquals(divisiPage.getCountOfRowsInFirstColumn(), 10);
    }

    @Test(priority = 16)
    public void testFilterRowBy25(){
        globalElementPage.clickSelectFilterByRow();
        globalElementPage.clickFilterRowBy25();
        DriverSingleton.delay(1);
        Assert.assertEquals(divisiPage.getCountOfRowsInFirstColumn(), 25);
    }

    @Test(priority = 17)
    public void testMoveToLastPage(){
        globalElementPage.clickResetSearchButton();
        divisiPage.scrollPageToBottom();
        globalElementPage.clickSelectFilterByRow();
        globalElementPage.clickFilterRowBy5();
        DriverSingleton.delay(1);
        globalElementPage.clickLastPageIcon();
        // TODO: Add assertion to check
    }
    @Test(priority = 18)
    public void testMoveToFirstPage(){
        DriverSingleton.delay(1);
        globalElementPage.clickFirstPageIcon();
        // TODO: Add assertion to check
    }
    @Test(priority = 19)
    public void testMoveToNextPage(){
        DriverSingleton.delay(1);
        globalElementPage.clickNextPageIcon();
        // TODO: Add assertion to check
    }
    @Test(priority = 20)
    public void testMoveToBeforePage(){
        DriverSingleton.delay(1);
        globalElementPage.clickBeforePageIcon();
        // TODO: Add assertion to check
    }
}

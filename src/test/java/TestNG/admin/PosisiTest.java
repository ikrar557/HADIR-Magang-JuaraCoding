package TestNG.admin;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.GlobalElementPage;
import com.juaracoding.pages.admin.DivisiPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static TestNG.TestBase.driver;

public class PosisiTest{

    public DivisiPage divisiPage;
    public GlobalElementPage globalElementPage;

    @BeforeClass
    public void testEnvironmentSetUP(){
        globalElementPage = new GlobalElementPage();
        divisiPage = new DivisiPage();
    }

    @Test(priority = 1)
    public void testCancelAddNewDivision(){
        globalElementPage.clickAddNewItemButton();
        globalElementPage.setNewItemName("Manager SQA");
        globalElementPage.clickCancelAddNewItemButton();
        DriverSingleton.delay(1);
        globalElementPage.setSearchName("JC-SQA 12");
        globalElementPage.clickSearchSubmitButton();
        DriverSingleton.delay(1);

        Assert.assertEquals(globalElementPage.getCountOfRowsInFirstColumn(), 0);
    }

    @Test(priority = 2)
    public void testAdd255MoreChar(){
        globalElementPage.clickAddNewItemButton();
        globalElementPage.setNewItemName("fpiicougncpztofjvzpkjlbsqexghfdeuykucvzewrlqhxbwfxvwojnbzzmwwzikhcyfansdedqcrxjdcxowntjyvgsboghzpkdjuonqfvcmhrjuqjighcsidaqbdtztywrjwfznjbpzjsosoxkgwxfjzjalrefiilkbrlambaevduzdeayescirtnozlxqyxvnstbvxjbnyuiaoqskpiksharedtubicqnqaltxhezjneipvvzcfoygfcznalqw");
        globalElementPage.clickSaveNewItemButton();

        Assert.assertEquals(globalElementPage.getErrorNewItem(), "Gagal Menambahkan Divisi");
        globalElementPage.clickCancelDeleteOrEditButton();
    }
    @Test(priority = 3)
    public void testAddNewDivision(){
        globalElementPage.clickAddNewItemButton();
        globalElementPage.setNewItemName("JC-SQA 12");
        globalElementPage.clickSaveNewItemButton();
        DriverSingleton.delay(1);
        globalElementPage.setSearchName("JC-SQA 12");
        globalElementPage.clickSearchSubmitButton();
        DriverSingleton.delay(1);

        Assert.assertEquals(globalElementPage.getTextFromTopmostRowFirstColumn(), "JC-SQA 12");
    }

    @Test(priority = 4)
    public void testAddNewSameDivision(){
        globalElementPage.clickAddNewItemButton();
        globalElementPage.setNewItemName("JC-SQA 12");
        globalElementPage.clickSaveNewItemButton();
        DriverSingleton.delay(1);
        globalElementPage.setSearchName("JC-SQA 12");
        globalElementPage.clickSearchSubmitButton();
        DriverSingleton.delay(1);

        Assert.assertEquals(globalElementPage.getCountOfTextInFirstColumn("JC-SQA 12"), 1);
    }

    @Test(priority = 5)
    public void testAddNewBlankNameDivision(){
        globalElementPage.clickAddNewItemButton();
        globalElementPage.setNewItemName("");
        globalElementPage.clickSaveNewItemButton();

        Assert.assertEquals(globalElementPage.getValidationMessage(), "Please fill out this field.");
        globalElementPage.clickCancelAddNewItemButton();
    }

    @Test(priority = 6)
    public void testSearchInvalidDivision(){
        DriverSingleton.delay(1);
        globalElementPage.setSearchName("Codingan");
        globalElementPage.clickSearchSubmitButton();
        DriverSingleton.delay(1);

        Assert.assertEquals(globalElementPage.getCountOfRowsInFirstColumn(), 0);
    }

    @Test(priority = 7)
    public void testResetSearch(){
        globalElementPage.clickResetSearchButton();
        DriverSingleton.delay(1);

        Assert.assertEquals(globalElementPage.getTextFromSearchButton(), "");
    }
    @Test(priority = 8)
    public void testSearchValidDivision(){
        DriverSingleton.delay(1);
        globalElementPage.setSearchName("JC-SQA 12");
        globalElementPage.clickSearchSubmitButton();
        DriverSingleton.delay(1);

        Assert.assertEquals(globalElementPage.getTextFromTopmostRowFirstColumn(), "JC-SQA 12");
    }

    @Test(priority = 9)
    public void testCancelEditDivision(){
        globalElementPage.clickEditOrDeleteRowButton();
        DriverSingleton.delay(2);
        globalElementPage.clickEditRowButton();
        DriverSingleton.delay(1);
        globalElementPage.setNewItemName("JC-SQA Batch 12");
        globalElementPage.clickCancelDeleteOrEditButton();

        Assert.assertEquals(globalElementPage.getCountOfTextInFirstColumn("JC-SQA 12"), 2);
    }

    @Test(priority = 10)
    public void testEditDivision(){
        globalElementPage.clickEditRowButton();
        DriverSingleton.delay(1);
        globalElementPage.setNewItemName("JC-SQA Batch 12");
        DriverSingleton.delay(1);
        globalElementPage.clickSaveEditItemButton();

        driver.navigate().refresh();
        globalElementPage.setSearchName("JC-SQA Batch 12");
        globalElementPage.clickSearchSubmitButton();
        DriverSingleton.delay(1);

        Assert.assertEquals(globalElementPage.getCountOfTextInFirstColumn("JC-SQA Batch 12"), 1);
    }

    @Test(priority = 11)
    public void testEditDivisionSameName(){
        globalElementPage.clickResetSearchButton();
        DriverSingleton.delay(1);
        globalElementPage.setSearchName("JC-SQA 12");
        globalElementPage.clickSearchSubmitButton();
        DriverSingleton.delay(1);
        globalElementPage.clickEditOrDeleteRowButton();
        DriverSingleton.delay(1);
        globalElementPage.clickEditRowButton();
        globalElementPage.setNewItemName("JC-SQA Batch 12");
        DriverSingleton.delay(1);
        globalElementPage.clickSaveEditItemButton();

        driver.navigate().refresh();
        globalElementPage.setSearchName("JC-SQA Batch 12");
        globalElementPage.clickSearchSubmitButton();
        DriverSingleton.delay(1);

        // TODO: INFO!, It return failed because it should be give warning when there's identical division name
        Assert.assertEquals(globalElementPage.getCountOfTextInFirstColumn("JC-SQA Batch 12"), 1);
    }

    @Test(priority = 12)
    public void testCancelDeleteDivision(){
        globalElementPage.clickEditOrDeleteRowButton();
        DriverSingleton.delay(3);
        globalElementPage.clickDeleteRowButton();
        DriverSingleton.delay(1);
        globalElementPage.clickCancelDeleteOrEditButton();

        Assert.assertEquals(globalElementPage.getCountOfTextInFirstColumn("JC-SQA Batch 12"), 2);
    }

    @Test(priority = 13)
    public void testDeleteDivision(){
        globalElementPage.clickDeleteRowButton();
        DriverSingleton.delay(1);
        globalElementPage.clickConfirmDeleteItemRow();
        globalElementPage.clickResetSearchButton();
        globalElementPage.setSearchName("JC-SQA Batch 12");
        globalElementPage.clickSearchSubmitButton();
        DriverSingleton.delay(1);

        Assert.assertEquals(globalElementPage.getCountOfTextInFirstColumn("JC-SQA Batch 12"), 1);
    }

    @Test(priority = 14)
    public void testFilterRowBy5(){
        globalElementPage.clickResetSearchButton();
        globalElementPage.scrollPageToBottom();
        globalElementPage.clickSelectFilterByRow();
        globalElementPage.clickFilterRowBy5();
        DriverSingleton.delay(2);
        Assert.assertEquals(globalElementPage.getCountOfRowsInFirstColumn(), 5);
    }
    @Test(priority = 15)
    public void testFilterRowBy10(){
        globalElementPage.clickSelectFilterByRow();
        globalElementPage.clickFilterRowBy10();
        DriverSingleton.delay(1);
        Assert.assertEquals(globalElementPage.getCountOfRowsInFirstColumn(), 10);
    }

    @Test(priority = 16)
    public void testFilterRowBy25(){
        globalElementPage.clickSelectFilterByRow();
        globalElementPage.clickFilterRowBy25();
        DriverSingleton.delay(1);
        Assert.assertEquals(globalElementPage.getCountOfRowsInFirstColumn(), 25);
    }

    @Test(priority = 17)
    public void testMoveToLastPage(){
        globalElementPage.clickResetSearchButton();
        globalElementPage.scrollPageToBottom();
        globalElementPage.clickSelectFilterByRow();
        globalElementPage.clickFilterRowBy5();
        DriverSingleton.delay(1);
        globalElementPage.clickLastPageIcon();
        // TODO: Add assertion to check

        DriverSingleton.delay(1);
        Assert.assertEquals(globalElementPage.getPaginationDisplayedInformation(), "21-25 of 25");
    }

    @Test(priority = 18)
    public void testMoveToBeforePage(){
        globalElementPage.clickBeforePageIcon();
        // TODO: Add assertion to check

        DriverSingleton.delay(1);
        Assert.assertEquals(globalElementPage.getPaginationDisplayedInformation(), "11-15 of 25");
    }
    @Test(priority = 19)
    public void testMoveToFirstPage(){
        globalElementPage.clickFirstPageIcon();
        // TODO: Add assertion to check

        DriverSingleton.delay(1);
        Assert.assertEquals(globalElementPage.getPaginationDisplayedInformation(), "1-5 of 25");
    }
    @Test(priority = 20)
    public void testMoveToNextPage(){
        globalElementPage.clickNextPageIcon();
        // TODO: Add assertion to check

        DriverSingleton.delay(1);
        Assert.assertEquals(globalElementPage.getPaginationDisplayedInformation(), "6-10 of 25");
    }

}
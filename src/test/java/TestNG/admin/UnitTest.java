package TestNG.admin;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.GlobalElementPage;
import com.juaracoding.pages.admin.UnitPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static TestNG.TestBase.driver;

public class UnitTest {
    public UnitPage unitPage;
    public GlobalElementPage globalElementPage;

    @BeforeClass
    public void testEnvironmentSetUP(){
        globalElementPage = new GlobalElementPage();
        unitPage = new UnitPage();
    }

    @Test(priority = 1)
    public void testCancelAddNewUnit(){
        globalElementPage.clickAddNewItemButton();
        globalElementPage.setNewItemName("SQA-RPA JC 12");
        globalElementPage.clickCancelAddNewItemButton();
        DriverSingleton.delay(1);
        globalElementPage.setSearchName("SQA-RPA JC 12");
        globalElementPage.clickSearchSubmitButton();
        DriverSingleton.delay(1);

        Assert.assertEquals(globalElementPage.getCountOfRowsInFirstColumn(), 0);
    }

    @Test(priority = 2)
    public void testAdd255MoreCharUnit(){
        globalElementPage.clickAddNewItemButton();
        globalElementPage.setNewItemName("fpiicougncpztofjvzpkjlbsqexghfdeuykucvzewrlqhxbwfxvwojnbzzmwwzikhcyfansdedqcrxjdcxowntjyvgsboghzpkdjuonqfvcmhrjuqjighcsidaqbdtztywrjwfznjbpzjsosoxkgwxfjzjalrefiilkbrlambaevduzdeayescirtnozlxqyxvnstbvxjbnyuiaoqskpiksharedtubicqnqaltxhezjneipvvzcfoygfcznalqw");
        globalElementPage.clickSaveNewItemButton();

        Assert.assertEquals(globalElementPage.getErrorNewItem(), "Gagal Menambahkan Departements");
        globalElementPage.clickCancelDeleteOrEditButton();
    }
    @Test(priority = 3)
    public void testAddNewUnit(){
        globalElementPage.clickAddNewItemButton();
        DriverSingleton.delay(1);
        globalElementPage.setNewItemName("SQA-RPA JC 12");
        globalElementPage.clickSaveNewItemButton();
        DriverSingleton.delay(1);
        globalElementPage.setSearchName("SQA-RPA JC 12");
        globalElementPage.clickSearchSubmitButton();
        DriverSingleton.delay(1);

        Assert.assertEquals(globalElementPage.getTextFromTopmostRowFirstColumn(), "SQA-RPA JC 12");
    }

    @Test(priority = 4)
    public void testAddNewSameUnit(){
        globalElementPage.clickAddNewItemButton();
        globalElementPage.setNewItemName("SQA-RPA JC 12");
        globalElementPage.clickSaveNewItemButton();
        DriverSingleton.delay(1);
        globalElementPage.setSearchName("SQA-RPA JC 12");
        globalElementPage.clickSearchSubmitButton();
        DriverSingleton.delay(1);

        Assert.assertEquals(globalElementPage.getCountOfTextInFirstColumn("SQA-RPA JC 12"), 1);
    }

    @Test(priority = 5)
    public void testAddNewBlankNameUnit(){
        globalElementPage.clickAddNewItemButton();
        globalElementPage.setNewItemName("");
        globalElementPage.clickSaveNewItemButton();

        Assert.assertEquals(globalElementPage.getValidationMessage(), "Please fill out this field.");
        globalElementPage.clickCancelAddNewItemButton();
    }

    @Test(priority = 6)
    public void testSearchInvalidUnit(){
        DriverSingleton.delay(1);
        globalElementPage.setSearchName("RandRandUnit");
        globalElementPage.clickSearchSubmitButton();
        DriverSingleton.delay(1);

        Assert.assertEquals(globalElementPage.getCountOfRowsInFirstColumn(), 0);
    }

    @Test(priority = 7)
    public void testResetSearchUnit(){
        globalElementPage.clickResetSearchButton();
        DriverSingleton.delay(1);

        Assert.assertEquals(globalElementPage.getTextFromSearchButton(), "");
    }
    @Test(priority = 8)
    public void testSearchValidUnit(){
        DriverSingleton.delay(1);
        globalElementPage.setSearchName("SQA-RPA JC 12");
        globalElementPage.clickSearchSubmitButton();
        DriverSingleton.delay(1);

        Assert.assertEquals(globalElementPage.getTextFromTopmostRowFirstColumn(), "SQA-RPA JC 12");
    }

    @Test(priority = 9)
    public void testCancelEditUnit(){
        globalElementPage.clickEditOrDeleteRowButton();
        DriverSingleton.delay(1);
        globalElementPage.clickEditRowButton();
        globalElementPage.setNewItemName("SQA-RPA JC Benhil");
        globalElementPage.clickCancelDeleteOrEditButton();

        Assert.assertEquals(globalElementPage.getCountOfTextInFirstColumn("SQA-RPA JC 12"), 2);
    }

    @Test(priority = 10)
    public void testEditUnit(){
        DriverSingleton.delay(1);
        globalElementPage.clickEditRowButton();
        DriverSingleton.delay(1);
        globalElementPage.setNewItemName("SQA-RPA JC Benhil");
        DriverSingleton.delay(1);
        globalElementPage.clickSaveEditItemButton();

        driver.navigate().refresh();
        globalElementPage.setSearchName("SQA-RPA JC Benhil");
        globalElementPage.clickSearchSubmitButton();
        DriverSingleton.delay(1);

        Assert.assertEquals(globalElementPage.getCountOfTextInFirstColumn("SQA-RPA JC Benhil"), 1);
    }

    @Test(priority = 11)
    public void testEditUnitSameName(){
        globalElementPage.clickResetSearchButton();
        DriverSingleton.delay(1);
        globalElementPage.setSearchName("SQA-RPA JC 12");
        globalElementPage.clickSearchSubmitButton();
        DriverSingleton.delay(1);
        globalElementPage.clickEditOrDeleteRowButton();
        DriverSingleton.delay(1);
        globalElementPage.clickEditRowButton();
        globalElementPage.setNewItemName("SQA-RPA JC Benhil");
        DriverSingleton.delay(1);
        globalElementPage.clickSaveEditItemButton();

        driver.navigate().refresh();
        globalElementPage.setSearchName("SQA-RPA JC Benhil");
        globalElementPage.clickSearchSubmitButton();
        DriverSingleton.delay(1);

        // TODO: INFO!, It return failed because it should be give warning when there's identical unit name
        Assert.assertEquals(globalElementPage.getCountOfTextInFirstColumn("SQA-RPA JC Benhil"), 1);
    }

    @Test(priority = 12)
    public void testCancelDeleteUnit(){
        globalElementPage.clickEditOrDeleteRowButton();
        DriverSingleton.delay(2);
        globalElementPage.clickDeleteRowButton();
        DriverSingleton.delay(1);
        globalElementPage.clickCancelDeleteOrEditButton();

        Assert.assertEquals(globalElementPage.getCountOfTextInFirstColumn("SQA-RPA JC Benhil"), 2);
    }

    @Test(priority = 13)
    public void testDeleteUnit(){
        driver.navigate().refresh();

        DriverSingleton.delay(1);
        globalElementPage.clickEditOrDeleteRowButton();
        DriverSingleton.delay(1);
        globalElementPage.clickDeleteRowButton();
        DriverSingleton.delay(1);
        globalElementPage.clickConfirmDeleteItemRow();
        DriverSingleton.delay(1);
        globalElementPage.clickResetSearchButton();
        globalElementPage.setSearchName("SQA-RPA JC Benhil");
        globalElementPage.clickSearchSubmitButton();
        DriverSingleton.delay(1);

        Assert.assertEquals(globalElementPage.getCountOfTextInFirstColumn("SQA-RPA JC Benhil"), 1);
    }

    @Test(priority = 14)
    public void testFilterRowBy5Unit(){
        globalElementPage.clickResetSearchButton();
        globalElementPage.scrollPageToBottom();
        globalElementPage.clickSelectFilterByRow();
        globalElementPage.clickFilterRowBy5();
        DriverSingleton.delay(2);
        Assert.assertEquals(globalElementPage.getCountOfRowsInFirstColumn(), 5);
    }
    @Test(priority = 15)
    public void testFilterRowBy10Unit(){
        globalElementPage.clickSelectFilterByRow();
        globalElementPage.clickFilterRowBy10();
        DriverSingleton.delay(1);
        Assert.assertEquals(globalElementPage.getCountOfRowsInFirstColumn(), 10);
    }

    @Test(priority = 16)
    public void testFilterRowBy25Unit(){
        globalElementPage.clickSelectFilterByRow();
        globalElementPage.clickFilterRowBy25();
        DriverSingleton.delay(1);
        Assert.assertEquals(globalElementPage.getCountOfRowsInFirstColumn(), 25);
    }

    @Test(priority = 17)
    public void testMoveToLastPageUnit(){
        globalElementPage.clickResetSearchButton();
        globalElementPage.scrollPageToBottom();
        globalElementPage.clickSelectFilterByRow();
        globalElementPage.clickFilterRowBy5();
        DriverSingleton.delay(1);
        globalElementPage.clickLastPageIcon();
        // TODO: Add assertion to check
    }
    @Test(priority = 18)
    public void testMoveToFirstPageUnit(){
        DriverSingleton.delay(1);
        globalElementPage.clickFirstPageIcon();
        // TODO: Add assertion to check
    }
    @Test(priority = 19)
    public void testMoveToNextPageUnit(){
        DriverSingleton.delay(1);
        globalElementPage.clickNextPageIcon();
        // TODO: Add assertion to check
    }
    @Test(priority = 20)
    public void testMoveToBeforePageUnit(){
        DriverSingleton.delay(1);
        globalElementPage.clickBeforePageIcon();
        // TODO: Add assertion to check
    }
}

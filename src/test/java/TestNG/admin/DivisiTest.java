package TestNG.admin;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.admin.DivisiPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DivisiTest{

    public DivisiPage divisiPage;

    @BeforeClass
    public void testEnvironmentSetUP(){
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
        Assert.assertEquals(divisiPage.getTextFromTopmostRowFirstColumn(), "");
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
        Assert.assertEquals(divisiPage.getTextFromTopmostRowFirstColumn(), "");
    }

    @Test(priority = 7)
    public void testResetSearch(){
        divisiPage.clickResetSearchButton();
    }
    @Test(priority = 8)
    public void testSearchValidDivision(){
        DriverSingleton.delay(1);
        divisiPage.setSearchName("JC-SQA 12");
        divisiPage.clickSearchSubmitButton();
        DriverSingleton.delay(1);
        Assert.assertEquals(divisiPage.getTextFromTopmostRowFirstColumn(), "JC-SQA 12");
    }

}

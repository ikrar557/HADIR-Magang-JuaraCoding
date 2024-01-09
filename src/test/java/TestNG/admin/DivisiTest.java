package TestNG.admin;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.admin.DivisiPage;
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
        divisiPage.setDivisionName("Juara Coding");
        divisiPage.clickCancelAddNewDivisionButton();
    }

    @Test(priority = 2)
    public void testAddNewDivision(){
        divisiPage.clickAddNewDivisionButton();
        divisiPage.setDivisionName("Juara Coding");
        divisiPage.clickSaveNewDivisionButton();
    }

    @Test(priority = 3)
    public void testSearchValidDivision(){
        DriverSingleton.delay(1);
        divisiPage.setSearchName("Juara Coding");
        divisiPage.clickSearchSubmitButton();
    }

    @Test(priority = 4)
    public void testResetSearch(){
        divisiPage.clickResetSearchButton();
    }

    @Test(priority = 5)
    public void testSearchInvalidDivision(){
        divisiPage.setSearchName("Codingan");
        divisiPage.clickSearchSubmitButton();
    }
}

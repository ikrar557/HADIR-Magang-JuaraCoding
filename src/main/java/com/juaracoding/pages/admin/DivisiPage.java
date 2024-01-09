package com.juaracoding.pages.admin;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DivisiPage {
    private WebDriver driver;

    public DivisiPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".button-add")
    private WebElement addNewDivisionButton;

    @FindBy(css= ".MuiButton-textSecondary")
    private WebElement cancelAddNewDivisionButton;

    @FindBy(id = "name")
    private WebElement fieldNewDivisionName;

    @FindBy (xpath = "(//button[@type='submit'])[2]")
    private WebElement saveNewDivisionButton;

    @FindBy(id ="search")
    private WebElement search;

    @FindBy(xpath="//button[@type='submit']")
    private WebElement searchSubmitButton;

    @FindBy(css=".MuiButton-textWarning")
    private WebElement resetSearchButton;

//    Element to click the icon 3 stack to edit or delete row
    @FindBy(css=".MuiTableRow-root:nth-child(1) .feather")
    private WebElement iconButtonDeleteOrEditRow;

//    Element appears once you click the icon 3 stack to edit or delete row
    @FindBy(xpath="//li[contains(.,'Edit')]")
    private WebElement editRowButton;

//    Element appears when editing data
    @FindBy(xpath="//button[contains(.,'Simpan')]")
    private WebElement saveEditButton;

    @FindBy(xpath = "//li[contains(.,'Delete')]")
    private WebElement deleteRowButton;

    @FindBy(xpath= "//button[contains(.,'Ya')]")
    private WebElement confirmDeleteButton;

//   Cancel edit or delete prompt element sharing same element
//   Element appears once you click edit or delete
    @FindBy(xpath="//div[2]/button[2]")
    private WebElement cancelEditOrDeleteButton;

//   Section to add element for the icon arrow (move between page)
    @FindBy(css = "[data-testid='KeyboardArrowRightIcon']")
    private WebElement nextPageIcon;

    @FindBy(css = "[data-testid='LastPageIcon']")
    private WebElement lastPageIcon;

    @FindBy(css = "[data-testid='KeyboardArrowLeftIcon']")
    private WebElement beforePageIcon;

    @FindBy(css = "[data-testid='FirstPageIcon']")
    private WebElement firstPageIcon;

//   Section to add element for filter the total rows per page
    @FindBy(xpath="//li[contains(.,'5')]")
    private WebElement filterRowBy5;

    @FindBy(xpath="//li[contains(.,'10')]")
    private WebElement filterRowBy10;

    @FindBy(xpath="//li[contains(.,'25')]")
    private WebElement filterRowBy25;

    // TODO: Add every element to validate the test

    public void clickAddNewDivisionButton(){
        addNewDivisionButton.click();
    }

    public void clickCancelAddNewDivisionButton(){
        cancelAddNewDivisionButton.click();
    }

    public void setDivisionName(String divisionName){
        this.fieldNewDivisionName.sendKeys(divisionName);
    }

    public void clickSaveNewDivisionButton(){
        saveNewDivisionButton.click();
    }
    public void setSearchName(String searchName){
        this.search.sendKeys(searchName);
    }

    public void clickSearchSubmitButton(){
        searchSubmitButton.click();
    }

    public void clickResetSearchButton(){
        resetSearchButton.click();
    }

    public void clickEditOrDeleteRowButton(){
        iconButtonDeleteOrEditRow.click();
    }

    public void clickEditRowButton(){
        editRowButton.click();
    }

    public void clickSaveEditDivisionButton(){
        saveEditButton.click();
    }

    public void clickDeleteRowButton(){
        deleteRowButton.click();
    }

    public void clickConfirmDeleteDivisionRow(){
        confirmDeleteButton.click();
    }

    public void clickCancelDeleteOrEditButton(){
        cancelEditOrDeleteButton.click();
    }

    public void clickNextPageIcon(){
        nextPageIcon.click();
    }

    public void clickLastPageIcon(){
        lastPageIcon.click();
    }

    public void clickBeforePageIcon(){
        beforePageIcon.click();
    }

    public void clickFirstPageIcon(){
        firstPageIcon.click();
    }

    public void clickFilterRowBy5(){
        filterRowBy5.click();
    }

    public void clickFilterRowBy10(){
        filterRowBy10.click();
    }
    public void clickFilterRowBy25(){
        filterRowBy25.click();
    }

    // TODO: Add getter to check if cancel when adding new division
    // TODO: Add getter to check if error more then 255 char
    // TODO: Add getter to check if correct input
    // TODO: Add getter to check same new input
    // TODO: Add getter to check if the input is blank
}

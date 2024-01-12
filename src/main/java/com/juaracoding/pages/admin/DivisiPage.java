package com.juaracoding.pages.admin;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class DivisiPage {
    private WebDriver driver;

    public DivisiPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1kei35f']")
    private WebElement divisiTitlePage;

    @FindBy(css = ".button-add")
    private WebElement addNewDivisionButton;

    @FindBy(css= ".MuiButton-textSecondary")
    private WebElement cancelAddNewDivisionButton;

    @FindBy(id = "name")
    private WebElement fieldNewDivisionName;

    @FindBy (css =".MuiButton-sizeMedium[type='submit']")
    private WebElement saveNewDivisionButton;

    @FindBy(id ="search")
    private WebElement search;

    @FindBy(xpath="//button[@type='submit']")
    private WebElement searchSubmitButton;

//    Element to click the icon 3 stack to edit or delete row
    @FindBy(css=".MuiTableRow-root:nth-child(1) .feather")
    private WebElement iconButtonDeleteOrEditRow;

//    Element appears once you click the icon 3 stack to edit or delete row
    @FindBy(css=".MuiMenuItem-root[tabindex='0']")
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

    @FindBy(className = "MuiTable-root")
    private WebElement yourTable;
    @FindBy(css = ".MuiSnackbarContent-message")
    private WebElement popUpErrorAddNewDivision;

    public void clickAddNewDivisionButton(){
        addNewDivisionButton.click();
    }

    public void clickCancelAddNewDivisionButton(){
        cancelAddNewDivisionButton.click();
    }

    public void setDivisionName(String divisionName){
        this.fieldNewDivisionName.clear();
        this.fieldNewDivisionName.sendKeys(divisionName);
    }

    public void clickSaveNewDivisionButton(){
        saveNewDivisionButton.click();
    }
    public void setSearchName(String searchName){
        this.search.clear();
        this.search.sendKeys(searchName);
    }

    public void clickSearchSubmitButton(){
        searchSubmitButton.click();
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

    public String getErrorNewDivision(){
        return popUpErrorAddNewDivision.getText();
    }

    public String getValidationMessage(){
        return fieldNewDivisionName.getAttribute("validationMessage");
    }

    public String getTextFromSearchButton(){
        return search.getAttribute("value");
    }

    public String getDivisiTitleText(){
        return divisiTitlePage.getText();
    }

    public String getTextFromTopmostRowFirstColumn() {
        try {
            String xpath = "//table[contains(@class, 'MuiTable-root')]/tbody/tr[1]/td[1]";
            return yourTable.findElement(By.xpath(xpath)).getText();
        } catch (NoSuchElementException e) {
            return "";
        } // TODO: Fix way to make it faster, the try catch waited for too long
    }

    public int getCountOfTextInFirstColumn(String searchText) {
        try {
            String xpath = "//table[contains(@class, 'MuiTable-root')]/tbody/tr/td[1]";
            List<WebElement> firstColumnElements = yourTable.findElements(By.xpath(xpath));
            int count = 0;
            for (WebElement element : firstColumnElements) {
                if (element.getText().equals(searchText)) {
                    count++;
                }
            }
            return count;
        } catch (NoSuchElementException e) {
            return 0;
        }
    }

    public int getCountOfRowsInFirstColumn() {
        try {
            String xpath = "//table[contains(@class, 'MuiTable-root')]/tbody/tr/td[1]";
            List<WebElement> firstColumnElements = yourTable.findElements(By.xpath(xpath));
            return firstColumnElements.size();
        } catch (NoSuchElementException e) {
            return 0;
        }
    }

    public void scrollPageToBottom() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        DriverSingleton.delay(1);
    }
}

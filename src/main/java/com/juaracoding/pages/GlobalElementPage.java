package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class GlobalElementPage {
    public static WebDriver driver;

    public GlobalElementPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id = "password")
    public WebElement password;

    // From here: It's element global that sharing element across page or module
    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1kei35f']")
    public WebElement moduleTitlePage;

    @FindBy(css = ".button-add")
    public WebElement addNewButton;

    @FindBy(css= ".MuiButton-textSecondary")
    public WebElement cancelAddNewButton;

    @FindBy(id = "name")
    public WebElement fieldNewName;

    @FindBy (css =".MuiButton-sizeMedium[type='submit']")
    public WebElement saveNewButton;

    @FindBy(id ="search")
    public WebElement search;

    @FindBy(xpath="//button[@type='submit']")
    public WebElement searchSubmitButton;

    //    Element to click the icon 3 stack to edit or delete row
    @FindBy(css=".MuiTableRow-root:nth-child(1) .feather")
    public WebElement iconButtonDeleteOrEditRow;

    //    Element appears once you click the icon 3 stack to edit or delete row
    @FindBy(xpath="//div[@class='MuiPopover-root MuiMenu-root MuiModal-root css-1sucic7']//li[.='Edit']")
    public WebElement editRowButton;

    //    Element appears when editing data
    @FindBy(xpath="//button[contains(.,'Simpan')]")
    public WebElement saveEditButton;

    @FindBy(xpath = "//div[@class='MuiPopover-root MuiMenu-root MuiModal-root css-1sucic7']//li[.='Delete']")
    public WebElement deleteRowButton;

    @FindBy(xpath= "//button[contains(.,'Ya')]")
    public WebElement confirmDeleteButton;

    //   Cancel edit or delete prompt element sharing same element
    //   Element appears once you click edit or delete
    @FindBy(xpath="//div[2]/button[2]")
    public WebElement cancelEditOrDeleteButton;

    @FindBy(className = "MuiTable-root")
    public WebElement yourTable;

    //   Section to add element for the icon arrow (move between page)
    @FindBy(css = "[data-testid='KeyboardArrowRightIcon']")
    public WebElement nextPageIcon;

    @FindBy(css = "[data-testid='LastPageIcon']")
    public WebElement lastPageIcon;

    @FindBy(css = "[data-testid='KeyboardArrowLeftIcon']")
    public WebElement beforePageIcon;

    @FindBy(css = "[data-testid='FirstPageIcon']")
    public WebElement firstPageIcon;

    //   Section to add element for filter the total rows per page
    @FindBy(css=".MuiButton-textWarning")
    public WebElement resetSearchButton;

    @FindBy(css = ".MuiSelect-select")
    private WebElement selectFilterByRow;

    @FindBy(xpath="//li[contains(.,'5')]")
    public WebElement filterRowBy5;

    @FindBy(xpath="//li[contains(.,'10')]")
    public WebElement filterRowBy10;

    @FindBy(xpath="//li[contains(.,'25')]")
    public WebElement filterRowBy25;

    @FindBy(css = ".MuiSnackbarContent-message")
    private WebElement popUpErrorAddNewItem;

    // Element to fetch total displayed row after filter by 5
    @FindBy(css =".MuiTablePagination-displayedRows")
    private WebElement paginationDisplayedInfo;

    // List of functions

    // Global function to get the title of page
    public String getTitleText(){
        return moduleTitlePage.getText();
    }

    // Global function to get error popup
    public String getErrorNewItem(){
        return popUpErrorAddNewItem.getText();
    }

    // Set password and email for login
    public void setEmail(String setEmail){
        email.sendKeys(setEmail);
    }

    public void setPassword(String setPassword){
        password.sendKeys(setPassword);
    }

    // Global function to about search function
    public void setSearchName(String searchName){
        this.search.clear();
        this.search.sendKeys(searchName);
    }
    public void clickResetSearchButton(){
        resetSearchButton.click();
    }

    public void clickSearchSubmitButton(){
        searchSubmitButton.click();
    }

    public String getTextFromSearchButton(){
        return search.getAttribute("value");
    }

    // Global function add new item function
    public void clickAddNewItemButton(){
        addNewButton.click();
    }

    public void clickCancelAddNewItemButton(){
        cancelAddNewButton.click();
    }

    public void setNewItemName(String newItemName){
        this.fieldNewName.clear();
        this.fieldNewName.sendKeys(newItemName);
    }

    public void clickSaveNewItemButton(){
        saveNewButton.click();
    }

    public String getValidationMessage(){
        return fieldNewName.getAttribute("validationMessage");
    }


    // Global function to modify row in table
    public void clickEditOrDeleteRowButton(){
        iconButtonDeleteOrEditRow.click();
    }

    public void clickCancelDeleteOrEditButton(){
        cancelEditOrDeleteButton.click();
    }

        // Sub function to edit row in table
    public void clickEditRowButton(){
            editRowButton.click();
        }

    public void clickSaveEditItemButton(){
        saveEditButton.click();
    }

       // Sub function to delet row in table

    public void clickDeleteRowButton(){
        deleteRowButton.click();
    }

    public void clickConfirmDeleteItemRow(){
        confirmDeleteButton.click();
    }
    // Global function about navigate table function
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

    // Global filter to filter row in table
    public void clickSelectFilterByRow(){
        selectFilterByRow.click();
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

    // Global function to get the pagination displayed information
    public String getPaginationDisplayedInformation(){
        return paginationDisplayedInfo.getText();
    }

    public String getTextFromTopmostRowFirstColumn() {
        try {
            String xpath = "//table[contains(@class, 'MuiTable-root')]/tbody/tr[1]/td[1]";
            return yourTable.findElement(By.xpath(xpath)).getText();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    public String getTextFromTopmostRowSecondColumn() {
        try {
            String xpath = "//table[contains(@class, 'MuiTable-root')]/tbody/tr[1]/td[2]";
            return yourTable.findElement(By.xpath(xpath)).getText();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    public String getTextFromTopmostRowForthColumn() {
        try {
            String xpath = "//table[contains(@class, 'MuiTable-root')]/tbody/tr[1]/td[4]";
            return yourTable.findElement(By.xpath(xpath)).getText();
        } catch (NoSuchElementException e) {
            return "";
        }
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

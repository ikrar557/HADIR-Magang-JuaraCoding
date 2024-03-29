package com.juaracoding.pages.admin;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminJabatanPage {
    private WebDriver driver;

    public AdminJabatanPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="search")
    private WebElement searchField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//button[normalize-space()='Reset']")
    private WebElement resetButton;

    @FindBy(xpath = "//button[normalize-space()='Tambahkan']")
    private WebElement tambahkanButton;

    @FindBy(xpath = "//button[normalize-space()='Tambah']")
    private WebElement simpanButton;

    @FindBy(xpath = "//button[normalize-space()='Batal']")
    private WebElement batalButton;

    @FindBy(id="name")
    private WebElement nameField;

    @FindBy(id="level")
    private WebElement levelField;

    @FindBy(xpath = "/html/body/div[1]/div/div/div/div[1]/div/div/div/div[2]/div/table/tbody/tr[3]/td[3]/div/div/button") // TODO: TODO: CURRENT ROW: 3 change this to target row"
    private WebElement verticalEllipsisButton;

    @FindBy(xpath = "/html/body/div[4]/div[3]/ul/li[1]") // TODO: CURRENT ROW: 3 change this to target row
    private WebElement editButton;

    @FindBy(xpath = "/html/body/div[4]/div[3]/ul/li[2]") // TODO: CURRENT ROW: 3 change this to target row
    private WebElement deleteButton;
    
    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium css-4075ia']")
    private WebElement deleteConfirmationButton;

    @FindBy(xpath = "//button[contains(@class, 'css-18ozr2e')]")
    private WebElement deleteConfirmationCancelButton;

    @FindBy(xpath = "//*[@id='mui-1']")
    private WebElement rowPerPageDropdown;

    @FindBy(xpath = "//button[@title='Go to first page']")
    private WebElement firstPageButton;

    @FindBy(xpath = "//button[@title='Go to last page']")
    private WebElement lastPageButton;

    @FindBy(xpath = "//button[@title='Go to previous page']")
    private WebElement previousPageButton;

    @FindBy(xpath = "//button[@title='Go to next page']")
    private WebElement nextPageButton;



    public void inputSearchField(String search){
        searchField.sendKeys(search);
    }

    public void clickSearchButton(){
        searchButton.click();
    }

    public void clickResetButton(){
        resetButton.click();
    }

    public void clickTambahkanButton(){
        tambahkanButton.click();
    }

    public void clickSimpanButton(){
        simpanButton.click();
    }

    public void clickBatalButton(){
        batalButton.click();
    }

    public void inputNameField(String name){
        nameField.sendKeys(name);
    }

    public void inputLevelField(String level){
        levelField.sendKeys(level);
    }

    public void clickVerticalEllipsisButton(){
        verticalEllipsisButton.click();
    }

    public void clickEditButton(){
        editButton.click();
    }

    public void clickDeleteButton(){
        deleteButton.click();
    }

    public void clickDeleteConfirmationButton(){
        deleteConfirmationButton.click();
    }

    public void clickDeleteConfirmationCancelButton(){
        deleteConfirmationCancelButton.click();
    }

    public void clickRowPerPageDropdown(){
        rowPerPageDropdown.click();
    }

    public void clickFirstPageButton(){
        firstPageButton.click();
    }

    public void clickLastPageButton(){
        lastPageButton.click();
    }

    public void clickPreviousPageButton(){
        previousPageButton.click();
    }

    public void clickNextPageButton(){
        nextPageButton.click();
    }

}

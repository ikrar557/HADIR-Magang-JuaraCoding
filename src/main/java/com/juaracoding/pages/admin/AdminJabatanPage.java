package com.juaracoding.pages.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminJabatanPage {
    private WebDriver driver;

    public AdminJabatanPage(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@id='search']")
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

    @FindBy(xpath = "//*[@id='name']")
    private WebElement nameField;

    @FindBy(xpath = "//*[@id='level']")
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



    private void inputSearchField(String search){
        searchField.sendKeys(search);
    }

    private void clickSearchButton(){
        searchButton.click();
    }

    private void clickResetButton(){
        resetButton.click();
    }

    private void clickTambahkanButton(){
        tambahkanButton.click();
    }

    private void clickSimpanButton(){
        simpanButton.click();
    }

    private void clickBatalButton(){
        batalButton.click();
    }

    private void inputNameField(String name){
        nameField.sendKeys(name);
    }

    private void inputLevelField(String level){
        levelField.sendKeys(level);
    }

    private void clickVerticalEllipsisButton(){
        verticalEllipsisButton.click();
    }

    private void clickEditButton(){
        editButton.click();
    }

    private void clickDeleteButton(){
        deleteButton.click();
    }

    private void clickDeleteConfirmationButton(){
        deleteConfirmationButton.click();
    }

    private void clickDeleteConfirmationCancelButton(){
        deleteConfirmationCancelButton.click();
    }

    private void clickRowPerPageDropdown(){
        rowPerPageDropdown.click();
    }

    private void clickFirstPageButton(){
        firstPageButton.click();
    }

    private void clickLastPageButton(){
        lastPageButton.click();
    }

    private void clickPreviousPageButton(){
        previousPageButton.click();
    }

    private void clickNextPageButton(){
        nextPageButton.click();
    }

}

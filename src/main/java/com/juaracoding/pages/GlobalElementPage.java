package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;


public class GlobalElementPage {
    private WebDriver driver;

    public GlobalElementPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    public static WebElement email;

    @FindBy(id = "password")
    public static WebElement password;

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
    @FindBy(css=".MuiButton-textWarning")
    private WebElement resetSearchButton;

    @FindBy(css = ".MuiSelect-select")
    private WebElement selectFilterByRow;

    @FindBy(xpath="//li[contains(.,'5')]")
    public static WebElement filterRowBy5;

    @FindBy(xpath="//li[contains(.,'10')]")
    public static WebElement filterRowBy10;

    @FindBy(xpath="//li[contains(.,'25')]")
    public static WebElement filterRowBy25;

    public void setEmail(String setEmail){
        email.sendKeys(setEmail);
    }

    public void setPassword(String setPassword){
        password.sendKeys(setPassword);
    }

    public void clickResetSearchButton(){
        resetSearchButton.click();
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


}

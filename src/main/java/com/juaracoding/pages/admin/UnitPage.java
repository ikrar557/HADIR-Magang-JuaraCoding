package com.juaracoding.pages.admin;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.GlobalElementPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UnitPage {
    private WebDriver driver;
    private GlobalElementPage globalElementPage;
    public UnitPage(){
        this.driver = DriverSingleton.getDriver();
        this.globalElementPage = new GlobalElementPage();

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='name']")
    private WebElement inputNewUnit;

    @FindBy(css =".MuiFormHelperText-sizeSmall")
    private WebElement blankInputNewUnitMessage;

    public void setInputNewUnit(String newUnitName){
        this.inputNewUnit.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        this.inputNewUnit.sendKeys(Keys.DELETE);
        this.inputNewUnit.sendKeys(newUnitName);
    }

    public String getBlankInputNewUnitMessage(){
        return blankInputNewUnitMessage.getText();
    }

}

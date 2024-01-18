package com.juaracoding.pages.admin;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.GlobalElementPage;
import io.cucumber.java.zh_tw.假設;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;

public class PosisiPage {
    private WebDriver driver;
    private GlobalElementPage globalElementPage;

    public PosisiPage(){
        this.driver = DriverSingleton.getDriver();
        this.globalElementPage = new GlobalElementPage();

        PageFactory.initElements(driver, this);
    }


    @FindBy(css = ".MuiSelect-outlined")
    private WebElement openUnitDropDownOption;
    public void clickOpenUnitDropDownOption(){
        openUnitDropDownOption.click();
    }

    public void setUnitDropDownOptions(String optionText) {
        clickOpenUnitDropDownOption();

        WebDriverWait wait = new WebDriverWait(driver, 10);

        // Use WebDriverWait to wait until the dropdown options are visible
        WebElement optionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='" + optionText + "']")));

        // Use Actions class to move to the option and click it
        Actions actions = new Actions(driver);
        actions.moveToElement(optionElement).click().build().perform();

        // Perform any additional actions or assertions after selecting the value
    }
}

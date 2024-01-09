package com.juaracoding.pages.staff;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.utils.Constant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.juaracoding.utils.Constant.*;

public class StaffLoginPage {
    private WebDriver driver;

    public StaffLoginPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(css= ".MuiButton-contained")
    public static WebElement staffLoginButton;
    @FindBy(xpath="(//button[@type='button'])[4]")
    private WebElement linkMoveToRegisterPage;

    public void clickStaffLoginButton(){
        staffLoginButton.click();
    }

    public void clickLinkMoveToRegisterPage(){
        linkMoveToRegisterPage.click();
    }
}

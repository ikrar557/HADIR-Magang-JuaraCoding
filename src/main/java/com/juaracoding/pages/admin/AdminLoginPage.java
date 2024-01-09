package com.juaracoding.pages.admin;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.juaracoding.utils.Constant;
import static com.juaracoding.utils.Constant.*;

public class AdminLoginPage {
    private WebDriver driver;

    public AdminLoginPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".MuiButton-root")
    private WebElement adminLoginButton;

    public void clickAdminLoginButton(){
        adminLoginButton.click();
    }
}

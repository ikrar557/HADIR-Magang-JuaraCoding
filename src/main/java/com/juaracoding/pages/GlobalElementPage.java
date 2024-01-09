package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.juaracoding.utils.Constant.email;
import static com.juaracoding.utils.Constant.password;

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

    public void setEmail(String setEmail){
        email.sendKeys(setEmail);
    }

    public void setPassword(String setPassword){
        password.sendKeys(setPassword);
    }
}

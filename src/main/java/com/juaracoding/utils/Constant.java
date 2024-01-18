package com.juaracoding.utils;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Constant {
    private WebDriver driver;

    public Constant(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }
    public final static long TIMEOUT = 10;

    public final static String STAFF_URL = "https://staging-hadir.ptkta.com/absen/login";

    public final static String ADMIN_URL = "https://dev.dikahadir.com/authentication/login";

    @FindBy(id = "email")
    public static WebElement email;

    @FindBy(id = "password")
    public static WebElement password;

    @FindBy(css = ".MuiButton-root")
    public static WebElement adminLoginButton;

}

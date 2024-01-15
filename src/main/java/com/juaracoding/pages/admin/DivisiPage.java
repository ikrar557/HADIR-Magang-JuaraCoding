package com.juaracoding.pages.admin;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.GlobalElementPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class DivisiPage {
    private WebDriver driver;
    private GlobalElementPage globalElementPage;

    public DivisiPage(){
        this.driver = DriverSingleton.getDriver();
        this.globalElementPage = new GlobalElementPage();

        PageFactory.initElements(driver, this);
    }

}

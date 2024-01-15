package com.juaracoding.pages.admin;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.GlobalElementPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class UnitPage {
    private WebDriver driver;
    private GlobalElementPage globalElementPage;
    public UnitPage(){
        this.driver = DriverSingleton.getDriver();
        this.globalElementPage = new GlobalElementPage();

        PageFactory.initElements(driver, this);
    }
}

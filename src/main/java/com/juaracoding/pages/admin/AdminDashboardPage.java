package com.juaracoding.pages.admin;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminDashboardPage {
    private WebDriver driver;

    public AdminDashboardPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p[.='Management']")
    private WebElement  managementSideBar;

//    Element exists once you click the management sidebar
    @FindBy(xpath = "//p[.='Divisi']")
    private WebElement divisiSideBar;

    public void clickManagementSideBar(){
        managementSideBar.click();
    }

    public void clickDivisiSideBar(){
        divisiSideBar.click();
    }


}

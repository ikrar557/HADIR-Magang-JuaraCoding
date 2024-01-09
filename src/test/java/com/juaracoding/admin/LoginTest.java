package com.juaracoding.admin;

import com.juaracoding.pages.admin.AdminLoginPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import com.juaracoding.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
    private static WebDriver driver;

    private static ExtentTest extentTest;

    private static AdminLoginPage adminLoginPage = new AdminLoginPage();

    public LoginTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @Given("User enter admin login page")
    public void user_enter_admin_login_page(){
        String adminURL = "https://staging-hadir.ptkta.com/authentication/login";
        driver.get(adminURL);
        Assert.assertEquals(driver.getCurrentUrl(), adminURL);
    }

    @When("User enter email")
    public void user_enter_email(){
        adminLoginPage.setEmail("admin@hadir.com");
        extentTest.log(LogStatus.PASS, "User enter email");
    }

    @And("User enter password")
    public void user_enter_password(){
        adminLoginPage.setPassword("admin@hadir");
        extentTest.log(LogStatus.PASS, "User enter password");
    }

    @And("User click login button")
    public void user_click_login_button(){
        adminLoginPage.clickLoginButton();
        extentTest.log(LogStatus.PASS, "User click login button");
    }

    @Then("User login successful")
    public void user_login_successful(){
        extentTest.log(LogStatus.PASS, "User login successful");
    }
}

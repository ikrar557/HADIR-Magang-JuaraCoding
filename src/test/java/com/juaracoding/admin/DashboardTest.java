package com.juaracoding.admin;

import com.juaracoding.Hooks;
import com.juaracoding.pages.admin.AdminDashboardPage;
import com.juaracoding.pages.admin.AdminLoginPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class DashboardTest {
    private static WebDriver driver;

    private static ExtentTest extentTest;

    private static AdminDashboardPage adminDashboardPage = new AdminDashboardPage();

    public DashboardTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @Given("User click management sidebar")
    public void user_click_management_sidebar(){
        adminDashboardPage.clickManagementSideBar();
        extentTest.log(LogStatus.PASS, "User click management sidebar");
    }

//    @When("User click division sidebar")
//    public void user_click_division_sidebar(){
//        adminDashboardPage.clickDivisiSideBar();
//        extentTest.log(LogStatus.PASS, "User click division sidebar");
//    }
//
//    @Then("User success move to division menu")
//    public void user_success_move_to_division_menu(){
//        extentTest.log(LogStatus.PASS, "User success move to division menu");
//    }

//    @When("User click unit sidebar")
//    public void user_click_unit_sidebar(){
//        adminDashboardPage.clickUnitSideBar();
//        extentTest.log(LogStatus.PASS, "User click unit sidebar");
//    }
//
//    @Then("User success move to unit menu")
//    public void user_success_move_to_unit_menu(){
//        extentTest.log(LogStatus.PASS, "User success move to unit menu");
//    }

    @When("User click client upliner sidebar")
    public void user_click_client_upliner_sidebar(){
        adminDashboardPage.clickClientUplinerSidebar();
        extentTest.log(LogStatus.PASS, "User click client upliner sidebar");
    }

    @Then("User success move to client upliner menu")
    public void user_success_move_to_client_upliner_menu(){
        extentTest.log(LogStatus.PASS, "User success move to client upliner menu");
    }
}

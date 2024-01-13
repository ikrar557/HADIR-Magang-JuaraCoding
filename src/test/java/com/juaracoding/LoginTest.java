package com.juaracoding;

import com.juaracoding.pages.GlobalElementPage;
import com.juaracoding.pages.admin.AdminLoginPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static com.juaracoding.utils.Constant.*;

public class LoginTest {

    private static WebDriver driver;

    private static ExtentTest extentTest;

    public static GlobalElementPage globalElementPage = new GlobalElementPage();
    public static AdminLoginPage adminLoginPage = new AdminLoginPage();

    public LoginTest() {
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    // TODO : Make the cucumber able to login to staff and admin pages with single feature

    // #1 Scenario : Input URL Benar
    @Given("Input url Absen Hadir yang benar")
    public void input_url_absen_hadir_yang_benar() {
        driver.get(ADMIN_URL);
        Assert.assertEquals(driver.getCurrentUrl(), ADMIN_URL);
        extentTest.log(LogStatus.PASS, "Input url Absen Hadir yang benar");
    }

    @When("Klik tombol enter pada keyboard")
    public void klik_tombol_enter_pada_keyboard() {
        extentTest.log(LogStatus.PASS, "Klik tombol enter pada keyboard");
    }

    @Then("Menampilkan halaman login")
    public void menampilkan_halaman_login() {
        extentTest.log(LogStatus.PASS, "Menampilkan halaman login");
        // TODO: Tambah verifikasi bahwa sudah benar di halaman login
    }

    // #2 Scenario : Input valid username dan password
    @Given("Input username yang terdaftar")
    public void input_username_yang_terdaftar(){
        globalElementPage.setEmail("admin@hadir.com");
        extentTest.log(LogStatus.PASS, "Input username yang terdaftar");
    }

    @When("Input password yang terdaftar")
    public void input_password_yang_terdaftar(){
        globalElementPage.setPassword("admin@hadir");
        extentTest.log(LogStatus.PASS, "Input username yang terdaftar");
    }

    @And("Klik tombol Sign In")
    public void klik_tombol_sign_in(){
        adminLoginPage.clickAdminLoginButton();
        extentTest.log(LogStatus.PASS, "Klik tombol Sign In");
    }

    @Then("Berhasil masuk ke halaman dashboard")
    public void berhasil_masuk_ke_halaman_dashboard(){
        extentTest.log(LogStatus.PASS, "Berhasil masuk ke halaman dashboard");
        // TODO: Tambah verifikasi bahwa sudah berhasil masuk ke dashboard
    }


}
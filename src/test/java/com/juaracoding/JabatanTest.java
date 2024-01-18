package com.juaracoding;

import TestNG.template.AdminLogin;
import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.GlobalElementPage;
import com.juaracoding.pages.admin.AdminJabatanPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static com.juaracoding.utils.Constant.JABATAN_URL;

public class JabatanTest {

    private static WebDriver driver;
    private static ExtentTest extentTest;
    public static GlobalElementPage globalElementPage = new GlobalElementPage();
    public static AdminJabatanPage adminJabatanPage = new AdminJabatanPage();
    private final AdminLogin adminLogin;

    public JabatanTest() {
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;

        adminLogin = new AdminLogin(
                globalElementPage,
                driver,
                JABATAN_URL
        );
    }

    // #1 Scenario : Search Jabatan
    @Given("Login sebagai admin")
    public void login_sebagai_admin() {
        adminLogin.loginUser();
        extentTest.log(LogStatus.PASS, "Login sebagai admin");
    }

    @When("Input 99 pada search field")
    public void input_99_pada_search_field() {
        adminJabatanPage.inputSearchField("99");
        extentTest.log(LogStatus.PASS, "Input 99 pada search field");
    }

    @And("Klik tombol search")
    public void klik_tombol_search() {
        adminJabatanPage.clickSearchButton();
        extentTest.log(LogStatus.PASS, "Klik tombol search");
    }

    @Then("Menampilkan jabatan dengan level 99")
    public void menampilkan_jabatan_dengan_level_99() {
        DriverSingleton.delay(1);
        Assert.assertTrue(driver.getPageSource().contains("Test Search Jabatan"));
        extentTest.log(LogStatus.PASS, "Menampilkan jabatan dengan level 99");
    }

    // # 2 Scenario : Reset Search Jabatan

    @When("Klik tombol reset")
    public void klik_tombol_reset() {
        adminJabatanPage.clickResetButton();
        extentTest.log(LogStatus.PASS, "Klik tombol reset");
    }

    @Then("Menampilkan seluruh jabatan")
    public void menampilkan_seluruh_jabatan() {
        DriverSingleton.delay(1);
        Assert.assertEquals(driver.getCurrentUrl(), JABATAN_URL);
        extentTest.log(LogStatus.PASS, "Menampilkan seluruh jabatan");
    }

    // # 3 Scenario : Add Jabatan
    @When("Klik tombol tambah")
    public void klik_tombol_tambah() {
        adminJabatanPage.clickTambahkanButton();
        extentTest.log(LogStatus.PASS, "Klik tombol tambah");
    }

    @And("Input nama jabatan")
    public void input_nama_jabatan() {
        adminJabatanPage.inputNameField("Boss");
        extentTest.log(LogStatus.PASS, "Input nama jabatan");
    }

    @And("Input level jabatan")
    public void input_level_jabatan() {
        adminJabatanPage.inputLevelField("98");
        extentTest.log(LogStatus.PASS, "Input level jabatan");
    }

    @And("Klik tombol simpan")
    public void klik_tombol_simpan() {
        adminJabatanPage.clickSimpanButton();
        extentTest.log(LogStatus.PASS, "Klik tombol simpan");
    }

    @Then("Menampilkan pop up berhasil menambahkan jabatan")
    public void menampilkan_pop_up_berhasil_menambahkan_jabatan() {
        DriverSingleton.delay(1);
        Assert.assertEquals(adminJabatanPage.getPopUpContent(), "Berhasil Menambahkan Job Level");
        extentTest.log(LogStatus.PASS, "Menampilkan pop up berhasil menambahkan jabatan");
    }

    // # 4 Scenario : Add Jabatan Negative

    @When("Negative Klik tombol tambah")
    public void negative_klik_tombol_tambah() {
        adminJabatanPage.clickTambahkanButton();
        extentTest.log(LogStatus.PASS, "Negative Klik tombol tambah");
    }

    @And("Negative Input nama jabatan")
    public void negative_input_nama_jabatan() {
        adminJabatanPage.inputNameField("Boss");
        extentTest.log(LogStatus.PASS, "Negative Input nama jabatan");
    }

    @And("Negative Input level jabatan")
    public void negative_input_level_jabatan() {
        adminJabatanPage.inputLevelField("Atasan");
        extentTest.log(LogStatus.PASS, "Negative Input level jabatan");
    }

    @And("Negative Klik tombol simpan")
    public void negative_klik_tombol_simpan() {
        adminJabatanPage.clickSimpanButton();
        extentTest.log(LogStatus.PASS, "Negative Klik tombol simpan");
    }

    @Then("Negative Menampilkan pop up gagal menambahkan jabatan")
    public void negative_menampilkan_pop_up_gagal_menambahkan_jabatan() {
        DriverSingleton.delay(1);
        Assert.assertEquals(adminJabatanPage.getPopUpContent(), "Gagal Menambahkan Job Level");
        extentTest.log(LogStatus.PASS, "Negative Menampilkan pop up gagal menambahkan jabatan");
    }

    @Then("Klik tombol batal")
    public void klik_tombol_batal() {
        adminJabatanPage.clickBatalButton();
        extentTest.log(LogStatus.PASS, "Klik tombol batal");
    }

    // # 5 Scenario : Edit Jabatan

    @When("Cari jabatan level 98")
    public void cari_jabatan_level_98() {
        adminJabatanPage.inputSearchField("98");
        adminJabatanPage.clickSearchButton();
        extentTest.log(LogStatus.PASS, "Cari jabatan level 98");
    }

    @And("Klik tombol titik tiga")
    public void klik_tombol_titik_tiga() {
        DriverSingleton.delay(1);
        adminJabatanPage.clickVerticalEllipsisButton();
        extentTest.log(LogStatus.PASS, "Klik tombol titik tiga");
    }

    @And("Klik tombol edit")
    public void klik_tombol_edit() {
        DriverSingleton.delay(1);
        adminJabatanPage.clickEditButton();
        extentTest.log(LogStatus.PASS, "Klik tombol edit");
    }

    @And("Edit nama jabatan")
    public void edit_nama_jabatan() {
        adminJabatanPage.nameField.clear();
        adminJabatanPage.inputNameField("Boss Besar");
        extentTest.log(LogStatus.PASS, "Edit nama jabatan");
    }

    @And("Klik tombol simpan edit")
    public void klik_tombol_simpan_edit() {
        adminJabatanPage.clickSimpanButtonOnEdit();
        DriverSingleton.delay(3);
        extentTest.log(LogStatus.PASS, "Klik tombol simpan edit");
    }

    @Then("Menampilkan jabatan dengan nama Boss Besar")
    public void menampilkan_jabatan_dengan_nama_boss_besar() {
        Assert.assertTrue(driver.getPageSource().contains("Boss Besar"));
        extentTest.log(LogStatus.PASS, "Menampilkan jabatan dengan nama Boss Besar");
    }

    // # 6. Delete Jabatan
    @When("Klik tombol titik tiga untuk dihapus")
    public void klik_tombol_titik_tiga_untuk_dihapus() {
        DriverSingleton.delay(1);
        adminJabatanPage.clickVerticalEllipsisButton();
        extentTest.log(LogStatus.PASS, "Klik tombol titik tiga untuk dihapus");
    }

    @And("Klik tombol hapus")
    public void klik_tombol_hapus() {
        DriverSingleton.delay(1);
        adminJabatanPage.clickDeleteButton();
        extentTest.log(LogStatus.PASS, "Klik tombol hapus");
    }

    @And("Klik tombol konfirmasi hapus")
    public void klik_tombol_konfirmasi_hapus() {
        DriverSingleton.delay(1);
        adminJabatanPage.clickDeleteConfirmationButton();
        extentTest.log(LogStatus.PASS, "Klik tombol konfirmasi hapus");
    }

    @Then("Menampilkan pop up berhasil menghapus jabatan")
    public void menampilkan_pop_up_berhasil_menghapus_jabatan() {
        DriverSingleton.delay(1);
        Assert.assertEquals(adminJabatanPage.getPopUpContent(), "Berhasil Delete Jabatan");
        extentTest.log(LogStatus.PASS, "Menampilkan pop up berhasil menghapus jabatan");
    }
}

package com.juaracoding.admin;

import com.juaracoding.Hooks;
import com.juaracoding.pages.admin.AdminDashboardPage;
import com.juaracoding.pages.admin.DivisiPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.Log;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.zh_cn.而且;
import org.openqa.selenium.WebDriver;

public class DivisiTest {
    private static WebDriver driver;

    private static ExtentTest extentTest;

    private static DivisiPage divisiPage = new DivisiPage();

    public DivisiTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

//    #1 Scenario : Batal tambah divisi baru
    @Given("^Masuk menu \"Divisi\"$")
    public void masuk_menu_divisi(){
        // TODO : ADD verification after in division menu
        extentTest.log(LogStatus.PASS, "^Masuk menu \"Divisi\"$");
    }

    @When("^Klik tombol \"Tambahkan\"$")
    public void klik_tombol_tambahkan(){
        divisiPage.clickAddNewDivisionButton();
        extentTest.log(LogStatus.PASS, "^Klik tombol \"Tambahkan\"$");
    }

    @And("Masukan nama divisi baru")
    public void masukan_nama_divisi_baru(){
        divisiPage.setDivisionName("Juara Coding");
        extentTest.log(LogStatus.PASS, "Masukan nama divisi baru");
    }

    @And("^Klik tombol \"Batal\"$")
    public void klik_tombol_batal(){
        divisiPage.clickCancelAddNewDivisionButton();
        extentTest.log(LogStatus.PASS, "^Klik tombol \"Batal\"$");
    }

    @Then("Kembali ke daftar divisi, divisi baru batal di tambahkan")
    public void kembali_ke_daftar_divisi_divisi_baru_batal_di_tambahkan(){
        // TODO : Add verification after cancel to add new division
        extentTest.log(LogStatus.PASS, "Kembali ke daftar divisi, divisi baru batal di tambahkan");
    }

//    #2 Scenario : Input divisi baru dengan jumlah karakter lebih dari 255
    @And("Masukan random karakter yang lebih dari 255")
    public void masukan_random_karakter_yang_lebih_dari_255(){
        divisiPage.setDivisionName("fpiicougncpztofjvzpkjlbsqexghfdeuykucvzewrlqhxbwfxvwojnbzzmwwzikhcyfansdedqcrxjdcxowntjyvgsboghzpkdjuonqfvcmhrjuqjighcsidaqbdtztywrjwfznjbpzjsosoxkgwxfjzjalrefiilkbrlambaevduzdeayescirtnozlxqyxvnstbvxjbnyuiaoqskpiksharedtubicqnqaltxhezjneipvvzcfoygfcznalqw");
        extentTest.log(LogStatus.PASS, "Masukan random karakter yang lebih dari 255");
    }

    @And("^Klik tombol \"Tambah\"$")
    public void klik_tombol_tambah(){
        divisiPage.clickSaveEditDivisionButton();
        extentTest.log(LogStatus.PASS, "^Klik tombol \"Tambah\"$");
    }

    @Then("^Muncul pop-up \"Gagal menambahkan divisi\"$")
    public void muncul_pop_up_gagal_menambahkan_divsi(){
//        TODO : Add validation to check the popup
        extentTest.log(LogStatus.PASS, "^Muncul pop-up \"Gagal menambahkan divisi\"$");
    }

//    #3 Scenario : Input divisi baru benar
    @Then("Divisi baru berhasil ditambahkan")
    public void divisi_baru_berhasil_ditambahkan(){
//        TODO : Add test validation to check if the new division successfully added
        extentTest.log(LogStatus.PASS, "Divisi baru berhasil ditambahkan");
    }

//    #4 Scenario : Input divisi baru dengan nama yang sama
    @Then("Divisi baru gagal ditambahkan, divisi sudah tersedia")
    public void divisi_baru_gagal_ditambahkan_divisi_sudah_tersedia(){
//        TODO: Add test validation for the error
        extentTest.log(LogStatus.PASS, "Divisi baru gagal ditambahkan, divisi sudah tersedia");
    }

//    #5 Scenario : Input divisi dengan nama blank atau kosong
    @And("Masukan input kosong")
    public void masukan_input_kosong(){
        divisiPage.setDivisionName("");
        extentTest.log(LogStatus.PASS, "Masukan input kosong");
    }

    @Then("^Divisi gagal ditambahkan, muncul pop-up \"Please fill out the field\"$")
    public void divisi_gagal_ditambahkan_muncul_pop_up_please_fill_out_the_field(){
//        TODO: Add test validation for the pop-up error
        extentTest.log(LogStatus.PASS, "^Divisi gagal ditambahkan, muncul pop-up \"Please fill out the field\"$");
    }
}

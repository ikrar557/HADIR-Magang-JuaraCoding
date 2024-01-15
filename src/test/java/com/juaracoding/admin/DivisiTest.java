package com.juaracoding.admin;

import com.juaracoding.Hooks;
import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.GlobalElementPage;
import com.juaracoding.pages.admin.DivisiPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DivisiTest {
    private static WebDriver driver;

    private static ExtentTest extentTest;

    private static DivisiPage divisiPage = new DivisiPage();
    private static GlobalElementPage globalElementPage = new GlobalElementPage();
    public DivisiTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

//  #1 Scenario : Batal tambah divisi baru
    @Given("Masuk menu \"Divisi\"")
    public void masuk_menu_divisi(){
        Assert.assertEquals(globalElementPage.getTitleText(), "Divisi");
        extentTest.log(LogStatus.PASS, "Masuk menu \"Divisi\"");
    }

    @When("Klik tombol \"Tambahkan\"")
    public void klik_tombol_tambahkan(){
        globalElementPage.clickAddNewItemButton();
        extentTest.log(LogStatus.PASS, "Klik tombol \"Tambahkan\"");
    }

    @And("Masukan nama divisi baru")
    public void masukan_nama_divisi_baru(){
        globalElementPage.setNewItemName("JC-SQA 12");
        extentTest.log(LogStatus.PASS, "Masukan nama divisi baru");
    }

    @And("Klik tombol \"Batal\"")
    public void klik_tombol_batal(){
        globalElementPage.clickCancelAddNewItemButton();
        extentTest.log(LogStatus.PASS, "Klik tombol \"Batal\"");
    }

    @Then("Kembali ke daftar divisi, divisi baru batal di tambahkan")
    public void kembali_ke_daftar_divisi_divisi_baru_batal_di_tambahkan(){
        globalElementPage.setSearchName("JC-SQA 12");
        globalElementPage.clickSearchSubmitButton();
        DriverSingleton.delay(1);

        Assert.assertEquals(globalElementPage.getCountOfRowsInFirstColumn(), 0);
        extentTest.log(LogStatus.PASS, "Kembali ke daftar divisi, divisi baru batal di tambahkan");
    }

//  #2 Scenario : Input divisi baru dengan jumlah karakter lebih dari 255
    @And("Masukan random karakter yang lebih dari 255")
    public void masukan_random_karakter_yang_lebih_dari_255(){
        globalElementPage.setNewItemName("fpiicougncpztofjvzpkjlbsqexghfdeuykucvzewrlqhxbwfxvwojnbzzmwwzikhcyfansdedqcrxjdcxowntjyvgsboghzpkdjuonqfvcmhrjuqjighcsidaqbdtztywrjwfznjbpzjsosoxkgwxfjzjalrefiilkbrlambaevduzdeayescirtnozlxqyxvnstbvxjbnyuiaoqskpiksharedtubicqnqaltxhezjneipvvzcfoygfcznalqw");
        extentTest.log(LogStatus.PASS, "Masukan random karakter yang lebih dari 255");
    }

    @And("Klik tombol \"Tambah\"")
    public void klik_tombol_tambah(){
        globalElementPage.clickSaveNewItemButton();
        extentTest.log(LogStatus.PASS, "Klik tombol \"Tambah\"");
    }

    @Then("Muncul pop-up \"Gagal menambahkan divisi\"")
    public void muncul_pop_up_gagal_menambahkan_divsi(){
        Assert.assertEquals(globalElementPage.getErrorNewItem(), "Gagal Menambahkan Divisi");

        extentTest.log(LogStatus.PASS, "Muncul pop-up \"Gagal menambahkan divisi\"");

        globalElementPage.clickCancelAddNewItemButton();
    }

//  #3 Scenario : Input divisi baru benar
    @Then("Divisi baru berhasil ditambahkan")
    public void divisi_baru_berhasil_ditambahkan(){
        DriverSingleton.delay(1);
        globalElementPage.clickSearchSubmitButton();
        DriverSingleton.delay(1);
        Assert.assertEquals(globalElementPage.getTextFromTopmostRowFirstColumn(), "JC-SQA 12");

        extentTest.log(LogStatus.PASS, "Divisi baru berhasil ditambahkan");
    }

//  #4 Scenario : Input divisi baru dengan nama yang sama
    @Then("Divisi baru gagal ditambahkan, divisi sudah tersedia")
    public void divisi_baru_gagal_ditambahkan_divisi_sudah_tersedia(){
        DriverSingleton.delay(1);
        globalElementPage.clickSearchSubmitButton();
        DriverSingleton.delay(1);
        Assert.assertEquals(globalElementPage.getCountOfTextInFirstColumn("JC-SQA 12"), 1);

        extentTest.log(LogStatus.PASS, "Divisi baru gagal ditambahkan, divisi sudah tersedia");
    }

//  #5 Scenario : Input divisi dengan nama blank atau kosong
    @And("Masukan input kosong")
    public void masukan_input_kosong(){
        globalElementPage.setNewItemName("");
        extentTest.log(LogStatus.PASS, "Masukan input kosong");
    }

    @Then("Divisi gagal ditambahkan, muncul pop-up \"Please fill out the field\"")
    public void divisi_gagal_ditambahkan_muncul_pop_up_please_fill_out_the_field(){
        Assert.assertEquals(globalElementPage.getValidationMessage(), "Please fill out this field.");

        extentTest.log(LogStatus.PASS, "Divisi gagal ditambahkan, muncul pop-up \"Please fill out the field\"");
        globalElementPage.clickCancelAddNewItemButton();
    }

//  #6 Scenario : Cari divisi dengan nama yang tidak ada pada list
    @When("Masukan nama divisi yang tidak ada pada list")
    public void masukan_nama_divisi_yang_tidak_ada_pada_list(){
        DriverSingleton.delay(1);
        globalElementPage.setSearchName("Codingan");

        extentTest.log(LogStatus.PASS, "Masukan nama divisi yang tidak ada pada list");
    }

    @And("Klik tombol \"Search\"")
    public void klik_tombol_search(){
        globalElementPage.clickSearchSubmitButton();
        DriverSingleton.delay(1);
        extentTest.log(LogStatus.PASS, "Klik tombol \"Search\"");
    }

    @Then("Tidak muncul divisi yang dicari")
    public void tidak_muncul_divisi_yang_dicari(){
        Assert.assertEquals(globalElementPage.getCountOfRowsInFirstColumn(), 0);
        extentTest.log(LogStatus.PASS, "Tidak muncul divisi yang dicari");
    }

//  #7 Scenario: Reset pencarian divisi
    @When("Masukan nama divisi pada kolom pencarian")
    public void masukan_nama_divisi_pada_kolom_pencarian(){
        globalElementPage.setSearchName("JC-SQA 12");
        extentTest.log(LogStatus.PASS, "Masukan nama divisi pada kolom pencarian");
    }
    @And("Muncul divisi yang dicari")
    public void muncul_divisi_yang_dicari(){
        Assert.assertEquals(globalElementPage.getTextFromTopmostRowFirstColumn(), "JC-SQA 12");

        extentTest.log(LogStatus.PASS, "Muncul divisi yang dicari");
    }

    @And("Klik tombol \"Reset\"")
    public void klik_tombol_reset(){
        globalElementPage.clickResetSearchButton();
        extentTest.log(LogStatus.PASS, "Klik tombol \"Reset\"");
    }

    @Then("Daftar divisi kembali ke semula")
    public void daftar_divisi_kembali_ke_semula(){
        Assert.assertEquals(globalElementPage.getTextFromSearchButton(), "");

        extentTest.log(LogStatus.PASS, "Daftar divisi kembali ke semula");
    }

//  #8 Scenario: Cari divisi dengan nama "JC-SQA 12" (Done)

//  #9 Scenario: Batal edit divisi dengan nama "JC-SQA 12" menjadi "JC-SQA Batch 12"
    @Given("Cari divisi pada kolom pencarian")
    public void cari_divisi_pada_kolom_pencarian(){
        globalElementPage.setSearchName("JC-SQA 12");
        globalElementPage.clickSearchSubmitButton();
        DriverSingleton.delay(1);

        Assert.assertEquals(globalElementPage.getTextFromTopmostRowFirstColumn(), "JC-SQA 12");
        extentTest.log(LogStatus.PASS, "Cari divisi pada kolom pencarian");
    }

    @When("Klik icon 3 baris pada sisi kanan baris divisi yang dicari")
    public void klik_icon_3_baris_pada_sisi_kanan_baris_divisi_yang_dicari(){
        globalElementPage.clickEditOrDeleteRowButton();
        extentTest.log(LogStatus.PASS, "Klik icon 3 baris pada sisi kanan baris divisi yang dicari");
    }

    @And("Klik \"Edit\"")
    public void klik_edit(){
        globalElementPage.clickEditRowButton();
        DriverSingleton.delay(1);
        extentTest.log(LogStatus.PASS, "Klik \"Edit\"");
    }

    @And("Rubah \"Nama Divisi\" menjadi nama divisi baru")
    public void rubah_nama_divisi_menjadi_nama_divis_baru(){
        globalElementPage.setNewItemName("JC-SQA Batch 12");
        extentTest.log(LogStatus.PASS, "Rubah \"Nama Divisi\" menjadi nama divisi baru");
    }

    @And("Klik \"Batal\"")
    public void klik_batal(){
        globalElementPage.clickCancelDeleteOrEditButton();
        extentTest.log(LogStatus.PASS, "Klik \"Batal\"");
    }

    @Then("Nama divisi masih nama divisi lama")
    public void nama_divisi_masih_nama_divisi_lama(){
        driver.navigate().refresh();

        Assert.assertEquals(globalElementPage.getCountOfTextInFirstColumn("JC-SQA 12"), 2);
        extentTest.log(LogStatus.PASS, "Nama divisi masih nama divisi lama");
    }

//  #10 Scenario: Edit divisi dengan nama "JC-SQA 12" menjadi "JC-SQA Batch 12"
    @And("Klik \"Simpan\"")
    public void klik_simpan(){
        globalElementPage.clickSaveEditItemButton();
        DriverSingleton.delay(1);
        extentTest.log(LogStatus.PASS, "Klik \"Simpan\"");
    }

    @Then("Nama divisi lama ganti menjadi nama divisi baru")
    public void nama_divisi_lama_ganti_menjadi_nama_divisi_baru(){
        globalElementPage.clickResetSearchButton();
        DriverSingleton.delay(1);
        globalElementPage.setSearchName("JC-SQA Batch 12");
        globalElementPage.clickSearchSubmitButton();
        DriverSingleton.delay(1);

        Assert.assertEquals(globalElementPage.getCountOfTextInFirstColumn("JC-SQA Batch 12"), 1);
        extentTest.log(LogStatus.PASS, "Nama divisi lama ganti menjadi nama divisi baru");
    }

//  #11 Scenario: Edit divisi yang sudah ditambahkan dengan nama yang sama
    @Then("Nama divisi lama gagal di ganti menjadi nama divisi baru karena nama sudah tersedia")
    public void nama_divisi_lama_gagal_di_ganti_menjadi_nama_divisi_baru_karena_nama_sudah_tersedia(){
        globalElementPage.clickResetSearchButton();
        DriverSingleton.delay(1);
        globalElementPage.setSearchName("JC-SQA Batch 12");
        globalElementPage.clickSearchSubmitButton();
        DriverSingleton.delay(1);

        Assert.assertEquals(globalElementPage.getCountOfTextInFirstColumn("JC-SQA Batch 12"), 1);
        extentTest.log(LogStatus.PASS, "Nama divisi lama gagal di ganti menjadi nama divisi baru karena nama sudah tersedia");
    }

//  #12 Scenario: Batal delete divisi yang sudah di tambahkan
    @Given("Cari nama divisi baru pada kolom pencarian")
    public void cari_nama_divisi_baru_pada_kolom_pencarian(){
        globalElementPage.clickResetSearchButton();
        DriverSingleton.delay(1);
        globalElementPage.setSearchName("JC-SQA Batch 12");
        globalElementPage.clickSearchSubmitButton();
        DriverSingleton.delay(1);

        extentTest.log(LogStatus.PASS, "Cari nama divisi baru pada kolom pencarian");
    }

    @And("Klik \"Delete\"")
    public void klik_delete(){
        globalElementPage.clickDeleteRowButton();
        DriverSingleton.delay(1);
        extentTest.log(LogStatus.PASS, "Klik \"Delete\"");
    }

    @And("Klik \"Tidak\"")
    public void klik_tidak(){
        globalElementPage.clickCancelDeleteOrEditButton();
        driver.navigate().refresh();
        DriverSingleton.delay(1);

        extentTest.log(LogStatus.PASS, "Klik \"Tidak\"");
    }

    @Then("Divisi baru masih ada pada daftar divisi")
    public void divisi_baru_masih_ada_pada_daftar_divisi(){
        Assert.assertEquals(globalElementPage.getCountOfTextInFirstColumn("JC-SQA Batch 12"), 2);
        extentTest.log(LogStatus.PASS, "Divisi baru masih ada pada daftar divisi");
    }

//  #13 Scenario: Delete divisi yang sudah di tambahkan
    @And("Klik \"Ya\"")
    public void klik_ya(){
        globalElementPage.clickConfirmDeleteItemRow();
        DriverSingleton.delay(1);
        globalElementPage.clickSearchSubmitButton();
        extentTest.log(LogStatus.PASS, "Klik \"Ya\"");
    }

    @Then("Divisi baru berhasil dihapus dari daftar divisi")
    public void divisi_baru_berhasil_dihapus_dari_daftar_divisi(){
        DriverSingleton.delay(1);

        Assert.assertEquals(globalElementPage.getCountOfTextInFirstColumn("JC-SQA Batch 12"), 1);
        extentTest.log(LogStatus.PASS, "Divisi baru berhasil dihapus dari daftar divisi");

        globalElementPage.clickResetSearchButton();
    }

//  #14 Scenario: Filter jumlah baris yang ditampilkan menjadi 5 baris pada setiap halaman
    @Given("Scroll ke bawah halaman")
    public void scroll_ke_bawah_halaman(){
        globalElementPage.scrollPageToBottom();
        extentTest.log(LogStatus.PASS, "Scroll ke bawah halaman");
    }

    @When("Klik drop down di samping Rows per page")
    public void klik_drop_down_di_samping_rows_per_page(){
        globalElementPage.clickSelectFilterByRow();
        extentTest.log(LogStatus.PASS, "Klik drop down di samping Rows per page");
    }

    @And("Klik \"5\"")
    public void klik_5(){
        globalElementPage.clickFilterRowBy5();
        DriverSingleton.delay(1);
        extentTest.log(LogStatus.PASS, "Klik \"5\"");
    }

    @Then("Jumlah baris yang ditampilkan adalah 5 baris")
    public void jumlah_baris_yang_ditampilkan_adalah_5_baris(){
        Assert.assertEquals(globalElementPage.getCountOfRowsInFirstColumn(), 5);
        extentTest.log(LogStatus.PASS, "Jumlah baris yang ditampilkan adalah 5 baris");
    }
//  #15 Scenario: Filter jumlah baris yang ditampilkan menjadi 10 baris pada setiap halaman
    @And("Klik \"10\"")
    public void klik_10(){
        globalElementPage.clickFilterRowBy10();
        DriverSingleton.delay(1);
        extentTest.log(LogStatus.PASS, "Klik \"10\"");
    }

    @Then("Jumlah baris yang ditampilkan adalah 10 baris")
    public void jumlah_baris_yang_ditampilkan_adalah_10_baris(){
        Assert.assertEquals(globalElementPage.getCountOfRowsInFirstColumn(), 10);
        extentTest.log(LogStatus.PASS, "Jumlah baris yang ditampilkan adalah 10 baris");
    }
//  #16 Scenario: Filter jumlah baris yang ditampilkan menjadi 25 baris pada setiap halaman
    @And("Klik \"25\"")
    public void klik_25(){
        globalElementPage.clickFilterRowBy25();
        DriverSingleton.delay(1);
        extentTest.log(LogStatus.PASS, "Klik \"25\"");
    }

    @Then("Jumlah baris yang ditampilkan adalah 25 baris")
    public void jumlah_baris_yang_ditampilkan_adalah_25_baris(){
        Assert.assertEquals(globalElementPage.getCountOfRowsInFirstColumn(), 25);
        extentTest.log(LogStatus.PASS, "Jumlah baris yang ditampilkan adalah 25 baris");
    }
    // 17 Scenario : Pindah ke halaman selanjutnya
    // 18 Scenario : Pindah ke halaman sebelumnya
    // 19 Scenario : Pindah ke halaman paling akhir
    // 20 Scenario : Pindah ke halaman paling awal

    // TODO: Add verification to check : Last Page, Next Page, First Page, Previous Page
}

package com.juaracoding.admin;

import com.juaracoding.Hooks;
import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.GlobalElementPage;
import com.juaracoding.pages.admin.UnitPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class UnitTest {
    private static WebDriver driver;
    private static ExtentTest extentTest;
    private static UnitPage unitPage = new UnitPage();
    private static GlobalElementPage globalElementPage = new GlobalElementPage();
    public UnitTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    // 1# Scenario : Batal tambah unit baru
    @Given("Masuk menu \"Unit\"")
    public void masuk_menu_unit(){
        extentTest.log(LogStatus.PASS, "Masuk menu \"Unit\"");
    }

    @And("Masukan nama unit baru")
    public void masuk_nama_unit_baru(){
        unitPage.setInputNewUnit("SQA-RPA 12");
        extentTest.log(LogStatus.PASS, "Masukan nama unit baru");
    }

    @Then("Kembali ke daftar unit, unit baru batal di tambahkan")
     public void kembali_ke_daftar_unit_unit_baru_batal_di_tambahkan(){
        globalElementPage.setSearchName("SQA-RPA 12");
        globalElementPage.clickSearchSubmitButton();
        DriverSingleton.delay(1);

        Assert.assertEquals(globalElementPage.getCountOfRowsInFirstColumn(), 0);
        extentTest.log(LogStatus.PASS, "Kembali ke daftar unit, unit baru batal di tambahkan");
    }

    // 2# Scenario : Input unit baru dengan jumlah karakter lebih dari 255

    @And("Masukan random karakter lebih dari 255")
    public void masukan_random_karakter_lebih_dari_255(){
        unitPage.setInputNewUnit("fpiicougncpztofjvzpkjlbsqexghfdeuykucvzewrlqhxbwfxvwojnbzzmwwzikhcyfansdedqcrxjdcxowntjyvgsboghzpkdjuonqfvcmhrjuqjighcsidaqbdtztywrjwfznjbpzjsosoxkgwxfjzjalrefiilkbrlambaevduzdeayescirtnozlxqyxvnstbvxjbnyuiaoqskpiksharedtubicqnqaltxhezjneipvvzcfoygfcznalqw");
        extentTest.log(LogStatus.PASS, "Masukan random karakter lebih dari 255");
    }
    @Then("Muncul pop-up \"Gagal menambahkan Unit\"")
    public void muncul_pop_up_gagal_menambahkan_departements(){
        Assert.assertEquals(globalElementPage.getErrorNewItem(), "Gagal Menambahkan Unit");

        extentTest.log(LogStatus.PASS, "Muncul pop-up \"Gagal menambahkan Unit\"");

        globalElementPage.clickCancelDeleteOrEditButton();

    }

    // 3# Scenario : Input unit baru benar
    @Then("Unit baru berhasil ditambahkan")
    public void unit_baru_berhasil_ditambahkan(){
        DriverSingleton.delay(1);
        globalElementPage.setSearchName("SQA-RPA 12");
        globalElementPage.clickSearchSubmitButton();
        DriverSingleton.delay(1);

        Assert.assertEquals(globalElementPage.getTextFromTopmostRowFirstColumn(), "SQA-RPA 12");
        extentTest.log(LogStatus.PASS, "Unit baru berhasil ditambahkan");
    }

    // 4# Scenario : Input unit baru dengan nama yang sama
    @Then("Unit baru gagal ditambahkan, unit sudah tersedia")
    public void unit_baru_gagal_ditambahkan_unit_sudah_tersedia(){
        DriverSingleton.delay(1);
        globalElementPage.clickSearchSubmitButton();
        DriverSingleton.delay(1);

        Assert.assertEquals(globalElementPage.getCountOfTextInFirstColumn("SQA-RPA 12"), 1);
        extentTest.log(LogStatus.PASS, "Unit baru gagal ditambahkan, unit sudah tersedia");
    }

    // 5# Scenario : Input unit dengan nama blank atau kosong
    @And("Masukan nama unit kosong")
    public void masukan_nama_unit_kosong(){
        unitPage.setInputNewUnit("");
        extentTest.log(LogStatus.PASS, "Masukan nama unit kosong");
    }

    @Then("Unit gagal ditambahkan, muncul pop-up \"Nama unit tidak boleh kosong!.\"")
    public void unit_gagal_ditambahkan_muncul_pop_up_nama_unit_tidak_boleh_kosong(){
        Assert.assertEquals(unitPage.getBlankInputNewUnitMessage(), "Nama unit tidak boleh kosong!.");

        extentTest.log(LogStatus.PASS, "Unit gagal ditambahkan, muncul pop-up \"Nama unit tidak boleh kosong!.\"");
        globalElementPage.clickCancelAddNewItemButton();

    }

    // 6# Scenario : Cari unit dengan nama yang tidak ada pada list
    @When("Masukan nama unit yang tidak ada pada list")
    public void masukan_nama_unit_yang_tidak_ada_pada_list(){
        DriverSingleton.delay(1);
        globalElementPage.setSearchName("RandRandUnit");

        extentTest.log(LogStatus.PASS, "Masukan nama unit yang tidak ada pada list");
    }

    @Then("Tidak muncul unit yang dicari")
    public void tidak_muncul_unit_yang_dicari(){
        Assert.assertEquals(globalElementPage.getCountOfRowsInFirstColumn(), 0);

        extentTest.log(LogStatus.PASS, "Tidak muncul unit yang dicari");
    }

    // 7# Scenario : Reset pencarian unit
    @When("Masukan nama unit pada kolom pencarian")
    public void masukan_nama_unit_pada_kolom_pencarian(){
        globalElementPage.setSearchName("SQA-RPA 12");
        extentTest.log(LogStatus.PASS, "Masukan nama unit pada kolom pencarianMasukan nama unit pada kolom pencarian");
    }

    @And("Muncul unit yang dicari")
    public void muncul_unit_yang_dicari(){
        Assert.assertEquals(globalElementPage.getTextFromTopmostRowFirstColumn(), "SQA-RPA 12");

        extentTest.log(LogStatus.PASS, "Muncul unit yang dicari");
    }

    @Then("Daftar unit kembali ke semula")
    public void daftar_unit_kembali_ke_semula(){
        Assert.assertEquals(globalElementPage.getTextFromSearchButton(), "");

        extentTest.log(LogStatus.PASS, "Daftar unit kembali ke semula");
    }
    // 8# Scenario : Cari unit dengan nama "SQA-RPA JC 12" (Already Done)

    // 9# Scenario : Batal edit unit dengan nama "SQA-RPA JC 12" menjadi "SQA-RPA JC Benhil"
    @Given("Cari unit pada kolom pencarian")
    public void cari_unit_pada_kolom_pencarian(){
        globalElementPage.setSearchName("SQA-RPA 12");
        globalElementPage.clickSearchSubmitButton();
        DriverSingleton.delay(1);

        Assert.assertEquals(globalElementPage.getTextFromTopmostRowFirstColumn(), "SQA-RPA 12");
        extentTest.log(LogStatus.PASS, "Cari unit pada kolom pencarian");
    }

    @When("Klik icon 3 baris pada sisi kanan baris unit yang dicari")
    public void klik_icon_3_baris_pada_sisi_kanan_baris_unit_yang_dicari(){
        globalElementPage.clickEditOrDeleteRowButton();
        extentTest.log(LogStatus.PASS, "Klik icon 3 baris pada sisi kanan baris unit yang dicari");
    }

    @And("Rubah \"Nama Unit\" menjadi nama unit baru")
    public void rubah_nama_unit_menjadi_nama_unit_baru(){
        unitPage.setInputNewUnit("SQA-RPA Benhil");
        extentTest.log(LogStatus.PASS, "Rubah \"Nama Unit\" menjadi nama unit baru");
    }

    @Then("Nama unit masih nama unit lama")
    public void nama_unit_masih_nama_unit_lama(){
        driver.navigate().refresh();
        Assert.assertEquals(globalElementPage.getCountOfTextInFirstColumn("SQA-RPA 12"), 2);

        extentTest.log(LogStatus.PASS, "Nama unit masih nama unit lama");
    }

    // 10# Scenario : Edit unit dengan nama "SQA-RPA JC 12" menjadi "SQA-RPA JC Benhil"
    @Then("Nama unit lama ganti menjadi nama unit baru")
    public void nama_unit_lama_ganti_menjadi_nama_unit_baru(){
        globalElementPage.clickResetSearchButton();
        DriverSingleton.delay(1);
        globalElementPage.setSearchName("SQA-RPA Benhil");
        globalElementPage.clickSearchSubmitButton();
        DriverSingleton.delay(1);

        Assert.assertEquals(globalElementPage.getCountOfTextInFirstColumn("SQA-RPA Benhil"), 1);
        extentTest.log(LogStatus.PASS, "Nama unit lama ganti menjadi nama unit baru");
    }

    // 11 Scenario : Edit unit yang sudah ditambahkan dengan nama yang sama
    @Then("Nama unit lama gagal di ganti menjadi nama unit baru karena nama sudah tersedia")
    public void nama_unit_lama_gagal_di_ganti_menjadi_nama_unit_baru_karena_nama_sudah_tersedia(){
        globalElementPage.clickResetSearchButton();
        DriverSingleton.delay(1);
        globalElementPage.setSearchName("SQA-RPA Benhil");
        globalElementPage.clickSearchSubmitButton();
        DriverSingleton.delay(1);

        Assert.assertEquals(globalElementPage.getCountOfTextInFirstColumn("SQA-RPA Benhil"), 1);
        extentTest.log(LogStatus.PASS, "Nama unit lama gagal di ganti menjadi nama unit baru karena nama sudah tersedia");
    }

    // 12 Scenario : Batal delete unit yang sudah di tambahkan
    @Given("Cari nama unit baru pada kolom pencarian")
    public void cari_nama_unit_baru_pada_kolom_pencarian(){
        globalElementPage.clickResetSearchButton();
        DriverSingleton.delay(1);
        globalElementPage.setSearchName("SQA-RPA Benhil");
        globalElementPage.clickSearchSubmitButton();
        DriverSingleton.delay(1);

        extentTest.log(LogStatus.PASS, "Cari nama unit baru pada kolom pencarian");
    }
    @Then("Unit baru masih ada pada daftar unit")
    public void unit_baru_masih_ada_pada_daftar_unit(){
        Assert.assertEquals(globalElementPage.getCountOfTextInFirstColumn("SQA-RPA Benhil"), 2);

        extentTest.log(LogStatus.PASS, "Unit baru masih ada pada daftar unit");
    }

    // 13 Scenario : Delete unit yang sudah di tambahkan
    @Then("Unit baru berhasil dihapus dari daftar unit")
    public void unit_baru_berhasil_dihapus_dari_daftar_unit(){
        driver.navigate().refresh();
        DriverSingleton.delay(1);

        Assert.assertEquals(globalElementPage.getCountOfTextInFirstColumn("SQA-RPA Benhil"), 1);
        extentTest.log(LogStatus.PASS, "Divisi baru berhasil dihapus dari daftar unit");

        globalElementPage.clickResetSearchButton();

    }

    // 14 Scenario : Filter jumlah baris yang ditampilkan menjadi 5 baris pada setiap halaman (Done -> Divisi Feature)
    // 15 Scenario : Filter jumlah baris yang ditampilkan menjadi 10 baris pada setiap halaman (Done -> Divisi Feature)
    // 16 Scenario : Filter jumlah baris yang ditampilkan menjadi 25 baris pada setiap halaman (Done -> Divisi Feature)
    // 17 Scenario : Pindah ke halaman paling akhir
    @Then("Berhasil pindah tabel unit ke halaman paling akhir")
    public void Berhasil_pindah_table_unit_ke_halaman_paling_akhir(){
        Assert.assertEquals(globalElementPage.getPaginationDisplayedInformation(), "76-80 of 80");

        extentTest.log(LogStatus.PASS, "Berhasil pindah tabel unit ke halaman paling akhir");
    }

    // 18 Scenario : Pindah ke halaman sebelumnya
    @Then("Berhasil pindah tabel unit ke halaman sebelumnya")
    public void Berhasil_pindah_table_unit_ke_halaman_sebelumnya(){
        Assert.assertEquals(globalElementPage.getPaginationDisplayedInformation(), "71-75 of 80");

        extentTest.log(LogStatus.PASS, "Berhasil pindah tabel unit ke halaman sebelumnya");
    }

    // 19 Scenario : Pindah ke halaman paling awal

    @Then("Berhasil pindah tabel unit ke halaman paling awal")
    public void Berhasil_pindah_table_unit_ke_halaman_paling_awal() {
        Assert.assertEquals(globalElementPage.getPaginationDisplayedInformation(), "1-5 of 80");

        extentTest.log(LogStatus.PASS, "Berhasil pindah tabel unit ke halaman paling awal");
    }

    // 20 Scenario : Pindah ke halaman selanjutnya

    @Then("Berhasil pindah tabel unit ke halaman selanjutnya")
    public void Berhasil_pindah_table_unit_ke_halaman_selanjutnya() {
        Assert.assertEquals(globalElementPage.getPaginationDisplayedInformation(), "6-10 of 80");

        extentTest.log(LogStatus.PASS, "Berhasil pindah tabel divisi ke halaman selanjutnya");
    }




}


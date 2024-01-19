package com.juaracoding.admin;

import com.github.javafaker.Faker;
import com.juaracoding.Hooks;
import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.GlobalElementPage;
import com.juaracoding.pages.admin.AdminDashboardPage;
import com.juaracoding.pages.admin.ClientUplinerPage;
import com.mongodb.DBRef;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.Log;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ClientUplinerTest {
    private static WebDriver driver;

    private static ExtentTest extentTest;

    private static ClientUplinerPage clientUplinerPage =  new ClientUplinerPage();
    private static GlobalElementPage globalElementPage = new GlobalElementPage();

    public ClientUplinerTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    Faker faker = new Faker();

    String fullName = faker.name().fullName();
    String email = faker.internet().emailAddress();
    String password = faker.internet().password();

    // 1 Scenario : Tambah valid client upliner baru dengan tipe upliner v2
    @Given("Masuk menu \"Client Upliner\"")
    public void masuk_menu_client_upliner(){
        DriverSingleton.delay(1);
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.dikahadir.com/management/client-upliner");
        extentTest.log(LogStatus.PASS, "Masuk menu \"Client Upliner\"");
    }

    @And("Masukan nama")
    public void masukan_nama(){
        clientUplinerPage.setFullNameUpliner(fullName);
        extentTest.log(LogStatus.PASS, "Masukan nama");
    }

    @And("Masukan email")
    public void masukan_email(){
        clientUplinerPage.setEmailUpliner(email);
        extentTest.log(LogStatus.PASS, "Masukan email");
    }

    @And("Masukan password")
    public void masukan_password(){
        clientUplinerPage.setPasswordUpliner(password);
        extentTest.log(LogStatus.PASS, "Masukan password");
    }
    @And("Pilih Unit")
    public void pilih_unit(){
        clientUplinerPage.setJobDepartementUpliner("Air Asia");
        extentTest.log(LogStatus.PASS, "Pilih Unit");
    }

    @And("Pilih Tipe \"Upliner V2\"")
    public void pilih_tipe_upliner_V2(){
        clientUplinerPage.setTipeUplinerV2();
        extentTest.log(LogStatus.PASS, "Pilih Tipe \"Upliner V2\"");
    }

    @And("Klik \"Daftar\"")
    public void klik_daftar(){
        clientUplinerPage.clickRegisterUpliner();
        extentTest.log(LogStatus.PASS, "Klik \"Daftar\"");
    }

    @Then("Data Client Upliner V2 berhasil ditambahkan")
    public void data_client_upliner_V2_berhasil_ditambahkan(){
        DriverSingleton.delay(1);
        Assert.assertEquals(globalElementPage.getTextFromTopmostRowSecondColumn(), clientUplinerPage.getRandNamaKaryawanUpliner());

        extentTest.log(LogStatus.PASS, "Data client Upliner V2 berhasil ditambahkan");
    }

    // 2 Scenario : Tambah client tipe upliner V2 dengan alamat email yang sudah ada
    @And("Masukan email yang sudah terdaftar")
    public void masukan_email_yang_sudah_terdaftar(){
        clientUplinerPage.setEmailUpliner("admin@hadir.com");
        extentTest.log(LogStatus.PASS, "Masukan email yang sudah terdaftar");
    }

    @Then("Data gagal ditambahkan, muncul pop-up \"Email sudah terdaftar\"")
    public void data_gagal_ditambahkan_muncul_pop_up_email_yang_sudah_terdaftar(){
        Assert.assertEquals(globalElementPage.getErrorNewItem(), "Email sudah terdaftar");
        extentTest.log(LogStatus.PASS, "Data gagal ditambahkan, muncul pop-up \"Email sudah terdaftar\"");

        driver.navigate().back();
    }

    // 3 Scenario : Tambah valid client upliner baru dengan tipe upliner v3
    @And("Pilih Tipe \"Upliner V3\"")
    public void pilih_tipe_upliner_V3(){
        clientUplinerPage.setTipeUplinerV3();
        extentTest.log(LogStatus.PASS, "Pilih Tipe \"Upliner V3\"");
    }

    @Then("Data Client Upliner V3 berhasil ditambahkan")
    public void data_client_upliner_v3_berhasil_ditambahkan(){
        DriverSingleton.delay(1);
        Assert.assertEquals(globalElementPage.getTextFromTopmostRowSecondColumn(), clientUplinerPage.getRandNamaKaryawanUpliner());

        extentTest.log(LogStatus.PASS, "Data Client Upliner V3 berhasil ditambahkan");
    }

    // 4 Scenario : Tambah client tipe upliner V3 dengan alamat email yang sudah ada (Done)

    // 5 Scenario : Tambah client upliner baru dengan invalid alamat email
    @And("Masukan email tanpa \"@\"")
    public void masukan_email_tanpa_add_symbol(){
        clientUplinerPage.setEmailUpliner("admin");
        extentTest.log(LogStatus.PASS, "Masukan email tanpa \"@\"");
    }

    @Then("Data gagal ditambahkan, muncul warning untuk menambahkan \"@\" pada kolom email")
    public void data_gagal_ditambahkan_muncul_warning_add_symbol_pada_kolom_email(){
        DriverSingleton.delay(1);

        Assert.assertEquals(clientUplinerPage.getEmailValidationMessage(), "Please include an '@' in the email address. 'admin' is missing an '@'.");
        extentTest.log(LogStatus.PASS, "Data gagal ditambahkan, muncul warning untuk menambahkan \"@\" pada kolom email");

        driver.navigate().back();
    }

    // 6 Scenario : Tambah client upliner baru dengan email baru tapi dengan nama dan unit yang sama
    @And("Masukan nama yang sudah terdaftar")
    public void masukan_nama_yang_sudah_terdaftar(){
        clientUplinerPage.setFullNameUpliner("HR Test V3");
        extentTest.log(LogStatus.PASS, "Masukan nama yang sudah terdaftar");
    }

    @Then("Data gagal ditambahkan")
    public void data_gagal_ditambahkan(){
        Assert.assertNotEquals(globalElementPage.getTextFromTopmostRowSecondColumn(), clientUplinerPage.getRandNamaKaryawanUpliner());
        extentTest.log(LogStatus.PASS, "Data gagal ditambahkan");

        DriverSingleton.delay(1);
    }

    // 7 Scenario : Tambah client upliner baru dengan email baru tapi dengan nama sama namun beda unit
    @And("Pilih Unit yang berbeda")
    public void pilih_unit_yang_berbeda(){
        clientUplinerPage.setJobDepartementUpliner("BCA Life");
        extentTest.log(LogStatus.PASS, "Pilih Unit yang berbeda");
    }

    @Then("Data berhasil ditambahkan")
    public void data_berhasil_ditambahkan(){
        DriverSingleton.delay(1);
        Assert.assertEquals(globalElementPage.getTextFromTopmostRowSecondColumn(), clientUplinerPage.getRandNamaKaryawanUpliner());
        DriverSingleton.delay(1);
        Assert.assertEquals(globalElementPage.getTextFromTopmostRowForthColumn() , "BCA Life");
        extentTest.log(LogStatus.PASS, "Data berhasil ditambahkan");
    }

    // 8 Scenario : Tambah client upliner baru dengan data valid namun password kurang dari 8 karakter
    @And("Masukan password kurang dari 8 karakter")
    public void masukan_password_kurang_dari_8_karakter(){
        clientUplinerPage.setPasswordUpliner("1@3");
        extentTest.log(LogStatus.PASS, "Masukan password kurang dari 8 karakter");
    }

    @Then("Muncul warning password kurang dari 8 karakter")
    public void muncul_warning_password_kurang_dari_8_karakter(){
        DriverSingleton.delay(1);

        Assert.assertEquals(clientUplinerPage.getPasswordValidationMessage(), "Please lengthen this text to 8 characters or more (you are currently using 3 characters).");
        extentTest.log(LogStatus.PASS, "Muncul warning password kurang dari 8 karakter");

        driver.navigate().back();
    }

    // 9 Scenario : Tambah client upliner baru dengan data valid namun nama hanya angka saja
    @And("Masukan nama hanya angka saja")
    public void masukan_nama_hanya_angka_saja(){
        clientUplinerPage.setFullNameUpliner("12345678");
        extentTest.log(LogStatus.PASS, "Masukan nama hanya angka saja");
    }

    @Then("Client dengan nama angka gagal ditambahkan")
    public void client_dengan_nama_angka_gagal_ditambahkan(){
        Assert.assertNotEquals(globalElementPage.getTextFromTopmostRowSecondColumn(), "12345678");
        extentTest.log(LogStatus.PASS, "Client dengan nama angka gagal ditambahkan");
    }

    // 10 Scenario : Cari nama client dengan nama yang tidak ada pada list
    @When("Masukan nama client yang tidak ada pada list")
    public void masukan_nama_client_yang_tidak_ada_pada_list(){
        globalElementPage.setSearchName(fullName);
        globalElementPage.clickSearchSubmitButton();

        extentTest.log(LogStatus.PASS, "Masukan nama client yang tidak ada pada list");
    }

    @Then("Tidak muncul client yang dicari")
    public void tidak_muncul_client_yang_dicari(){
        Assert.assertEquals(globalElementPage.getCountOfRowsInFirstColumn(), 0);
        extentTest.log(LogStatus.PASS, "Tidak muncul client yang dicari");

        clientUplinerPage.clickResetSearchClientUpliner();
        DriverSingleton.delay(1);
    }

    // 11 Scenario : Reset pencarian nama client
    @When("Masukan nama client pada kolom pencarian")
    public void masukan_nama_client_pada_kolom_pencarian(){
        globalElementPage.setSearchName("12345678");
        globalElementPage.clickSearchSubmitButton();
        extentTest.log(LogStatus.PASS, "Masukan nama client pada kolom pencarian");
    }

    @And("Muncul nama client yang dicari")
    public void muncul_nama_client_yang_dicari(){
        Assert.assertEquals(globalElementPage.getTextFromSearchButton(), "12345678");
        extentTest.log(LogStatus.PASS, "Muncul nama client yang dicari");
    }

    @Then("Daftar client kembali ke semula")
    public void daftar_client_kembali_ke_semula(){
        DriverSingleton.delay(2);
        Assert.assertEquals(globalElementPage.getCountOfRowsInFirstColumn(), 10);
        extentTest.log(LogStatus.PASS, "Daftar client kembali ke semula");
    }

    // 12 Scenario : Cari client dengan nama yang sudah ditentukan (Done)

    // 13 Scenario : Edit nama client menjadi "Ikrar Bagaskara"
    @Given("Cari nama client yang ingin di edit pada kolom pencarian")
    public void cari_nama_client_yang_ingin_di_edit_pada_kolom_pencarian(){
        clientUplinerPage.clickResetSearchClientUpliner();

        globalElementPage.setSearchName("12345678");
        globalElementPage.clickSearchSubmitButton();
        extentTest.log(LogStatus.PASS, "Cari nama client yang ingin di edit pada kolom pencarian");
    }

    @When("Klik icon 3 baris pada sisi kanan baris nama client")
    public void klik_icon_3_baris_pada_sisi_kanan_baris_nama_client(){
        globalElementPage.clickEditOrDeleteRowButton();
        extentTest.log(LogStatus.PASS, "Klik icon 3 baris pada sisi kanan baris nama client");
    }

    @And("Rubah \"Nama Karyawan\" menjadi nama client baru")
    public void rubah_nama_karyawan_menjadi_nama_client_baru(){
        clientUplinerPage.setFullNameUpliner("Ikrar Bagaskara");
        extentTest.log(LogStatus.PASS, "Rubah \"Nama Karyawan\" menjadi nama client baru");
    }

    @And("Klik \"Ubah\"")
    public void klik_ubah(){
        clientUplinerPage.clickRegisterUpliner();
        extentTest.log(LogStatus.PASS, "Klik \"Ubah\"");
    }

    @Then("Nama karyawan berubah menjadi nama client baru")
    public void nama_karyawan_berubah_menjadi_nama_client_baru(){
        Assert.assertEquals(globalElementPage.getTextFromTopmostRowSecondColumn(), "Ikrar Bagaskara");
        extentTest.log(LogStatus.PASS, "Nama karyawan berubah menjadi nama client baru");
    }

    // 14 Scenario : Edit client dengan nama "Ikrar Bagaskara" menjadi angka saja
    @Given("Cari nama client yang ingin di edit nama menjadi angka")
    public void cari_nama_client_yang_ingin_di_edit_nama_menjadi_angka(){
        globalElementPage.setSearchName("Ikrar Bagaskara");
        globalElementPage.clickSearchSubmitButton();
        extentTest.log(LogStatus.PASS, "Cari nama client yang ingin di edit nama menjadi angka");
    }

    @And("Rubah \"Nama Karyawan\" menjadi angka saja")
    public void  rubah_nama_karyawan_menjadi_angka_saja(){
        clientUplinerPage.setFullNameUpliner("987456321");
        extentTest.log(LogStatus.PASS, "Rubah \"Nama Karyawan\" menjadi angka saja");
    }

    @Then("Error harusnya nama karyawan tidak boleh hanya angka saja")
    public void error_harusnya_nama_karyawan_tidak_boleh_hanya_angka_saja(){
        Assert.assertNotEquals(globalElementPage.getTextFromTopmostRowSecondColumn(), "987456321");
        extentTest.log(LogStatus.PASS, "Error harusnya nama karyawan tidak boleh hanya angka saja");
    }

    // 15 Scenario : Edit client dengan nama client menjadi identik dengan nama client lain
    @Given("Cari nama client yang ingin di edit nama menjadi identik nama lain")
    public void cari_nama_client_yang_ingin_di_edit_nama_menjadi_identik_nama_lain(){
        globalElementPage.setSearchName("987456321");
        globalElementPage.clickSearchSubmitButton();
        extentTest.log(LogStatus.PASS, "Cari nama client yang ingin di edit nama menjadi identik nama lain");
    }

    @And("Rubah \"Nama Karyawan\" menjadi nama client identik")
    public void rubah_nama_karyawan_menjadi_nama_client_identik(){
        clientUplinerPage.setFullNameUpliner("HR Test V3");
        extentTest.log(LogStatus.PASS, "Rubah \"Nama Karyawan\" menjadi nama client identik");
    }

    @Then("Gagal edit nama client, nama identik dengan client lain")
    public void gagal_edit_nama_client_nama_identik_dengan_client_lain(){
        globalElementPage.setSearchName("HR Test V3");
        globalElementPage.clickSearchSubmitButton();
        DriverSingleton.delay(1);

        Assert.assertEquals(globalElementPage.getCountOfTextInFirstColumn("HR Test V3"), "1");
        extentTest.log(LogStatus.PASS, "Gagal edit nama client, nama identik dengan client lain");

        globalElementPage.clickSearchSubmitButton();
    }

    // 16 Scenario : Edit email client menggunakan email baru
    @Given("Cari nama client yang ingin di edit email baru pada kolom pencarian")
    public void cari_nama_client_yang_ingin_di_edit_email_baru_pada_kolom_pencarian(){
        globalElementPage.setSearchName("HR Test V3");
        globalElementPage.clickSearchSubmitButton();
        DriverSingleton.delay(1);
        extentTest.log(LogStatus.PASS, "Cari nama client yang ingin di edit email baru pada kolom pencarian");
    }

    @And("Rubah \"Email\" menjadi email baru")
    public void rubah_email_menjadi_email_baru(){
        clientUplinerPage.setEmailUpliner(email);
        extentTest.log(LogStatus.PASS, "Rubah \"Email\" menjadi email baru");
    }

    @Then("Alamat karyawan berubah menjadi alamat email baru")
    public void alamat_karyawan_berubah_menjadi_alamat_email_baru(){
        Assert.assertEquals(globalElementPage.getTextFromTopmostRowThirdColumn(), clientUplinerPage.getRandEmailKaryawanUpliner());
        extentTest.log(LogStatus.PASS, "Alamat karyawan berubah menjadi alamat email baru");
    }

    // 17 Scenario : Edit email client menggunakan email yang sudah digunakan
    @And("Rubah \"Email\" menjadi email yang sudah terdaftar")
    public void rubah_email_menjadi_email_yang_sudah_terdaftar(){
        clientUplinerPage.setEmailUpliner("admin@hadir.com");
        extentTest.log(LogStatus.PASS, "Rubah \"Email\" menjadi email yang sudah terdaftar");
    }
    @Then("Muncul pop-up \"Email sudah terdaftar\"")
    public void muncul_pop_up_terjadi_kesalahan_pada_server(){
        Assert.assertEquals(globalElementPage.getErrorNewItem(), "Terjadi kesalahan pada server");
        driver.navigate().refresh();
        driver.navigate().back();
        extentTest.log(LogStatus.PASS, "Muncul pop-up \"Email sudah terdaftar\"");
    }

    // 18 Scenario : Edit client dengan unit "Air Asia" menjadi "TEKNISI EDC"
    @Given("Cari client dengan unit yang sudah ditentukan")
    public void cari_client_dengan_unit_yang_sudah_ditentukan(){
        globalElementPage.clickResetSearchButton();
        globalElementPage.setSearchName("HR Test V3");
        globalElementPage.clickSearchSubmitButton();
        DriverSingleton.delay(1);

        extentTest.log(LogStatus.PASS, "Cari client dengan unit yang sudah ditentukan");
    }

    @And("Rubah \"Unit\" menjadi unit yang sudah ditentukan")
    public void rubah_unit_menjadi_unit_yang_sudah_ditentukan(){
        clientUplinerPage.setJobDepartementUpliner("TEKNISI EDC");
        extentTest.log(LogStatus.PASS, "Rubah \"Unit\" menjadi unit yang sudah ditentukan");
    }

    @Then("Nama unit berubah menjadi nama unit baru")
    public void nama_unit_berubah_menjadi_nama_unit_baru(){
        Assert.assertEquals(globalElementPage.getTextFromTopmostRowForthColumn(), "TEKNISI EDC");
        extentTest.log(LogStatus.PASS, "Nama unit berubah menjadi nama unit baru");
    }

    // 19 Scenario : Batal filter berdasarkan unit "Air Asia"
    @When("Klik icon \"Filter\"")
    public void klik_icon_filter(){
        clientUplinerPage.clickFilterByUnit();
        extentTest.log(LogStatus.PASS, "Klik icon \"Filter\"");
    }

    @And("Pilih unit yang akan difilter")
    public void pilih_unit_yang_akan_difilter(){
        clientUplinerPage.clickSelectFilterUnit();
        DriverSingleton.delay(1);
        clientUplinerPage.clickSelectFilterAirAsia();
        extentTest.log(LogStatus.PASS, "Pilih unit yang akan difilter");
    }

    @And("Klik \"Batal\" filter unit")
    public void klik_batal_filter_unit(){
        globalElementPage.clickCancelAddNewItemButton();
        extentTest.log(LogStatus.PASS, "Klik \"Batal\" filter unit");
    }
    @Then("Daftar client belum terfillter")
    public void daftar_client_belum_terfillter(){
        Assert.assertEquals(globalElementPage.getTextFromTopmostRowForthColumn(), "TEKNISI EDC");
        extentTest.log(LogStatus.PASS, "Daftar client belum terfillter");
    }

    // 20 Scenario : Filter berdasarkan unit "Air Asia"
    @And("Klik \"Terapkan\"")
    public void klik_terapkan(){
        globalElementPage.clickSaveNewItemButton();
        extentTest.log(LogStatus.PASS, "Klik \"Terapkan\"");
    }

    @Then("Daftar client sudah terfilter")
    public void daftar_client_sudah_terfilter(){
        DriverSingleton.delay(2);
        Assert.assertEquals(globalElementPage.getTextFromTopmostRowForthColumn(), "Air Asia");
        extentTest.log(LogStatus.PASS, "Daftar client sudah terfilter");

        globalElementPage.clickResetSearchButton();
    }

    // 21 Scenario : Batal delete client yang sudah ditambahkan
    @Given("Cari nama client yang akan dihapus pada kolom pencarian")
    public void cari_nama_client_yang_akan_dihapus_pada_kolom_pencarian(){
        clientUplinerPage.clickResetSearchClientUpliner();
        globalElementPage.setSearchName("HR Test V3");
        globalElementPage.clickSearchSubmitButton();
        DriverSingleton.delay(1);

        extentTest.log(LogStatus.PASS, "Cari nama client yang akan dihapus pada kolom pencarian");
    }

    @Then("Client masih ada pada daftar client")
    public void client_masih_ada_pada_daftar_client(){
        Assert.assertEquals(globalElementPage.getCountOfTextInSecondColumn("HR Test V3"), 4);
        extentTest.log(LogStatus.PASS, "Client masih ada pada daftar client");
    }

    // 22 Scenario : Delete client sudah ditambahkan
    @Then("Client berhasil dihapus dari daftar client")
    public void client_berhasil_dihapus_dari_daftar_client(){
        Assert.assertEquals(globalElementPage.getCountOfTextInSecondColumn("HR Test V3"), 2);

        extentTest.log(LogStatus.PASS, "Client berhasil dihapus dari daftar client");

        clientUplinerPage.clickResetSearchClientUpliner();
        DriverSingleton.delay(2);
    }

    // 23 Scenario : Filter jumlah baris yang ditampilkan menjadi 5 baris pada setiap halaman  (Done)
    // 24 Scenario : Filter jumlah baris yang ditampilkan menjadi 10 baris pada setiap halaman (Done)
    // 25 Scenario : Filter jumlah baris yang ditampilkan menjadi 25 baris pada setiap halaman (Done)
    // 26 Scenario : Pindah ke halaman paling akhir
    @Then("Berhasil pindah table upliner ke halaman paling akhir")
    public void berhasil_pindah_table_upliner_ke_halaman_paling_akhir(){
        Assert.assertEquals(globalElementPage.getPaginationDisplayedInformation(), "156-156 of 156");

        extentTest.log(LogStatus.PASS, "");
    }

    // 27 Scenario : Pindah ke halaman sebelumnya
    @Then("Berhasil pindah table upliner ke halaman sebelumnya")
    public void berhasil_pindah_table_upliner_ke_halaman_sebelumnya(){
        Assert.assertEquals(globalElementPage.getPaginationDisplayedInformation(), "151-155 of 156");

        extentTest.log(LogStatus.PASS, "");
    }

    // 28 Scenario : Pindah ke halaman paling awal
    @Then("Berhasil pindah table upliner ke halaman paling awal")
    public void berhasil_pindah_table_upliner_ke_halaman_paling_awal(){
        Assert.assertEquals(globalElementPage.getPaginationDisplayedInformation(), "1-5 of 156");

        extentTest.log(LogStatus.PASS, "");
    }

    // 29 Scenario : Pindah ke halaman selanjutnya
    @Then("Berhasil pindah table upliner ke halaman selanjutnya")
    public void berhasil_pindah_table_upliner_ke_halaman_selanjutnya (){
        Assert.assertEquals(globalElementPage.getPaginationDisplayedInformation(), "6-10 of 156");

        extentTest.log(LogStatus.PASS, "");
    }


}

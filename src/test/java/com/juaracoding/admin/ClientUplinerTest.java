package com.juaracoding.admin;

import com.github.javafaker.Faker;
import com.juaracoding.Hooks;
import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.GlobalElementPage;
import com.juaracoding.pages.admin.AdminDashboardPage;
import com.juaracoding.pages.admin.ClientUplinerPage;
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
        Assert.assertEquals(globalElementPage.getCountOfRowsInFirstColumn(), 10);
        extentTest.log(LogStatus.PASS, "Daftar client kembali ke semula");
    }

}

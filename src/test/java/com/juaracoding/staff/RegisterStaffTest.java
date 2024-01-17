package com.juaracoding.staff;

import com.juaracoding.Hooks;
import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.GlobalElementPage;
import com.juaracoding.pages.staff.StaffLoginPage;
import com.juaracoding.pages.staff.StaffRegisterPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import javax.swing.plaf.PanelUI;
import java.nio.file.Paths;

public class RegisterStaffTest {
    private static WebDriver driver;

    private static ExtentTest extentTest;

    public static GlobalElementPage globalElementPage = new GlobalElementPage();
    public static StaffRegisterPage staffRegisterPage = new StaffRegisterPage();

    String validImages = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "images", "tofu.jpeg").toString();
    String invalidFormatImage = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "images", "tofu.txt").toString();
    String three_MB_Image = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "images", "3_mb_images.jpg").toString();
    public RegisterStaffTest() {
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    // 1# Scenario : Input URL Salah
    @Given("Input URL Register Staff Admin yang salah")
    public void input_url_register_staff_admin_yang_salah(){
        String invalidRegisterURL = "https://staging-hadir.ptkta.com/absen/registrar";
        driver.get(invalidRegisterURL);

        extentTest.log(LogStatus.PASS, "Input URL Register Staff Admin yang salah");
    }

    @When("Klik tombol Enter pada Keyboard")
    public void klik_tombol_enter_pada_keyboard(){
        DriverSingleton.delay(1);
        extentTest.log(LogStatus.PASS, "Klik tombol Enter pada Keyboard");

    }

    @Then("Menampilkan Halaman Register yang salah atau 404")
    public void menampilkan_halaman_menampilkan_halaman_register_yang_salah_atau_404(){
        Assert.assertEquals(driver.getCurrentUrl(), "https://staging-hadir.ptkta.com/absen/registrar");

        extentTest.log(LogStatus.PASS, "Menampilkan Halaman Register yang salah atau 404");
    }

    // 2# Scenario : Input URL Benar
    @Given("Input URL Register Staff Admin yang benar")
    public void input_url_register_staff_admin_yang_benar(){
        String validRegisterURL = "https://staging-hadir.ptkta.com/absen/register";
        driver.get(validRegisterURL);

        extentTest.log(LogStatus.PASS, "Input URL Register Staff Admin yang benar");
    }

    @Then("Menampilkan Halaman Registrasi")
    public void menampilkan_halaman_registrasi(){
        Assert.assertEquals(driver.getCurrentUrl(), "https://staging-hadir.ptkta.com/absen/register");

        extentTest.log(LogStatus.PASS, "Menampilkan Halaman Registrasi");
    }

    // 3# Scenario : Input valid NIK, Nama Lengkap, Password, Upload Selfie, Email tanpa '@'
    @Given("Pergi ke halaman registrasi")
    public void pergi_ke_halaman_registrasi(){
        driver.navigate().refresh();
        Assert.assertEquals(driver.getCurrentUrl(), "https://staging-hadir.ptkta.com/absen/register");

        extentTest.log(LogStatus.PASS, "Pergi ke halaman registrasi");
    }

    @When("Masukan NIK")
    public void masukan_nik(){
        staffRegisterPage.setNikStaff("JC-SQA-RPA 12");
        extentTest.log(LogStatus.PASS, "Masukan NIK");
    }

    @And("Masukan Nama Lengkap")
    public void masukan_nama_lengkap(){
        staffRegisterPage.setFullNameStaff("Elanda Nur Afwi Desto");
        extentTest.log(LogStatus.PASS, "Masukan Nama Lengkap");
    }

    @And("Masukan Email tanpa '@'")
    public void masukan_email_tanpa_symbol_add(){
        staffRegisterPage.setEmailStaff("random-email");
        extentTest.log(LogStatus.PASS, "Masukan Email tanpa '@'");
    }

    @And("Masukan Password")
    public void masukan_password(){
        staffRegisterPage.setInputPasswordStaff("HighSecPassw0rd!@3");
        extentTest.log(LogStatus.PASS, "Masukan Password");
    }

    @And("Masukan Upload Selfie")
    public void masukan_upload_selfie(){
        staffRegisterPage.setUploadGambarStaff(validImages);
        extentTest.log(LogStatus.PASS, "Masukan Upload Selfie");
    }

    @And("Klik Daftar")
    public void klik_daftar(){
        DriverSingleton.delay(1);
        staffRegisterPage.klikTombolDaftarStaff();
        DriverSingleton.delay(1);

        extentTest.log(LogStatus.PASS, "Klik Daftar");
    }
    @Then("User gagal daftar, muncul peringatan perlu simbol add")
    public void user_gagal_daftar_muncul_peringatan_perlu_simbol_add(){
        DriverSingleton.delay(1);
        Assert.assertEquals(staffRegisterPage.getEmailValidationMessage(), "Please include an '@' in the email address. 'random-email' is missing an '@'.");
        extentTest.log(LogStatus.PASS, "User gagal daftar, muncul peringatan perlu simbol add");
    }

    // 4# Scenario : Input valid NIK, Nama Lengkap, Password, Upload Selfie, Email yang sudah terdaftar
    @And("Masukan Email yang sudah terdaftar")
    public void masukan_email_yang_sudah_terdaftar(){
        staffRegisterPage.setEmailStaff("registered@example.com");
        extentTest.log(LogStatus.PASS, "Masukan Email yang sudah terdaftar");
    }

    @Then("User gagal daftar, muncul peringatan email sudah terdaftar")
    public void user_gagal_daftar_muncul_peringanta_email_sudah_terdaftar(){
        DriverSingleton.delay(3);
        Assert.assertEquals(staffRegisterPage.getTextAlertMessage(), "Email sudah terdaftar");
        extentTest.log(LogStatus.PASS, "User gagal daftar, muncul peringatan email sudah terdaftar");
    }

    // 5# Scenario : Input valid NIK, Nama Lengkap, Email, Password, Upload Selfie lebih dari 2 MB
    @And("Masukan Email")
    public void masukan_email(){
        staffRegisterPage.setEmailStaff("elandaregistered@example.com");
        extentTest.log(LogStatus.PASS, "Masukan Email");
    }

    @And("Masukan Upload Selfie lebih dari 2 MB")
    public void masukan_upload_selfie_lebih_dari_2_MB(){
        staffRegisterPage.setUploadGambarStaff(three_MB_Image);
        extentTest.log(LogStatus.PASS, "Masukan Upload Selfie lebih dari 2 MB");
    }

    @Then("User gagal daftar, muncul peringatan file lebih dari 2 MB")
    public void user_gagal_daftar_muncul_peringatan_file_lebih_dari_2_mb(){
        DriverSingleton.delay(2);
        Assert.assertEquals(staffRegisterPage.getTextAlertMessage(), "*File harus dibawah 2 MB");

        extentTest.log(LogStatus.PASS, "User gagal daftar, muncul peringata file lebih dari 2 MB");
    }

    // 6# Scenario : Input valid NIK, Nama Lengkap, Email, Password, Upload Selfie selain format gambar
    @And("Masukan Upload Selfie selain format gambar")
    public void masukan_upload_selfie_selain_format_gambar(){
        staffRegisterPage.setUploadGambarStaff(invalidFormatImage);
        extentTest.log(LogStatus.PASS, "Masukan Upload Selfie selain format gambar");
    }

    @Then("User gagal daftar, muncul peringatan harus menggunakan format gambar")
    public void user_gagal_daftar_muncul_peringatan_harus_menggunakan_format_gambar(){
        DriverSingleton.delay(1);
        Assert.assertEquals(staffRegisterPage.getTextAlertMessage(), "*File harus berupa gambar");

        extentTest.log(LogStatus.PASS, "User gagal daftar, muncul peringatan harus menggunakan format gambar");
    }

    // 7# Scenario : Input valid, Nama Lengkap, Email, Password, Upload Selfie, NIK Kosong
    @When("Masukan NIK kosong")
    public void masukan_nik_kosong(){
        staffRegisterPage.setNikStaff("");
        extentTest.log(LogStatus.PASS, "Masukan NIK kosong");
    }

    @Then("User gagal daftar, muncul peringatan NIK kosong")
    public void user_gagal_daftar_muncul_peringatan_nik_kosong(){
        DriverSingleton.delay(1);
        Assert.assertEquals(staffRegisterPage.getNikValidationMessage(), "Please fill out this field.");
    }

    // 8# Scenario : Input valid NIK, Email, Password, Upload Selfie, Nama Lengkap Kosong
    @And("Masukan Nama Lengkap kosong")
    public void masukan_nama_lengkap_kosong(){
        staffRegisterPage.setFullNameStaff("");
        extentTest.log(LogStatus.PASS, "Masukan Nama Lengkap kosong");
    }

    @Then("User gagal daftar, muncul peringatan Nama Lengkap kosong")
    public void user_gagal_daftar_muncul_peringatan_nama_lengkap_kosong(){
        DriverSingleton.delay(1);
        Assert.assertEquals(staffRegisterPage.getFullNameValidationMessage(), "Please fill out this field.");
    }

    // 9# Scenario : Input valid NIK, Nama Lengkap, Password, Upload Selfie, Email Kosong
    @And("Masukan Email kosong")
    public void masukan_email_kosong(){
        staffRegisterPage.setEmailStaff("");
        extentTest.log(LogStatus.PASS, "Masukan Email kosong");
    }

    @Then("User gagal daftar, muncul peringatan Email kosong")
    public void user_gagal_daftar_muncul_peringatan_email_kosong(){
        DriverSingleton.delay(1);
        Assert.assertEquals(staffRegisterPage.getEmailValidationMessage(), "Please fill out this field.");
    }

    // 10# Scenario : Input valid NIK, Nama Lengkap, Email, Upload Selfie, Password Kosong
    @And("Masukan Password kosong")
    public void masukan_password_kosong(){
        staffRegisterPage.setInputPasswordStaff("");
        extentTest.log(LogStatus.PASS, "Masukan Password kosong");
    }

    @Then("User gagal daftar, muncul peringatan Password kosong")
    public void user_gagal_daftar_muncul_peringatan_password_kosong(){
        DriverSingleton.delay(1);
        Assert.assertEquals(staffRegisterPage.getPasswordValidationMessage(), "Please fill out this field.");
    }

    // 11# Scenario : Input valid NIK, Nama Lengkap, Email, Password, Upload Selfie Kosong
    @And("Masukan Upload Selfie kosong")
    public void masukan_upload_selfie_kosong(){
        extentTest.log(LogStatus.PASS, "Masukan Upload Selfie kosong");
    }

    @Then("User gagal daftar, muncul peringatan Upload Selfie kosong")
    public void user_gagal_daftar_muncul_peringatan_upload_selfie_kosong(){
        DriverSingleton.delay(1);
        Assert.assertEquals(staffRegisterPage.getImageValidationMessage(), "Please select a file.");
    }
    // 12# Scenario : Input valid NIK, Email , Password , Upload Selfie, Nama Lengkap hanya angka saja
    @And("Masukan Nama Lengkap hanya angka")
    public void masukan_nama_lengkap_hanya_angka(){
        staffRegisterPage.setNikStaff("123456790");
        extentTest.log(LogStatus.PASS, "Masukan Nama Lengkap hanya angka");
    }

    // 13# Scenario : Input valid NIK , Nama Lengkap, Email , Password , Upload Selfie
    @Then("User berhasil terdaftar")
    public void user_berhasil_terdaftar(){
        DriverSingleton.delay(1);
        Assert.assertEquals(staffRegisterPage.getTextAlertMessage(), "berhasil register, silahkan menunggu di approve oleh admin");

        extentTest.log(LogStatus.PASS, "User berhasil terdaftar");
    }

}

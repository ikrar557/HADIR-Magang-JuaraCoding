package TestNG.staff;

import TestNG.TestBase;
import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.GlobalElementPage;
import com.juaracoding.pages.staff.StaffLoginPage;
import com.juaracoding.pages.staff.StaffRegisterPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.nio.file.Paths;

import static com.juaracoding.utils.Constant.STAFF_URL;

public class RegisterStaffTest extends TestBase {
    StaffRegisterPage staffRegisterPage;
    StaffLoginPage staffLoginPage;
    GlobalElementPage globalElementPage;

    String validImages = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "images", "tofu.jpeg").toString();
    String invalidFormatImage = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "images", "tofu.txt").toString();
    String three_MB_Image = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "images", "3_mb_images.jpg").toString();
    @BeforeClass
    public void testSetUpEnvironmentChrome(){
        setUpChrome();
        driver.get(STAFF_URL);
        staffLoginPage = new StaffLoginPage();
        staffRegisterPage = new StaffRegisterPage();
        globalElementPage = new GlobalElementPage();
    }

    @Test(priority = 1)
    public void testNavigateToInvalidRegisterPage() {
        String invalidRegisterURL = "https://staging-hadir.ptkta.com/absen/registrar";
        driver.get(invalidRegisterURL);
        DriverSingleton.delay(1);

        Assert.assertEquals(driver.getCurrentUrl(), "https://staging-hadir.ptkta.com/absen/registrar");
    }
    @Test(priority = 2)
    public void testNavigateToValidRegisterPage(){
        String validRegisterURL = "https://staging-hadir.ptkta.com/absen/register";
        driver.get(validRegisterURL);
        DriverSingleton.delay(1);

        Assert.assertEquals(driver.getCurrentUrl(), "https://staging-hadir.ptkta.com/absen/register");
    }

    @Test(priority = 3)
    public void testInputEmailWithoutAddSymbol(){
        staffRegisterPage.inputNewStaff("JC-SQA-RPA12", "Elanda Nur Afwi Desto", "random-email", "HighSecPassw0rd!@3", validImages);

        DriverSingleton.delay(1);
        Assert.assertEquals(staffRegisterPage.getEmailValidationMessage(), "Please include an '@' in the email address. 'random-email' is missing an '@'.");
    }
    @Test(priority = 4)
    public void testInputRegisteredEmail(){
        staffRegisterPage.inputNewStaff("JC-SQA-RPA12", "Elanda Nur Afwi Desto", "registered@example.com", "HighSecPassw0rd!@3", validImages);

        DriverSingleton.delay(2);
        Assert.assertEquals(staffRegisterPage.getTextAlertMessage(), "Email sudah terdaftar");
    }
    @Test(priority = 5)
    public void testInputImageWithSizeMoreThan2MB(){
        staffRegisterPage.inputNewStaff("JC-SQA-RPA12", "Elanda Nur Afwi Desto", "registered@example.com", "HighSecPassw0rd!@3", three_MB_Image);

        DriverSingleton.delay(1);
        Assert.assertEquals(staffRegisterPage.getTextAlertMessage(), "*File harus dibawah 2 MB");
    }
    @Test(priority = 6)
    public void testInputImageWithNonImagesFormat(){
        staffRegisterPage.inputNewStaff("JC-SQA-RPA12", "Elanda Nur Afwi Desto", "registered@example.com", "HighSecPassw0rd!@3", invalidFormatImage);

        DriverSingleton.delay(1);
        Assert.assertEquals(staffRegisterPage.getTextAlertMessage(), "*File harus berupa gambar");
    }

    @Test(priority = 7)
    public void testBlankInputNik(){
        staffRegisterPage.inputNewStaff("", "Elanda Nur Afwi Desto", "registered@example.com", "HighSecPassw0rd!@3", validImages);

        DriverSingleton.delay(1);
        Assert.assertEquals(staffRegisterPage.getNikValidationMessage(), "Please fill out this field.");
    }

    @Test(priority = 8)
    public void testBlankInputFullName(){
        staffRegisterPage.inputNewStaff("JC-SQA-RPA12", "", "registered@example.com", "HighSecPassw0rd!@3", validImages);

        DriverSingleton.delay(1);
        Assert.assertEquals(staffRegisterPage.getFullNameValidationMessage(), "Please fill out this field.");
    }

    @Test(priority = 9)
    public void testBlankInputEmail(){
        staffRegisterPage.inputNewStaff("JC-SQA-RPA12", "Elanda Nur Afwi Desto", "", "HighSecPassw0rd!@3", validImages);

        DriverSingleton.delay(1);
        Assert.assertEquals(staffRegisterPage.getEmailValidationMessage(), "Please fill out this field.");
    }

    @Test(priority = 10)
    public void testBlankInputPassword(){
        staffRegisterPage.inputNewStaff("JC-SQA-RPA12", "Elanda Nur Afwi Desto", "registered@example.com", "", validImages);

        DriverSingleton.delay(1);
        Assert.assertEquals(staffRegisterPage.getPasswordValidationMessage(), "Please fill out this field.");
    }

    @Test(priority = 11)
    public void testBlankInputSelfieImages(){
        driver.navigate().refresh();
        staffRegisterPage.inputNewStaffWithoutImage("JC-SQA-RPA12", "Elanda Nur Afwi Desto", "registered@example.com", "HighSecPassw0rd!@3");

        DriverSingleton.delay(1);
        Assert.assertEquals(staffRegisterPage.getImageValidationMessage(), "Please select a file.");
    }

//    @Test(priority = 12)
//    public void testInputFullNameOnlyNumber(){
//        staffRegisterPage.inputNewStaff("JC-SQA-RPA12", "123456789", "numberOnlyEmail@email.com", "HighSecPassw0rd!@3", validImages);
//
//        DriverSingleton.delay(1);
//        Assert.assertEquals(staffRegisterPage.getTextAlertMessage(), "Nama tidak boleh angka saja");
//    }
//    @Test(priority = 13)
//    public void testInputValidNewStaff(){
//        staffRegisterPage.inputNewStaff("JC-SQA-RPA12", "Elanda Nur Afwi Desto", "elandavalid@example.com", "HighSecPassw0rd!@3", validImages);
//
//        DriverSingleton.delay(1);
//        Assert.assertEquals(staffRegisterPage.getTextAlertMessage(), "berhasil register, silahkan menunggu di approve oleh admin");
//    }
}

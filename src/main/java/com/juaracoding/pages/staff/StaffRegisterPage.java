package com.juaracoding.pages.staff;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffRegisterPage {
    private WebDriver driver;

    public StaffRegisterPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "nik")
    private WebElement inputNikStaff;

    @FindBy(id = "fullname")
    private WebElement inputFullNameStaff;

    @FindBy(id = "email")
    private WebElement inputEmailStaff;

    @FindBy(id = "password")
    private WebElement inputPasswordStaff;

    @FindBy(name = "image")
    private WebElement uploadGambarStaff;

    @FindBy(css = ".MuiButton-contained")
    private WebElement tombolDaftarStaff;
    @FindBy(css = ".css-1qamc72")
    private WebElement textAlertMessage;

    public void setNikStaff(String nik){
        this.inputEmailStaff.clear();
        this.inputNikStaff.sendKeys(nik);
    }

    public void setFullNameStaff(String fullName){
        this.inputFullNameStaff.clear();
        this.inputFullNameStaff.sendKeys(fullName);
    }

    public void setEmailStaff(String emailStaff){
        this.inputEmailStaff.clear();
        this.inputEmailStaff.sendKeys(emailStaff);
    }

    public void setInputPasswordStaff(String passwordStaff){
        this.inputPasswordStaff.clear();
        this.inputPasswordStaff.sendKeys(passwordStaff);
    }

    public void setUploadGambarStaff(String imageURL){
        this.uploadGambarStaff.clear();
        this.uploadGambarStaff.sendKeys(imageURL);
    }

    public void setUploadGambarStaffTanpaFile(){
        this.uploadGambarStaff.clear();
        this.uploadGambarStaff.sendKeys();
    }

    public void klikTombolDaftarStaff(){
        tombolDaftarStaff.click();
    }

    public void inputNewStaff(String nikStaff, String fullNameStaff, String emailStaff, String passwordStaff, String imageURL){
        this.inputNikStaff.clear();
        this.inputNikStaff.sendKeys(nikStaff);

        this.inputFullNameStaff.clear();
        this.inputFullNameStaff.sendKeys(fullNameStaff);

        this.inputEmailStaff.clear();
        this.inputEmailStaff.sendKeys(emailStaff);

        this.inputPasswordStaff.clear();
        this.inputPasswordStaff.sendKeys(passwordStaff);

        this.uploadGambarStaff.clear();
        this.uploadGambarStaff.sendKeys(imageURL);

        DriverSingleton.delay(1);
        klikTombolDaftarStaff();
    }

    public void inputNewStaffWithoutImage(String nikStaff, String fullNameStaff, String emailStaff, String passwordStaff){
        this.inputNikStaff.clear();
        this.inputNikStaff.sendKeys(nikStaff);

        this.inputFullNameStaff.clear();
        this.inputFullNameStaff.sendKeys(fullNameStaff);

        this.inputEmailStaff.clear();
        this.inputEmailStaff.sendKeys(emailStaff);

        this.inputPasswordStaff.clear();
        this.inputPasswordStaff.sendKeys(passwordStaff);

        DriverSingleton.delay(1);
        klikTombolDaftarStaff();
    }

    public String getTextAlertMessage(){
        return textAlertMessage.getAttribute("innerHTML");
    }

    // TODO: Add verification to check blank per field

    public String getNikValidationMessage(){
        return inputNikStaff.getAttribute("validationMessage");
    }

    public String getEmailValidationMessage(){
        return inputEmailStaff.getAttribute("validationMessage");
    }

    public String getFullNameValidationMessage(){
        return inputFullNameStaff.getAttribute("validationMessage");
    }

    public String getPasswordValidationMessage(){
        return inputPasswordStaff.getAttribute("validationMessage");
    }

    public String getImageValidationMessage(){
        return uploadGambarStaff.getAttribute("validationMessage");
    }
}

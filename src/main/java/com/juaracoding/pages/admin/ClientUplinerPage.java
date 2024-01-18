package com.juaracoding.pages.admin;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.GlobalElementPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.plaf.PanelUI;

public class ClientUplinerPage {
    private WebDriver driver;
    private GlobalElementPage globalElementPage;

    private String randNamaKaryawanUpliner;
    private String randEmailKaryawanUpliner;

    public ClientUplinerPage(){
        this.driver = DriverSingleton.getDriver();
        this.globalElementPage = new GlobalElementPage();

        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "fullname")
    private WebElement inputNamaKaryawanUpliner;

    @FindBy(id = "password")
    private WebElement inputPasswordUpliner;

    @FindBy(id = "email")
    private WebElement inputEmailUpliner;

    @FindBy(css = "[data-testid='VisibilityOffIcon']")
    private WebElement buttonHidePassword;

    @FindBy(css = "[data-testid='VisibilityIcon']")
    private WebElement buttonShowPassword;

    @FindBy(id = "free-solo-with-text-demo")
    private WebElement inputJobDepartementUpliner;

    @FindBy(id = "role_id")
    private WebElement inputTipeUpliner;

    @FindBy(css = "[aria-selected='true']")
    private WebElement selectUplinerV2;

    @FindBy(css = "[aria-selected='false']")
    private WebElement selectUplinerV3;

    @FindBy(css = ".MuiButton-fullWidth")
    private WebElement buttonRegisterUpliner;

    @FindBy(css =".css-4075ia")
    private WebElement buttonAddNewClientUpliner;

    public void setFullNameUpliner(String fullNameUpliner){
        this.inputNamaKaryawanUpliner.clear();
        this.inputNamaKaryawanUpliner.sendKeys(fullNameUpliner);

        getInputNamaKaryawanUpliner();
        randNamaKaryawanUpliner = getInputNamaKaryawanUpliner();
    }

    public void setEmailUpliner(String emailUpliner){
        this.inputEmailUpliner.clear();
        this.inputEmailUpliner.sendKeys(emailUpliner);

        getInputEmailUpliner();
        randEmailKaryawanUpliner = getInputEmailUpliner();
    }

    public String getEmailValidationMessage(){
        return inputEmailUpliner.getAttribute("validationMessage");
    }

    public void setPasswordUpliner(String passwordUpliner){
        this.inputPasswordUpliner.clear();
        this.inputPasswordUpliner.sendKeys(passwordUpliner);
    }

    public String getPasswordValidationMessage(){
        return inputPasswordUpliner.getAttribute("validationMessage");
    }

    public void clickButtonHidePassword(){
        buttonHidePassword.click();
    }

    public void clickbuttonShowPassword(){
        buttonShowPassword.click();
    }

    public void setJobDepartementUpliner(String jobDepartementUpliner){
        this.inputJobDepartementUpliner.clear();
        this.inputJobDepartementUpliner.sendKeys(jobDepartementUpliner);

        DriverSingleton.delay(1);
        this.inputJobDepartementUpliner.sendKeys(Keys.SPACE);
        DriverSingleton.delay(1);
        this.inputJobDepartementUpliner.sendKeys(Keys.BACK_SPACE);
        DriverSingleton.delay(1);
        this.inputJobDepartementUpliner.sendKeys(Keys.ARROW_DOWN);
        DriverSingleton.delay(1);
        this.inputJobDepartementUpliner.sendKeys(Keys.ENTER);
    }

    public void setTipeUplinerV2(){
        this.inputTipeUpliner.click();
        DriverSingleton.delay(1);
        this.selectUplinerV2.click();
    }

    public void setTipeUplinerV3(){
        this.inputTipeUpliner.click();
        DriverSingleton.delay(1);
        this.selectUplinerV3.click();
    }

    public void clickRegisterUpliner(){
        buttonRegisterUpliner.click();
    }

    public void clickAddNewButtonClientUpliner(){
        buttonAddNewClientUpliner.click();
    }

    public String getInputNamaKaryawanUpliner(){
        return inputNamaKaryawanUpliner.getAttribute("value");
    }

    public String getInputEmailUpliner(){
        return inputEmailUpliner.getAttribute("value");
    }

    public void inputNewClientUpliner(String fullNameUpliner, String emailUpliner, String passwordUpliner) {
        this.inputNamaKaryawanUpliner.clear();
        this.inputNamaKaryawanUpliner.sendKeys(fullNameUpliner);

        DriverSingleton.delay(1);
        getInputNamaKaryawanUpliner();
        randNamaKaryawanUpliner = getInputNamaKaryawanUpliner();

        this.inputEmailUpliner.clear();
        this.inputEmailUpliner.sendKeys(emailUpliner);

        DriverSingleton.delay(1);
        getInputEmailUpliner();
        randEmailKaryawanUpliner = getInputEmailUpliner();

        this.inputPasswordUpliner.clear();
        this.inputPasswordUpliner.sendKeys(passwordUpliner);
    }

    public String getRandNamaKaryawanUpliner() {
        return randNamaKaryawanUpliner;
    }

    public String getRandEmailKaryawanUpliner() {
        return randEmailKaryawanUpliner;
    }
}


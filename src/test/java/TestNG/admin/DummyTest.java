package TestNG.admin;

import TestNG.TestBase;
import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.GlobalElementPage;
import com.juaracoding.pages.admin.*;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;

import static com.juaracoding.utils.Constant.ADMIN_URL;

public class DummyTest extends TestBase {
    public DivisiPage divisiPage;
    public AdminLoginPage adminLoginPage;
    public AdminDashboardPage adminDashboardPage;
    public PosisiPage posisiPage;
    public ClientUplinerPage clientUplinerPage;
    public GlobalElementPage globalElementPage;

    Faker faker = new Faker();

    String fullName = faker.name().fullName();
    String email = faker.internet().emailAddress();
    String password = faker.internet().password();


    @BeforeClass
    public void testEnvironmentSetUP(){
        setUpChrome();

        driver.get(ADMIN_URL);

        divisiPage = new DivisiPage();
        adminLoginPage = new AdminLoginPage();
        adminDashboardPage = new AdminDashboardPage();
        posisiPage = new PosisiPage();
        clientUplinerPage = new ClientUplinerPage();
        globalElementPage = new GlobalElementPage();

    }
    @AfterClass
    public void finish(){
        DriverSingleton.delay(1);
        DriverSingleton.closeObjectInstance();
    }

    private void scrollPageToBottom() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        DriverSingleton.delay(1);

    }

    @Test(priority = 1)
    public void testValidLogin(){
        globalElementPage.setEmail("admin@hadir.com");
        globalElementPage.setPassword("admin@hadir");
        adminLoginPage.clickAdminLoginButton();
        adminDashboardPage.clickManagementSideBar();
//        adminDashboardPage.clickDivisiSideBar();
//        adminDashboardPage.clickUnitSideBar();
//        adminDashboardPage.clickPosisiSideBar();
          adminDashboardPage.clickClientUplinerSidebar(); 
    }

    @Test(priority = 3)
    public void testMovePage(){

        clientUplinerPage.clickAddNewButtonClientUpliner();
        clientUplinerPage.inputNewClientUpliner(fullName, email, password);
        clientUplinerPage.setJobDepartementUpliner("Air Asia");
        clientUplinerPage.setTipeUplinerV2();
        clientUplinerPage.clickRegisterUpliner();

        Assert.assertEquals(globalElementPage.getTextFromTopmostRowSecondColumn(), clientUplinerPage.getRandNamaKaryawanUpliner());
    }
}

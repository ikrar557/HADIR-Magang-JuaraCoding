package TestNG.staff;

import TestNG.TestBase;
import com.juaracoding.pages.GlobalElementPage;
import com.juaracoding.pages.admin.AdminLoginPage;
import com.juaracoding.pages.staff.StaffLoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.juaracoding.utils.Constant.STAFF_URL;

public class StaffLoginTest extends TestBase {
    StaffLoginPage staffLoginPage;
    GlobalElementPage globalElementPage;

    @BeforeClass
    public void testSetUpEnvironmentChrome(){
        setUpChrome();
        driver.get(STAFF_URL);
        staffLoginPage = new StaffLoginPage();
        globalElementPage = new GlobalElementPage();
    }

    @Test(priority = 1)
    public void testValidLogin(){
        globalElementPage.setEmail("delehil399@wikfee.com");
        globalElementPage.setPassword("r4ngk1ng");
        staffLoginPage.clickStaffLoginButton();

    }
}

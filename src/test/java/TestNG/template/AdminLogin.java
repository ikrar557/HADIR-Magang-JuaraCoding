package TestNG.template;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.GlobalElementPage;
import com.juaracoding.pages.admin.AdminLoginPage;
import com.juaracoding.utils.Constant;
import org.openqa.selenium.WebDriver;

public class AdminLogin {
    final String LOGIN_URL = Constant.ADMIN_URL;
    private GlobalElementPage globalElementPage;
    private String pageUrl;
    private AdminLoginPage adminLoginPage;
    private WebDriver driver;

    public AdminLogin(
            GlobalElementPage globalElementPage,
            WebDriver driver,
            String pageUrl
    ) {
        this.globalElementPage = globalElementPage;
        this.pageUrl = pageUrl;
        this.driver = driver;
        this.adminLoginPage = new AdminLoginPage();
    }

    public void loginUser() {
        driver.get(LOGIN_URL);
        globalElementPage.setEmail("admin@hadir.com");
        globalElementPage.setPassword("admin@hadir");
        adminLoginPage.clickAdminLoginButton();
        DriverSingleton.delay(3);
        driver.get(pageUrl);
    }

}

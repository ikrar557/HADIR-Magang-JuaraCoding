package TestNG.admin;

import com.juaracoding.pages.admin.AdminDashboardPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdminDashboardTest{
    public AdminDashboardPage adminDashboardPage;

    @BeforeClass
    public void testEnvironmentSetup(){
        adminDashboardPage = new AdminDashboardPage();
    }

    @Test(priority = 1)
    public void testNavigateToManagementMenu(){
        adminDashboardPage.clickManagementSideBar();
    }

    @Test(priority = 2)
    public void testNavigateToDivisiMenu(){
        adminDashboardPage.clickDivisiSideBar();
    }

}

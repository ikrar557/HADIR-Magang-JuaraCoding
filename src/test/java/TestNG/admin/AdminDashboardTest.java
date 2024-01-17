package TestNG.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminDashboardTest {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        // Pengaturan path untuk Chrome WebDriver
        System.setProperty("webdriver.chrome.driver", "C:\\MyTools\\chromedriver.exe");

        // Inisialisasi instance WebDriver untuk Chrome
        driver = new ChromeDriver();
    }

    @Test
    public void loginAndVerifyDashboard() {
        // Buka halaman login
        driver.get("https://dev.dikahadir.com/authentication/login");

        // Masukkan email dan password
        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("admin@hadir.com");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("admin@hadir");

        // Klik tombol login
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div[2]/div/div[2]/form/button"));
        loginButton.click();

        // Tunggu sampai halaman dashboard muncul
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("/dashboards/dashboard"));

        // Verifikasi bahwa halaman dashboard telah dimuat dengan benar
        Assert.assertTrue(driver.getCurrentUrl().contains("/dashboards/dashboard"), "Dashboard page is not loaded properly");
    }

    @AfterTest
    public void tearDown() {
        // Tutup browser
        driver.quit();
    }
}

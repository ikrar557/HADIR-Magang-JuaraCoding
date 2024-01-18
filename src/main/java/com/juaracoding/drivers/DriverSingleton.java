package com.juaracoding.drivers;

import com.juaracoding.drivers.strategies.DriverStrategy;
import com.juaracoding.drivers.strategies.DriverStrategyImplementer;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class DriverSingleton {

    private static DriverSingleton instance = null;
    private static WebDriver driver;

    private DriverSingleton(String driverType) {
        instantiate(driverType);
    }

    public void instantiate(String strategy) {
        if (driver != null) {
            return;
        }
        try {
            DriverStrategy driverStrategy = DriverStrategyImplementer.chooseStrategy(strategy);
            driver = driverStrategy.setStrategy();
            configureDriver();
        } catch (Exception e) {
            // Handle exceptions or log errors
            throw new RuntimeException("Failed to instantiate WebDriver", e);
        }
    }

    private void configureDriver() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static void getInstance(String driverType) {
        if (instance == null) {
            instance = new DriverSingleton(driverType);
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void delay(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeObjectInstance() {
        instance = null;
        if (driver != null) {
            driver.quit();
        }
    }
}

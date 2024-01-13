package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private static DriverManager driver_ddd = null;

    public static WebDriver driver;
    private DriverManager() {
    }

    public static DriverManager getDriverInstance() {
        if(driver_ddd == null) {
            driver_ddd = new DriverManager();
        }
        return driver_ddd;
    }

    public WebDriver getDriver() {
        if(driver==null){
            initDriver();
        }
        return driver;
    }

    private void initDriver() {
        driver = new ChromeDriver();
    }

    public void quitDriver() {
        if(driver!=null) {
            driver.quit();
            driver = null;
        }
    }

}
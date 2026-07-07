package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSetup {

    private static WebDriver driver;

    public static void initializeDriver() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();
    }

    public static WebDriver getDriver() {

        return driver;
    }
}
package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.DriverSetup;

public class HomePage {

    WebDriver driver = DriverSetup.getDriver();
    By searchBox = By.id("search-autocomplete-input");

    public boolean verifySearchBox() {
        return driver.findElement(searchBox).isDisplayed()
                && driver.findElement(searchBox).isEnabled();
    }
}

package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pageobjects.SearchPage;
import utilities.DriverSetup;

public class Hooks extends DriverSetup{

    @Before
    public void setup(Scenario snr) {
        DriverSetup.initializeDriver();
        DriverSetup.getDriver().get("https://www.coursera.org/");
    }




    @After
    public void tearDown(Scenario snr) {
        DriverSetup.getDriver().quit();
    }
}

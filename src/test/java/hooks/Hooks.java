package hooks;

import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.DriverSetup;



public class Hooks extends DriverSetup{

    @Before
    public void setup() {
        DriverSetup.initializeDriver();
    }

    @After
    public void tearDown(Scenario snr) throws IOException {

            if (snr.isFailed()) {
                // Take screenshot
                final byte[] screenshot = ((TakesScreenshot) DriverSetup.getDriver()).getScreenshotAs(OutputType.BYTES);
                // Attach to the report
                snr.attach(screenshot, "image/png", "Screenshot of failure");
            }

    	DriverSetup.getDriver().quit();
    }
}

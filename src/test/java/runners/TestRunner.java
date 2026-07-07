package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/01_CourseSearch.feature",
        glue = {"stepdefinitions", "hooks"},   // must match package names
        monochrome = true,
        plugin = {"pretty",
        		"html:target/cucumber-report.html",
        		"json:target/cucumber-report.json",
        		"junit:target/cucumber-report.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        		},
        dryRun = false
)
public class TestRunner {
	
}
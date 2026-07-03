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

    @Before("@Beginner")
    public void setupBeginner() {
        SearchPage searchPage = new SearchPage();
        searchPage.searchCourse("Web Development");
    }

    @Before("@Language")
    public void setupLanguage() {
        SearchPage searchPage = new SearchPage();
        searchPage.searchCourse("Web Development");
        searchPage.selectBeginnerFilter();
    }

    @Before("@CourseDetails")
    public void setupCourseDetails() {
        SearchPage searchPage = new SearchPage();
        searchPage.searchCourse("Web Development");
        searchPage.selectBeginnerFilter();
        searchPage.selectEnglishFilter();

        // Ensure courses are loaded before capture
        searchPage.verifyMinimumCourses();
    }

    @After
    public void tearDown(Scenario snr) {
        DriverSetup.getDriver().quit();
    }
}

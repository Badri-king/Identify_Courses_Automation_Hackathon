package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import pageobjects.SearchPage;
import utilities.DriverSetup;

public class Hooks {

    @Before
    public void setup() {
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
//
//    @After
//    public void tearDown() {
//        DriverSetup.getDriver().quit();
//    }
}

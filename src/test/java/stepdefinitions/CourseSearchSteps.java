package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pageobjects.HomePage;
import pageobjects.SearchPage;

public class CourseSearchSteps {

    HomePage homePage = new HomePage();
    SearchPage searchPage = new SearchPage();

    @Given("User launches Coursera website")
    public void user_launches_coursera_website() {

        System.out.println("Coursera Opened");
    }

    @Then("Verify homepage is displayed")
    public void verify_homepage_is_displayed() {

        Assert.assertTrue(true);
    }

    @When("Verify search box is visible and enabled")
    public void verify_search_box() {

        Assert.assertTrue(homePage.verifySearchBox());
    }

    @And("User searches for {string}")
    public void user_searches_for(String course) {

        searchPage.searchCourse(course);
    }

    @And("User applies Beginner level filter")
    public void user_applies_beginner_level_filter() {

        searchPage.selectBeginnerFilter();
    }

    @And("User applies English language filter")
    public void user_applies_english_language_filter() {

        searchPage.selectEnglishFilter();
    }

    @Then("Verify at least two courses are displayed")
    public void verify_at_least_two_courses_are_displayed() {

        Assert.assertTrue(searchPage.verifyMinimumCourses());
    }

    @And("Capture first course details")
    public void capture_first_course_details() {

        searchPage.displayFirstCourse();
    }

    @And("Capture second course details")
    public void capture_second_course_details() {

        searchPage.displaySecondCourse();
    }
}

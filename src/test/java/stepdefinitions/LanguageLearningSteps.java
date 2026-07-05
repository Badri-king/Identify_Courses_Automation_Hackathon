package stepdefinitions;

//import driverSetup.DriverInstance;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.LanguageLearningPage;
import utilities.DriverSetup;

import java.util.ArrayList;
import java.util.List;

//import static utilities.DriverSetup.driver;

public class LanguageLearningSteps extends DriverSetup {

    LanguageLearningPage lp = new LanguageLearningPage();


    @Given("user should navigate to coursera page")
    public void userNavigate() {
        lp.userNavigating();

    }

    @When("user clicks LanguageLearning option in homepage")
    public void clickLearning(){

        lp.clickLearnings();


    }

    @Then("checks it displays LanguageLearning page")
    public void displaysLanguagePage() {
        String title = getDriver().getTitle();
        Assert.assertEquals(true,title.contains("Language Learning"));
    }
    @When("user extract the total count of the courses and credentials")
    public void returnDetails(){

        lp.returningDetails();


    }

    @When("user Verify total number of languages displayed and display languages")
    public void numOfLanguages() throws InterruptedException {



        Thread.sleep(2000);
        lp.numberOfLanguages();

    }

    @When("user Verify level count and display results and extract levels.")
    public void levelCount(){

        lp.levelCounts();


    }

    //*[@id="search-page-filters"]/div/div/div/div/div/div/div/div/div[2]/div[2]/button/span


}
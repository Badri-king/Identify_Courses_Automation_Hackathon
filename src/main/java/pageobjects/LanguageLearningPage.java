package pageobjects;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.DriverSetup;

import java.util.ArrayList;
import java.util.List;
//import org.junit.Assert;

public class LanguageLearningPage {

    WebDriver driver = DriverSetup.getDriver();

    By LlOption = By.xpath("//a[.='Language Learning']");
    By cred =By.xpath("//div[@class='css-fxrpmp']/child::span");
    By course= By.xpath("//div[@class='css-fxrpmp']/following::div/child::span[@class='css-fk6qfz']");
    By showMore = By.xpath("//*[@id=\"search-page-filters\"]/div/div/div/div/div/div/div/div/div[2]/div[2]/button/span");
    By languages = By.xpath("//div[@data-testid='search-filter-group-Language']//div[contains(@data-testid, 'language:')]//span[contains(@class, 'cds-checkboxAndRadio-labelContent')]/span[1]");
    By levels = By.xpath("//div[@data-testid='search-filter-group-Level']//div[contains(@data-testid, 'Level:')]//span[contains(@class, 'cds-checkboxAndRadio-labelContent')]/span[1]");


    public void userNavigating() {
        driver.get("https://www.coursera.org/");
    }


    public void clickLearnings() {
        driver.findElement(LlOption).click();
    }

//    public void displaysLanguagePage() {
//
//        String title = driver.getTitle();
//        Assert.assertEquals(true,title.contains("Language Learning"));
//    }

    public void returningDetails() {
        String credentials = driver.findElement(cred).getText();
        String courses = driver.findElement(course).getText();
        System.out.println("Credentials : "+credentials+"\n Courses : "+courses);
    }

    public void numberOfLanguages() throws InterruptedException {

        driver.findElement(showMore).click();
//        String languagesXPath = "//div[@data-testid='search-filter-group-Language']//div[contains(@data-testid, 'language:')]//span[contains(@class, 'cds-checkboxAndRadio-labelContent')]/span[1]";
        List<WebElement> languageElements = driver.findElements(languages);

        List<String> languageList = new ArrayList<>();

        // Iterate through the WebElements, get the text, and add to the List
        for (WebElement element : languageElements) {
            String languageName = element.getText().trim();
            if (!languageName.isEmpty()) {
                languageList.add(languageName);
            }
        }
        System.out.println("Total languages found: " + languageList.size());
        for (String lang : languageList) {
            System.out.println(lang);
        }

    }

    public void levelCounts(){

//        String levelXPath = "//div[@data-testid='search-filter-group-Level']//div[contains(@data-testid, 'Level:')]//span[contains(@class, 'cds-checkboxAndRadio-labelContent')]/span[1]";
        List<WebElement> levelElements = driver.findElements(levels);
        List<String> levelList = new ArrayList<>();

        // Iterate through the WebElements, get the text, and add to the List
        for (WebElement element : levelElements) {
            String levelName = element.getText().trim();
            if (!levelName.isEmpty()) {
                levelList.add(levelName);
            }
        }
        System.out.println("Total levels found: " + levelList.size());
        for (String lev : levelList) {
            System.out.println(lev);
        }


    }







}

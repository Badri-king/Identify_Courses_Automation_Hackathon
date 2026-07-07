package pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DriverSetup;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class LanguageLearningPage {

    WebDriver driver = DriverSetup.getDriver();

    By LlOption = By.xpath("//a[.='Language Learning']");
    By cred =By.xpath("//div[@class='css-fxrpmp']/child::span");
    By course= By.xpath("//div[@class='css-fxrpmp']/following::div/child::span[@class='css-fk6qfz']");
    By showMore = By.xpath("//*[@id=\"search-page-filters\"]/div/div/div/div/div/div/div/div/div[2]/div[2]/button/span");
    By languages = By.xpath("//div[@data-testid='search-filter-group-Language']//div[contains(@data-testid, 'language:')]//span[contains(@class, 'cds-checkboxAndRadio-labelContent')]/span[1]");
    By levels = By.xpath("//div[@data-testid='search-filter-group-Level']//div[contains(@data-testid, 'Level:')]//span[contains(@class, 'cds-checkboxAndRadio-labelContent')]/span");
    By iframe=By.xpath("//iframe[@title='Modal Message']");
    By pop=By.xpath("//button[@id='ir4u2']");

    public void userNavigating() {
        driver.get("https://www.coursera.org/");
    }


    public void clickLearnings() {
        driver.findElement(LlOption).click();

    try{
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));

        WebElement popup = wait.until(
                ExpectedConditions.elementToBeClickable(pop)
        );
        popup.click();
        driver.switchTo().defaultContent();

    }catch(Exception e){
    System.out.println("Popup is not Displayed");
}
    }



    public void returningDetails() {
        String credentials = driver.findElement(cred).getText();
        String courses = driver.findElement(course).getText();
        System.out.println("Credentials : "+credentials+"\n Courses : "+courses);
    }

    public void numberOfLanguages(){

        driver.findElement(showMore).click();
        List<WebElement> languageElements = driver.findElements(languages);

        List<String> languageList = new ArrayList<>();


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

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));
        List<WebElement> levelElements= wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(levels)));

        List<String> levelList=new ArrayList<>();
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

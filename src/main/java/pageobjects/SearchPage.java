package pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DriverSetup;
import java.time.Duration;
import java.util.List;

public class SearchPage {

    WebDriver driver = DriverSetup.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    By searchBox = By.id("search-autocomplete-input");
    By filterSort = By.xpath("//div[contains(text(),'Filter')]");
    By languageDropdown = By.xpath("//*[contains(text(),'Language')]");
    By englishCheckbox = By.xpath("//span[text()='English']");
    By viewButton = By.xpath("//span[contains(text(),'View')]");
    By courseTitles = By.xpath("//h3[contains(@class,'cds-CommonCard-title')]");
    By ratings = By.xpath("//div[@class='cds-RatingStat-sizeLabel css-urxg4f']//span[@class='css-4s48ix'] | //div[@class='cds-CommonCard-metadata']/p[@class='css-1leqd7o']");
    By learningHours = By.xpath("//div[contains(@class,'CommonCard-metadata')]");

    public void searchCourse(String course) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
        driver.findElement(searchBox).sendKeys(course);
        driver.findElement(searchBox).sendKeys(Keys.ENTER);
    }

    public void selectBeginnerFilter() {
        wait.until(ExpectedConditions.elementToBeClickable(filterSort)).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement levelElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Level']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", levelElement);


        WebElement beginner = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//div[@data-testid='productDifficultyLevel:Beginner-false']//label")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", beginner);

        WebElement view = wait.until(ExpectedConditions.elementToBeClickable(viewButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", view);

        System.out.println("Beginner Filter Applied");
    }

    public void selectEnglishFilter() {
        WebElement lan = driver.findElement(languageDropdown);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", lan);

        WebElement english = wait.until(ExpectedConditions.elementToBeClickable(englishCheckbox));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", english);

        WebElement view = wait.until(ExpectedConditions.elementToBeClickable(viewButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", view);

        System.out.println("English Filter Applied");
    }

    public boolean verifyMinimumCourses() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(courseTitles));
        List<WebElement> courses = driver.findElements(courseTitles);
        return courses.size() >= 2;
    }

    public void displayFirstCourse() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(courseTitles));
        List<WebElement> titles = driver.findElements(courseTitles);
        List<WebElement> ratingList = driver.findElements(ratings);
        List<WebElement> durationList = driver.findElements(learningHours);

        if (!titles.isEmpty()) {
            String title = titles.get(0).getText();
            String rating = ratingList.size() > 0 ? ratingList.get(0).getText() : "NA";
            String duration = durationList.size() > 0 ? durationList.get(0).getText() : "NA";
            String[] parts = duration.split("·");
            if (parts.length > 1) {
                duration = parts[parts.length - 1].trim(); // take last part (e.g., "1 - 4 Weeks")
            }

            if (rating.length() > 3) {

                rating = rating.substring(2, 5);
            }

                System.out.println("================================");
                System.out.println("Course 1");
                System.out.println("Name : " + title);
                System.out.println("Rating : " + rating);
                System.out.println("Learning Hours : " + duration);
            }
        }



    public void displaySecondCourse() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(courseTitles));
        List<WebElement> titles = driver.findElements(courseTitles);
        List<WebElement> ratingList = driver.findElements(ratings);
        List<WebElement> durationList = driver.findElements(learningHours);

        if (titles.size() > 1) {
            String title = titles.get(1).getText();
            String rating = ratingList.size() > 1 ? ratingList.get(1).getText() : "NA";
            String duration = durationList.size() > 1 ? durationList.get(1).getText() : "NA";
            String[] parts = duration.split("·");
            if (parts.length > 1) {
                duration = parts[parts.length - 1].trim(); // take last part (e.g., "1 - 4 Weeks")
            }
            if (rating.length() > 3) {

                rating = rating.substring(2, 5);
            }
            System.out.println("================================");
            System.out.println("Course 2");
            System.out.println("Name : " + title);
            System.out.println("Rating : " + rating);
            System.out.println("Learning Hours : " + duration);
        }
    }
}

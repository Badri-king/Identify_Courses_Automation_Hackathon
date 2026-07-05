package pageobjects;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DriverSetup;

import java.io.File;
import java.io.IOException;
import java.time.Duration;



public class EnterprisePage {

    WebDriver driver = DriverSetup.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    JavascriptExecutor js=(JavascriptExecutor) driver;
    By forEnterprise=By.xpath("//a[text()='For Enterprise']");
    By formSection=By.xpath("//div[@class='cds-9 BlockLayout-imageGrid css-1k3ipra cds-11 cds-grid-item cds-56 cds-64']");
    By firstName=By.xpath("//input[@id='FirstName']");
    By lastName=By.xpath("//input[@id='LastName']");
    By email=By.xpath("//input[@id='Email']");
    By phone =By.xpath("//input[@id='Phone']");
    By organization=By.xpath("//select[@id='rentalField9']");
    By title= By.xpath("//input[@id='Title']");
    By company= By.xpath("//input[@id='Company']");
    By companySize= By.xpath("//select[@id='Employee_Range__c']");

    By describe=By.xpath("//select[@id='Self_Reported_Needs__c']");
    By country=By.xpath("//select[@id='Country']");
    By stateSelection=By.xpath("//select[@id='State']");
    By btn=By.xpath("//button[@class='mktoButton']");
    By errorMsg=By.xpath("//div[@id='ValidMsgEmail']");

    public void navigateToEnterprise(){

        WebElement enterprise=wait.until(ExpectedConditions.elementToBeClickable(forEnterprise));

        js.executeScript("arguments[0].scrollIntoView(true);",enterprise);
        enterprise.click();
    }
    public String getEnterprisePageTitle(){
        return driver.getTitle();
    }

    public void navigateTOForm(){
        WebElement form=wait.until(ExpectedConditions.visibilityOfElementLocated(formSection));
        js.executeScript("arguments[0].scrollIntoView(true)",form);

    }

    public boolean verifyForm(){
        return driver.findElement(formSection).isDisplayed();
    }


    public void enterFormDetails(String fName,
                                 String lName,
                                 String mail,
                                 String ph,
                                 String org,
                                 String jobTitle,
                                 String companyName,
                                 String companyN0,
                                 String desc,
                                 String nation,String state) {

                driver.findElement(firstName).sendKeys(fName);
                driver.findElement(lastName).sendKeys(lName);
                driver.findElement(email).sendKeys(mail);
                driver.findElement(phone).sendKeys(ph);

                new Select(driver.findElement(organization))
                        .selectByVisibleText(org);

                driver.findElement(title).sendKeys(jobTitle);
                driver.findElement(company).sendKeys(companyName);
                new Select(driver.findElement(companySize)).selectByVisibleText(companyN0);
                new Select(driver.findElement(describe))
                        .selectByVisibleText(desc);

                new Select(driver.findElement(country))
                        .selectByVisibleText(nation);
        new Select(driver.findElement(stateSelection))
                .selectByVisibleText(state);
            }








    public void submitForm(){
        driver.findElement(btn).click();
    }

    public String captureErrorMsg() throws IOException {
       WebElement err= wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg));
        File screenshot = err.getScreenshotAs(OutputType.FILE);

        // Save to desired location
        FileUtils.copyFile(screenshot, new File("screenshot/coursera_homepage.png"));

        return err.getText();
    }




}

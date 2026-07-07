package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pageobjects.EnterprisePage;
import utilities.ExcelUtils;

import java.io.IOException;

public class EnterpriseFormSteps {

    EnterprisePage enterprisePage=new EnterprisePage();
    @When("Navigate to For Enterprise section")
    public void navigate_to_for_enterprise_section() {
        // Write code here that turns the phrase above into concrete actions
        enterprisePage.navigateToEnterprise();


    }
    @Then("Verify For Enterprise page is displayed")
    public void verify_for_enterprise_page_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals("Online Business Learning Platform | Coursera for Business",enterprisePage.getEnterprisePageTitle());

    }



    @When("Navigate to form section")
    public void navigate_to_form_section() {
        // Write code here that turns the phrase above into concrete actions
    enterprisePage.navigateTOForm();
    }
    @Then("Verify form is displayed")
    public void verify_form_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
      Assert.assertTrue( enterprisePage.verifyForm());
    }






    @When("Enter all mandatory details with invalid email")
    public void enter_all_mandatory_details_with_invalid_email() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        String excelPath = "src/test/resources/TestData.xlsx";
        ExcelUtils obj=new ExcelUtils();
        String firstName = obj.getCellData(excelPath, "Sheet1", 1, 0);
        String lastName = obj.getCellData(excelPath, "Sheet1", 1, 1);
        String email = obj.getCellData(excelPath, "Sheet1", 1, 2);
        String phone = obj.getCellData(excelPath, "Sheet1", 1, 3);
        String organization = obj.getCellData(excelPath, "Sheet1", 1, 4);
        String title = obj.getCellData(excelPath, "Sheet1", 1, 5);
        String companyname = obj.getCellData(excelPath, "Sheet1", 1, 6);
        String companysize = obj.getCellData(excelPath, "Sheet1", 1, 7);
        String describe = obj.getCellData(excelPath, "Sheet1", 1, 8);
        String country = obj.getCellData(excelPath, "Sheet1", 1, 9);
        String state = obj.getCellData(excelPath, "Sheet1", 1, 10);
        EnterprisePage  page = new EnterprisePage();

        page.enterFormDetails(
                firstName,
                lastName,
                email,
                phone,
                organization,
                title,
                companyname,
                companysize,
                describe,
                country,
                state
        );
    }




    @When("Submit form")
    public void submit_form()  {
        // Write code here that turns the phrase above into concrete actions
      enterprisePage.submitForm();

    }
    @Then("Capture and display email validation error message")
    public void capture_and_display_email_validation_error_message() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        String err=enterprisePage.captureErrorMsg();
        System.out.println(err);
        Assert.assertNotNull(err);
    }


}

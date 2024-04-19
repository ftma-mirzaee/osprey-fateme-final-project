package osprey_final_project.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import osprey_final_project.pages.FormPage;
import osprey_final_project.pages.HomePage;
import osprey_final_project.utilities.SeleniumUtility;

import java.util.Map;

import static org.junit.Assert.assertTrue;

public class HomePageSteps extends SeleniumUtility {
    @When("navigate to the home page and validate that the title {string}")
    public void validateTitle(String expectedTitle) {
        String actualTitle = getDriver().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

    }

    @Then("validate create Primary Account Button exist")
    public void validateAccountButton() {
        boolean isDisplayed = isElementDisplayed(HomePage.Create_Account_Button);
        assertTrue(isDisplayed);
    }


    @Given("click on Create Primary Account button")
    public void clickOnCreateAccountButton() {
        clickElement(HomePage.Click_Account_Button);

    }
    @When("navigate to Create Account form page and validate form title {string}")
    public void validateFormTitle(String string) {
        boolean isDisplayed = isElementDisplayed(HomePage.Form_Title);
        assertTrue(isDisplayed);

    }
    @Given("user fill up the form")
    public void userFillUpTheForm(DataTable dataTable) {

        Map<String, String> data = dataTable.asMap();

        String emailAddress = data.get("Email Address");
        String firstName = data.get("First Name");
        String gender = data.get("Gender");
        String titlePrefix = data.get("Title/Prefix");
        String lastName = data.get("Last Name");
        String maritalStatus = data.get("Marital Status");
        String dateOfBirth = data.get("Date Of Birth");

        sendTextToElement(FormPage.Email_Input, emailAddress);
        sendTextToElement(FormPage.First_name_input, firstName);
        sendTextToElement(FormPage.Gender, gender);
        sendTextToElement(FormPage.Title_prefix, titlePrefix);
        sendTextToElement(FormPage.Last_Name_Input, lastName);
        sendTextToElement(FormPage.Marital_Status, maritalStatus);
        sendTextToElement(FormPage.Date_of_Birth, dateOfBirth);

    }
    @And("click on create account button")
    public void clickOnAccountButton() {
        clickElement(FormPage.Create_Account_Btn);

    }


    @Then("validate user navigate to signup page and email address shows as expected")
    public void validateEmailAddress() {
        boolean isDisplayed = isElementDisplayed(FormPage.Email_Add);
        assertTrue(isDisplayed);
    }
    @Given("Navigate to insurance app and click on create account button")
    public void clickCreateAccountButton(){
        clickElement(HomePage.Click_Account_Button);
    }

    @Given("create account with existed email")
    public void createAccountWithExistedEmail(DataTable dataTable){
        Map<String, String> data = dataTable.asMap();

        String emailAddress = data.get("Email Address");
        String firstName = data.get("First Name");
        String gender = data.get("Gender");
        String titlePrefix = data.get("Title/Prefix");
        String lastName = data.get("Last Name");
        String maritalStatus = data.get("Marital Status");
        String dateOfBirth = data.get("Date Of Birth");

        sendTextToElement(FormPage.Email_Input, emailAddress);
        sendTextToElement(FormPage.First_name_input, firstName);
        sendTextToElement(FormPage.Gender, gender);
        sendTextToElement(FormPage.Title_prefix, titlePrefix);
        sendTextToElement(FormPage.Last_Name_Input, lastName);
        sendTextToElement(FormPage.Marital_Status, maritalStatus);
        sendTextToElement(FormPage.Date_of_Birth, dateOfBirth);
    }



    @Then("Click create account validate error message as expected")
    public void validateErrorMessage(){
        clickElement(FormPage.Create_Account_Btn);
        boolean isDisplayed = isElementDisplayed(FormPage.Error_Message);
        assertTrue(isDisplayed);
    }
}

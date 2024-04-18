package osprey_final_project.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import osprey_final_project.pages.LoginPage;
import osprey_final_project.utilities.SeleniumUtility;

import java.util.Map;

import static org.junit.Assert.assertTrue;

public class LoginPageSteps extends SeleniumUtility {

    @Given("click on login button")
    public void clickOnLoginButton() {
        clickElement(LoginPage.Login_btn);

    }


    @When("enter valid credentials")
    public void enterValidCredentials(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap();

        String userName = data.get("Username");
        String password = data.get("Password");

        sendTextToElement(LoginPage.User_name, userName);
        sendTextToElement(LoginPage.Password, password);
    }


    @Then("click on sign in button and validate user is in customer service portal")
    public void validateUserIsInCustomerServicePortal() {
        clickElement(LoginPage.Sign_In);

        boolean isDisplayed = isElementDisplayed(LoginPage.Customer_Portal);
        assertTrue(isDisplayed);
    }

    @When("enter invalid username")
    public void enterInvalidUsername(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap();
        String userName = data.get("Username");
        String password = data.get("Password");

        sendTextToElement(LoginPage.User_name, userName);
        sendTextToElement(LoginPage.Password, password);


    }

    @When("user enter invalid {string} and valid {string}")
    public void userEnterInvalidCredentials(String Username, String Password) {
        sendTextToElement(LoginPage.User_name, Username);
        sendTextToElement(LoginPage.Password, Password);

        clickElement(LoginPage.Sign_In);
    }

    @Then("click on sign in button and validate user can not login")
    public void validateErrorMessage() {
        boolean isDisplayed = isElementDisplayed(LoginPage.Login_Error);
        assertTrue(isDisplayed);
    }
}

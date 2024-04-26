package osprey_final_project.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import osprey_final_project.pages.HomePage;
import osprey_final_project.pages.LoginPage;
import osprey_final_project.pages.UserProfilePage;
import osprey_final_project.utilities.SeleniumUtility;

import java.util.Map;

import static org.junit.Assert.assertTrue;

public class UserProfileSteps extends SeleniumUtility {

    @Given("click on login button and login with correct credentials")
    public void EnteringWithValidCredentials(DataTable dataTable) {
        clickElement(LoginPage.Login_btn);
        Map<String, String> data = dataTable.asMap();

        String userName = data.get("Username");
        String password = data.get("Password");

        sendTextToElement(LoginPage.User_name, userName);
        sendTextToElement(LoginPage.Password, password);


    }
    @And("click on sign in button")
    public void ClickSignIn(){
        clickElement(LoginPage.Sign_In);
    }

    @When("click on profile button")
    public void ClickOnProfileButton(){
        clickElement(UserProfilePage.Profile_Btn);

    }

    @Then("validate profile page information is correct")
    public void ValidateProfilePage() {

        boolean isDisplayed = isElementDisplayed(UserProfilePage.Profile_Page);
        assertTrue(isDisplayed);
        boolean isStatusDisplayed = isElementDisplayed(UserProfilePage.Status);
        assertTrue(isStatusDisplayed);
        boolean isUserDisplayed = isElementDisplayed(UserProfilePage.User_TYPE);
        assertTrue(isUserDisplayed);
        boolean isUserNameDisplayed = isElementDisplayed(UserProfilePage.User_NAME);
        assertTrue(isUserNameDisplayed);
        boolean isNameDisplayed = isElementDisplayed(UserProfilePage.FULL_NAME);
        assertTrue(isNameDisplayed);
        boolean isAuthorityDisplayed = isElementDisplayed(UserProfilePage.Authorities);
        assertTrue(isAuthorityDisplayed);

    }

    @And("validate log out button that navigates you to home page")
    public void ValidatingLogOutButton(){
        clickElement(UserProfilePage.Log_Out);

        boolean isDisplayed = isElementDisplayed(HomePage.Create_Account_Button);
        assertTrue(isDisplayed);

    }
}

package osprey_final_project.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import osprey_final_project.pages.AccountPage;
import osprey_final_project.pages.LoginPage;
import osprey_final_project.pages.PlanPage;
import osprey_final_project.utilities.DataGeneratorUtility;
import osprey_final_project.utilities.SeleniumUtility;

import java.util.List;
import java.util.Map;

public class PlanAndAccountPageSteps extends SeleniumUtility {

    @Given("navigate to plan page with correct credentials")
    public void navigateToPlanPage(DataTable dataTable) {
        clickElement(LoginPage.Login_btn);

        Map<String, String> data = dataTable.asMap();

        String userName = data.get("Username");
        String password = data.get("Password");

        sendTextToElement(LoginPage.User_name, userName);
        sendTextToElement(LoginPage.Password, password);

        clickElement(LoginPage.Sign_In);
        clickElement(PlanPage.Plan_Btn);
    }


    @And("validate {int} row of data is present")
    public void validateFourRowIsPresent(int expectedRow) {
        int actualRow = printRows(PlanPage.Plan_Table);
        Assert.assertEquals(expectedRow,actualRow);


    }


    @Then("validate create date is today date in Est time zone")
    public void validateTodayDate() {
        String createDate = getElementText(PlanPage.Plan_Date_Created);

        DataGeneratorUtility today = new DataGeneratorUtility();
        String currentDate = today.getCurrentDateInEST();

        Assert.assertEquals(currentDate,createDate);
        System.out.println("Created date is: " + createDate);

    }

    @And("Date Expire is a day after today in Est time zone")
    public void validateDateExpire() {

        String expireDate = getElementText(PlanPage.Plan_Expire_Date);
        DataGeneratorUtility tomorrowDate = new DataGeneratorUtility();
        String tomorrow = tomorrowDate.getTomorrowDateInEST();

        Assert.assertEquals(tomorrow,expireDate);
        System.out.println("Expire date is: " + expireDate);

    }


    @Given("verify that {int} row page is default")
    public void verifyPageRow(int expectedRow) throws InterruptedException {
        Thread.sleep(1000);
        clickElement(AccountPage.Account_Btn);
        int actualRow = printRows(AccountPage.Show_Page_Row);
        Assert.assertEquals(expectedRow,actualRow);
    }

    @When("rows are {string} number of records should be same as show")
    public void selectPageRow(String selectRow) throws InterruptedException {
        Thread.sleep(2000);
        clickElement(AccountPage.Account_Btn);
        clickElement(AccountPage.Drop_Down);


        selectFromDropDown(AccountPage.Select_Tag,selectRow);
        //printRows(AccountPage.Show_Page_Row);

        selectFromDropDown(AccountPage.Select_Tag,selectRow);
        //printRows(AccountPage.Show_Page_Row);

        selectFromDropDown(AccountPage.Select_Tag,selectRow);
        printRows(AccountPage.Show_Page_Row);
    }

}

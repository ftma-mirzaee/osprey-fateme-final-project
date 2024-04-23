package osprey_final_project.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import osprey_final_project.base.BaseSetUp;

public class HookSteps extends BaseSetUp {
    @Before
    public void initiateTest() {
        openBrowser();
    }

    //Hook Will Execute After Each Scenario
    //no matter what happened to Scenarios

    @After
    public void closingTest(Scenario scenario) {

        if (scenario.isFailed()) {
            //cast driver to take screenshot
            TakesScreenshot screenshot = (TakesScreenshot) getDriver();
            //take screenshot and store it as a file
            byte[] capture = screenshot.getScreenshotAs(OutputType.BYTES);
           //to attach additional data to the report
            scenario.attach(capture, "image/png", "screenshot");
        }

        getDriver().quit();
    }
}

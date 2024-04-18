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
            TakesScreenshot screenshot = (TakesScreenshot) getDriver();
            byte[] capture = screenshot.getScreenshotAs(OutputType.BYTES);

            scenario.attach(capture, "image/png", "screenshot");
        }

        getDriver().quit();
    }
}

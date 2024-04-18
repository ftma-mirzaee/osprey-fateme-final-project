package osprey_final_project.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


    @RunWith(Cucumber.class)

    @CucumberOptions(
            features = "classpath:Features",
            glue = "osprey_final_project.steps",
            dryRun = false,
            tags = "@Regression",
            plugin = {
                    "pretty",
                    "html:target/html_report/index.html",
                    "json:target/jsonReports/report.json"
            }


    )

    public class TestRunner {

    }



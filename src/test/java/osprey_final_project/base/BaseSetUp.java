package osprey_final_project.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseSetUp {
    private static WebDriver driver;
    private final Properties properties = new Properties();

    public BaseSetUp() {

        // To read a Properties file.

        try {
            String fileFilePath = System.getProperty("user.dir")
                    + "/src/test/resources/config/application-config.properties";
            File propertiesFile = new File(fileFilePath);
            FileInputStream propertyFileInputStream = new FileInputStream(propertiesFile);
            properties.load(propertyFileInputStream);

        } catch (IOException ex) {
            throw new RuntimeException("Can not read or load config file "
                    + ex.getMessage());
        }

    }
    public void openBrowser() {

        //Read browser type from Properties file

        String browserType = this.properties.getProperty("insurance.browser.type");
        boolean isHeadless = Boolean.parseBoolean(
                this.properties.getProperty("insurance.browser.headless"));

        if (browserType.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            if (isHeadless)
                options.addArguments("--headless");
            driver = new ChromeDriver(options);
        } else if (browserType.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            if (isHeadless)
                options.addArguments("--headless");
            driver = new EdgeDriver(options);
        } else if (browserType.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            if (isHeadless)
                options.addArguments("--headless");
            driver = new FirefoxDriver(options);
        }
        else {
            throw new RuntimeException("Wrong browser Type");
        }


        driver.manage().window().maximize();


        //Get Url from Property File

        String url = this.properties.getProperty("insurance.ui.url");
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
    }

    public WebDriver getDriver() {
        return driver;
    }
}


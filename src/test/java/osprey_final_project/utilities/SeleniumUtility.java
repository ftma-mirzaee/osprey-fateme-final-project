package osprey_final_project.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import osprey_final_project.base.BaseSetUp;

import java.time.Duration;
import java.util.List;

public class SeleniumUtility extends BaseSetUp {
    private WebDriverWait getWait() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        return wait;
    }


    public void clickElement(By locator){
        getWait().until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public String getElementText(By locator) {
        String text = getWait().until(ExpectedConditions.visibilityOfElementLocated(locator))
                .getText();
        return text;
    }

    public boolean isElementEnabled(By locator) {
        boolean isEnabled = getWait().until(ExpectedConditions.presenceOfElementLocated(locator))
                .isEnabled();
        return isEnabled;
    }

    public void sendTextToElement(By locator, String text) {
        getWait().until(
                        ExpectedConditions.visibilityOfElementLocated(locator))
                .sendKeys(text);
    }

    public boolean isElementDisplayed(By locator) {
        return getWait().until(ExpectedConditions
                        .visibilityOfElementLocated(locator))
                .isDisplayed();
    }
    public boolean sendKeys(By locator){
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();

    }

    public int printRows(By locator){
        List<WebElement> availableRows = getDriver().findElements(locator);
        System.out.println(" Number of Rows Available are: " + availableRows.size());

        return availableRows.size();
    }
}

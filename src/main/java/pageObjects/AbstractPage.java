package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AbstractPage {

    private final WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);

    AbstractPage() {
    }

    void proceedToPage(final String url) {
        DriverFactory.getDriver().get(url);
    }


    void moveToElement(By locator){
        Actions actions = new Actions(DriverFactory.getDriver());
        WebElement webElement = getElement(locator);
        actions.moveToElement(webElement);
    }

    WebElement getElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    List<WebElement> getElements(By locator) {
        return DriverFactory.getDriver().findElements(locator);
    }


    public boolean isDisplayed(By locator) {
        try {
            return getElement(locator)
                    .isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

}

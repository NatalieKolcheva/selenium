package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

import static consts.PageConstants.HOME_PAGE_URL;


public class HomePage extends AbstractPage {

    private static final Logger LOG = Logger.getLogger(HomePage.class);

    private final By signInButton = By.className("header-auth__signin");

    private final By topRightCornerUserNameElement = By.className("user-info__name");

    private final By aboutPageButton = By.className("//ul[@class='main-nav__list']//a[contains(@class,'about')]");

    private final By FAQPageButton = By.xpath("//ul[@class='main-nav__list']//a[contains(@class,'faq')]");


    public void clickSignInButton() {
        getElement(signInButton).click();
        LOG.info("'Sign in' button clicked");
    }

    public HomePage proceedToHomePage() {
        proceedToPage(HOME_PAGE_URL.getValue());
        LOG.info(String.format("Proceeded to '%s' URL.", HOME_PAGE_URL.getValue()));
        return this;
    }

    public boolean isUserNameDisplayed() {
        boolean isDisplayed = isDisplayed(topRightCornerUserNameElement);
        LOG.info(String.format("User is logged in: '%s'", isDisplayed));
        return isDisplayed;
    }

    public String getLoggedInUserName() {
        return getElement(topRightCornerUserNameElement).getText();
    }

    public void verifyUserIsLoggedIn() {
        Assert.assertTrue(isUserNameDisplayed(), "User is not logged in");
    }


}

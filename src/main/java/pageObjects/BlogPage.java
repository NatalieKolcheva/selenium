package pageObjects;

import consts.BlogPageLinks;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class BlogPage extends AbstractPage {

    private static final Logger LOG = Logger.getLogger(BlogPage.class);
    private final By blogButton = By.xpath("//ul[@class='main-nav__list']/li/a[@class='topNavItem news click hover']");

    public BlogPage clickBlogButton() {
        getElement(blogButton).click();
        LOG.info("Click on Blog button.");
        return this;
    }

    public void verifyLinkIsVisible() {
        SoftAssert softAssert = new SoftAssert();
        for (BlogPageLinks blogLink : BlogPageLinks.values()) {
            By locator = By.xpath(blogLink.getXPath());
            String blogName = blogLink.name();
            LOG.info("Check " + blogName + " link.");
            softAssert.assertTrue(getElement(locator).isDisplayed(), "Test Failed. " + blogName + " link not visible");
        }
        softAssert.assertAll();
    }
}




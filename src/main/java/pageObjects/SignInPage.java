package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SignInPage extends AbstractPage {

    private static final Logger LOG = Logger.getLogger(SignInPage.class);

    private final By mailInput = By.id("username");

    private final By passwordInput = By.id("password");

    private final By signInButton = By.id("kc-login");

    private final By continueButton = By.id("kc-login-next");

    private final By loginFailedErrorMessage = By.xpath("//span[text()=\"We can't find user with such credentials.\"]");

    public SignInPage enterEmail(String email) {
        getElement(mailInput).sendKeys(email);
        LOG.info("Mail was entered.");
        return this;
    }

    public boolean isContinueButtonEnabled() {
        boolean isEnabled = getElement(continueButton).isEnabled();
        LOG.info("Continue button enabled.");
        return isEnabled;
    }

    public void verifyIfContinueButtonDisabled() {
        Assert.assertFalse(isContinueButtonEnabled(),
                "Test Failed. Continue Button should not be enabled");
    }

    public void verifyIfContinueButtonEnabled() {
        Assert.assertTrue(isContinueButtonEnabled(),
                "Test Failed. Continue Button not enabled");
    }

    public SignInPage clickContinueButton() {
        getElement(continueButton).click();
        LOG.info("Continue button clicked.");
        return this;
    }

    public SignInPage enterPassword(String password) {
        getElement(passwordInput).sendKeys(password);
        LOG.info("Password was entered.");
        return this;
    }

    public SignInPage clickSignInButton() {
        getElement(signInButton).click();
        LOG.info("Sign in button clicked.");
        return this;
    }

    public boolean isLoginFailedErrorMessageDisplayed() {
        boolean isDisplayed = isDisplayed(loginFailedErrorMessage);
        LOG.info(String.format("Is 'Login Failed' error message displayed': '%s'", isDisplayed));
        return isDisplayed;
    }

    public void verifyFailedLoginErrorMessageDisplayed() {
        Assert.assertTrue(isLoginFailedErrorMessageDisplayed(),
                "'Login failed' error message is not displayed");
    }
}

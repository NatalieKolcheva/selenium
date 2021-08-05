package businessObjects;

import consts.UserConstants;
import pageObjects.HomePage;
import pageObjects.SignInPage;

public class SignInBusinessObject {

    public void userSignInWithEmail() {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton();
        new SignInPage()
                .enterEmail(UserConstants.VALID_EMAIL.getValue())
                .clickContinueButton()
                .enterPassword(UserConstants.VALID_PASSWORD.getValue())
                .clickSignInButton();
    }
}

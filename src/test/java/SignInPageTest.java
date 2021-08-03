import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SignInPage;

public class SignInPageTest extends BaseTest {


    @Test(description = "Verify error message appears when user logging in with inappropriate credentials ")
    public void verifyErrorMessageAppearsForIncorrectUser() {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton();
        new SignInPage()
                .enterEmail("incorrectmail@gmail.com")
                .clickContinueButton()
                .enterPassword("incorrectPassword")
                .clickSignInButton()
                .verifyFailedLoginErrorMessageDisplayed();
    }

    @Test(description = "Verify then user can add the e-mail with the correct credentials-happy path")
    public void verifyContinueButtonEnabledWithCorrectCredentialsAll() {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton();
        new SignInPage()
                .enterEmail("kkwoyvdwxshuccvytsrsgperjinwgxzldpupukbwfkmjqhdghmwhzmhhvblurox@gmail.com")
                .verifyIfContinueButtonEnabled();
    }

    @Test(description = "Verify then user can add the e-mail with the correct credentials -64  characters in the Recipient Name")
    public void verifyContinueButtonEnabledWithCorrectCredentials() {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton();
        new SignInPage()
                .enterEmail("kkwoyvdwxshuccvytsrsgperjinwgxzldpupukbwfkmjqhdghmwhzmhhvbluroxh@gmail.com")
                .verifyIfContinueButtonEnabled();
    }

    @Test(description = "Verify then user can add the e-mail with the correct credentials -2 in the top-level domain")
    public void verifyContinueButtonEnabledWithCorrectCredentialsTopLevelDomTwoSymbols() {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton();
        new SignInPage()
                .enterEmail("kkwoyvdwxshuccvytsrsgperjinwgxzldpupukbwfkmjqhdghmwhzmhhvblurox@gmail.co")
                .verifyIfContinueButtonEnabled();
    }

    @Test(description = "Verify then user can add the e-mail with the correct credentials -10 in the top-level domain")
    public void verifyContinueButtonEnabledWithCorrectCredentialsTopLevelDomTenSymbols() {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton();
        new SignInPage()
                .enterEmail("kkwoyvdwxshuccvytsrsgperjinwgxzldpupukbwfkmjqhdghmwhzmhhvblurox@gmail.commmmmmmm")
                .verifyIfContinueButtonEnabled();
    }

    @Test(description = "Verify then user can't add the e-mail that do not contain the @ symbol")
    public void verifyContinueButtonNotEnabledWithoutSymbol() {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton();
        new SignInPage()
                .enterEmail("incorrectmailgmail.com")
                .verifyIsContinueButtonEnabled();
    }

    @Test(description = "Verify then user can't add the e-mail that has @ symbol on the beginning")
    public void verifyContinueButtonNotEnabledWithSymbolOnBeginning() {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton();
        new SignInPage()
                .enterEmail("@incorrectmailgmail.com")
                .verifyIsContinueButtonEnabled();
    }

    @Test(description = "Verify then user can't add the e-mail that do not contain the '.' symbol")
    public void verifyContinueButtonNotEnabledWithoutDot() {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton();
        new SignInPage()
                .enterEmail("natalykolcheva@gmailcom")
                .verifyIsContinueButtonEnabled();
    }

    @Test(description = "Verify then user can't add the e-mail that has 1 character in the top-level domain ")
    public void verifyContinueButtonNotEnabledWithOneCharTopLevelDomain() {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton();
        new SignInPage()
                .enterEmail("natalykolcheva@gmail.c")
                .verifyIsContinueButtonEnabled();
    }

    @Test(description = "Verify then user can't add the e-mail that has 65 characters in the Recipient Name ")
    public void verifyContinueButtonNotEnabledWithHugeRecipientName() {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton();
        new SignInPage()
                .enterEmail("bgciyrlhcelyenbrmvqcjpczbqqtbobmkszfkalthesgypoypozhiyprkwyypxved@gmail.com")
                .verifyIsContinueButtonEnabled();
    }


}

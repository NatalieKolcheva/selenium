import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SignInPage;

public class SignInPageTest extends BaseTest {

    @DataProvider(name = "validEmails")
    public Object[] validEmails() {
        return new Object[]{
                "kkwoyvdwxshuccvytsrsgperjinwgxzldpupukbwfkmjqhdghmwhzmhhvblurox@gmail.com",
                "kkwoyvdwxshuccvytsrsgperjinwgxzldpupukbwfkmjqhdghmwhzmhhvbluroxh@gmail.com",
                "kkwoyvdwxshuccvytsrsgperjinwgxzldpupukbwfkmjqhdghmwhzmhhvblurox@gmail.co",
                "kkwoyvdwxshuccvytsrsgperjinwgxzldpupukbwfkmjqhdghmwhzmhhvblurox@gmail.commmmmmmm"
        };
    }

    @DataProvider(name = "invalidEmails")
    public Object[] invalidEmails() {
        return new Object[]{
                "incorrectmailgmail.com",
                "@incorrectmailgmail.com",
                "natalykolcheva@gmailcom",
                "natalykolcheva@gmail.c",
                "bgciyrlhcelyenbrmvqcjpczbqqtbobmkszfkalthesgypoypozhiyprkwyypxved@gmail.com"
        };
    }

    //Positive tests
    @Test(dataProvider = "validEmails", description = "Verify if continue button enabled for valid emails")
    public void verifyContinueButtonEnabledWithValidEmail(String validEmail) {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton();
        new SignInPage()
                .enterEmail(validEmail)
                .verifyIfContinueButtonEnabled();
    }

//
//    @Test(description = "Verify then user can add the e-mail with the correct credentials -64  characters in the Recipient Name")
//    public void verifyContinueButtonEnabledWithCorrectCredentials() {
//        new HomePage()
//                .proceedToHomePage()
//                .clickSignInButton();
//        new SignInPage()
//                .enterEmail("kkwoyvdwxshuccvytsrsgperjinwgxzldpupukbwfkmjqhdghmwhzmhhvbluroxh@gmail.com")
//                .verifyIfContinueButtonEnabled();
//    }
//
//    @Test(description = "Verify then user can add the e-mail with the correct credentials -2 in the top-level domain")
//    public void verifyContinueButtonEnabledWithCorrectCredentialsTopLevelDomTwoSymbols() {
//        new HomePage()
//                .proceedToHomePage()
//                .clickSignInButton();
//        new SignInPage()
//                .enterEmail("kkwoyvdwxshuccvytsrsgperjinwgxzldpupukbwfkmjqhdghmwhzmhhvblurox@gmail.co")
//                .verifyIfContinueButtonEnabled();
//    }
//
//    @Test(description = "Verify then user can add the e-mail with the correct credentials -10 in the top-level domain")
//    public void verifyContinueButtonEnabledWithCorrectCredentialsTopLevelDomTenSymbols() {
//        new HomePage()
//                .proceedToHomePage()
//                .clickSignInButton();
//        new SignInPage()
//                .enterEmail("kkwoyvdwxshuccvytsrsgperjinwgxzldpupukbwfkmjqhdghmwhzmhhvblurox@gmail.commmmmmmm")
//                .verifyIfContinueButtonEnabled();
//    }

    //Negative tests
    @Test(dataProvider = "invalidEmails",description = "Verify if continue button disabled for invalid emails")
    public void verifyContinueButtonDisabledWithInvalidEmail(String invalidEmail) {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton();
        new SignInPage()
                .enterEmail(invalidEmail)
                .verifyIfContinueButtonDisabled();
    }

//    @Test(description = "Verify then user can't add the e-mail that has @ symbol on the beginning")
//    public void verifyContinueButtonNotEnabledWithSymbolOnBeginning() {
//        new HomePage()
//                .proceedToHomePage()
//                .clickSignInButton();
//        new SignInPage()
//                .enterEmail("@incorrectmailgmail.com")
//                .verifyIsContinueButtonEnabled();
//    }
//
//    @Test(description = "Verify then user can't add the e-mail that do not contain the '.' symbol")
//    public void verifyContinueButtonNotEnabledWithoutDot() {
//        new HomePage()
//                .proceedToHomePage()
//                .clickSignInButton();
//        new SignInPage()
//                .enterEmail("natalykolcheva@gmailcom")
//                .verifyIsContinueButtonEnabled();
//    }
//
//    @Test(description = "Verify then user can't add the e-mail that has 1 character in the top-level domain ")
//    public void verifyContinueButtonNotEnabledWithOneCharTopLevelDomain() {
//        new HomePage()
//                .proceedToHomePage()
//                .clickSignInButton();
//        new SignInPage()
//                .enterEmail("natalykolcheva@gmail.c")
//                .verifyIsContinueButtonEnabled();
//    }
//
//    @Test(description = "Verify then user can't add the e-mail that has 65 characters in the Recipient Name ")
//    public void verifyContinueButtonNotEnabledWithHugeRecipientName() {
//        new HomePage()
//                .proceedToHomePage()
//                .clickSignInButton();
//        new SignInPage()
//                .enterEmail("bgciyrlhcelyenbrmvqcjpczbqqtbobmkszfkalthesgypoypozhiyprkwyypxved@gmail.com")
//                .verifyIsContinueButtonEnabled();
//    }


}

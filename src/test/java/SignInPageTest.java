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
}

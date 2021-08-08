import businessObjects.SignInBusinessObject;
import org.testng.annotations.Test;
import pageObjects.BlogPage;

public class BlogPageTest extends BaseTest {

    @Test
    public void verifyIfLinkIsVisible() {
        new SignInBusinessObject().userSignInWithEmail();
        new BlogPage().clickBlogButton().verifyLinkIsVisible();
    }
}

import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SignInPage;
import pageObjects.TrainingListPage;

public class TrainingListPageTest extends BaseTest {

    private final String JAVA_COURSE = "Java";
    private final String RUBY_COURSE = "Ruby";

    @Test(description = "Verify user proceed to training page.")
    public void verifyUserProceedToTrainingPageAndSearchCourse() {
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton();
        new SignInPage()
                .enterEmail("natalykolcheva@gmail.com")
                .clickContinueButton()
                .enterPassword("Forepam1")
                .clickSignInButton();
        new TrainingListPage()
                .scrollToSearchField()
                .clickSearchField()
                .clickBySkillsButton()
                .clickCheckboxSearchByCourse(JAVA_COURSE)
                .checkNotEmptyCoursesList(JAVA_COURSE)
                .clickCheckboxSearchByCourse(JAVA_COURSE)
                .clickCheckboxSearchByCourse(RUBY_COURSE)
                .checkEmptyCoursesList(RUBY_COURSE);
    }

}

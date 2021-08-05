import businessObjects.SignInBusinessObject;
import businessObjects.TrainingBusinessObject;
import org.testng.annotations.Test;

public class TrainingListPageTest extends BaseTest {

    private final String JAVA_COURSE = "Java";
    private final String RUBY_COURSE = "Ruby";

    //Positive
    @Test(description = "Verify user proceed to training page and search for available course.")
    public void verifyUserProceedToTrainingPageAndSearchAvailableCourse() {

        new SignInBusinessObject().userSignInWithEmail();

        new TrainingBusinessObject()
                .userSelectSearchCourseBySkills()
                .verifySearchResultsAreNotEmptyForCourse(JAVA_COURSE);
    }

    //Negative
    @Test(description = "Verify user proceed to training page and search for not available course.")
    public void verifyUserProceedToTrainingPageAndSearchNotAvailableCourse() {

        new SignInBusinessObject().userSignInWithEmail();

        new TrainingBusinessObject()
                .userSelectSearchCourseBySkills()
                .verifySearchResultsAreEmptyForCourse(RUBY_COURSE);
    }

//    @Test(description = "Verify user proceed to training page.")
//    public void verifyUserProceedToTrainingPage() {
//        new HomePage()
//                .proceedToHomePage()
//                .clickSignInButton();
//        new SignInPage()
//                .enterEmail("natalykolcheva@gmail.com")
//                .clickContinueButton()
//                .enterPassword("Forepam1")
//                .clickSignInButton();
//        new TrainingListPage()
//                .scrollToSearchField()
//                .clickSearchField()
//                .clickBySkillsButton()
//                .clickCheckboxSearchByCourse(JAVA_COURSE)
//                .checkNotEmptyCoursesList(JAVA_COURSE)
//                .clickCheckboxSearchByCourse(JAVA_COURSE)
//                .clickCheckboxSearchByCourse(RUBY_COURSE)
//                .checkEmptyCoursesList(RUBY_COURSE);
//    }


}

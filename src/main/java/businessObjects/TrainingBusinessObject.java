package businessObjects;

import org.testng.Assert;
import pageObjects.TrainingListPage;

public class TrainingBusinessObject {

    public TrainingBusinessObject userSelectSearchCourseBySkills() {
        new TrainingListPage()
                .scrollToSearchField()
                .clickSearchField()
                .clickBySkillsButton();
        return this;
    }

    public void verifySearchResultsAreNotEmptyForCourse(String course) {
        new TrainingListPage().clickCheckboxSearchByCourse(course);
        Integer coursesAmount = new TrainingListPage().getCoursesAmount(course);
        Assert.assertTrue(coursesAmount > 0, String.format("%s course not found.", course));
    }

    public void verifySearchResultsAreEmptyForCourse(String course) {
        new TrainingListPage().clickCheckboxSearchByCourse(course);
        Integer coursesAmount = new TrainingListPage().getCoursesAmount(course);
        Assert.assertTrue(coursesAmount == 0, String.format("%s course shouldn't be found.", course));
    }

}

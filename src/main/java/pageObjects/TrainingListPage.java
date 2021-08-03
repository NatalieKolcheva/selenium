package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class TrainingListPage extends AbstractPage {

    private static final Logger LOG = Logger.getLogger(TrainingListPage.class);
    private final By searchField = By.xpath("//input[@class='input-field-search ng-pristine ng-untouched ng-valid']");
    private final By bySkillsButton = By.xpath("//div[@class='navigation-item ng-binding'][normalize-space()='By skills']");

    public TrainingListPage scrollToSearchField() {
        moveToElement(searchField);
        LOG.info("Scroll to search field.");
        return this;
    }

    public TrainingListPage clickSearchField() {
        getElement(searchField).click();
        LOG.info("Click on search field.");
        return this;
    }

    public TrainingListPage clickBySkillsButton() {
        getElement(bySkillsButton).click();
        LOG.info("Click on search field.");
        return this;
    }

    public TrainingListPage clickCheckboxSearchByCourse(String course) {
        String xpath = String.format("//div[contains(@class, 'location__skills')]//label[normalize-space()='%s']/span", course);
        getElement(By.xpath(xpath)).click();
        LOG.info(String.format("Click on %s checkbox.", course));
        return this;
    }

    public TrainingListPage checkNotEmptyCoursesList(String course) {
        String xpath = String.format("//div[@class='training-list__container training-list__desktop']//div[contains(text(),'%s')]", course);
        List<WebElement> webElements = getElements(By.xpath(xpath));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(webElements.size() > 0, String.format("%s course not found.", course));
        return this;
    }

    public TrainingListPage checkEmptyCoursesList(String course) {
        String xpath = String.format("//div[@class='training-list__container training-list__desktop']//div[contains(text(),'%s')]", course);
        List<WebElement> webElements = getElements(By.xpath(xpath));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(webElements.size() == 0, String.format("%s course is found.", course));
        return this;
    }

}

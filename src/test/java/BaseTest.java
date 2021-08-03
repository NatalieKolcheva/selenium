import driver.DriverFactory;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;

public abstract class BaseTest extends DriverFactory {

    private final static String DEFAULT_BROWSER = "webdriver.chrome.driver";
    private final Logger LOG = Logger.getLogger(BaseTest.class);

    @Parameters({"browserName" })
    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(@Optional(value = DEFAULT_BROWSER) final String browserName, Method method) {
        initDriver(browserName);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(final Method method) {
        LOG.info(String.format("Test '%s' completed.", method.getName()));
        quitDriver();
    }
}

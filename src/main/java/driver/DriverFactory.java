package driver;

import consts.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public abstract class DriverFactory {

    private static WebDriver webDriver;

    public static WebDriver getDriver() {
        return webDriver;
    }

    protected void initDriver(final String browserName) {

        if (Constants.CHROME_NAME.getValue().equalsIgnoreCase(browserName)) {
//            System.setProperty(Constants.DriverConfigs.CHROME_NAME, Constants.DriverConfigs.CHROME_DRIVER_LOCATION);
            webDriver = new ChromeDriver();
        } else if (Constants.FIREFOX_NAME.getValue().equalsIgnoreCase(browserName)) {
            System.setProperty(Constants.FIREFOX_NAME.getValue(), Constants.FIREFOX_DRIVER_LOCATION.getValue());
            webDriver = new FirefoxDriver();
        } else if (Constants.EDGE_NAME.getValue().equalsIgnoreCase(browserName)) {
            System.setProperty(Constants.EDGE_NAME.getValue(), Constants.EDGE_DRIVER_LOCATION.getValue());
            webDriver = new EdgeDriver();
        }
        webDriver.manage().window().maximize();
        webDriver.manage()
                .timeouts()
                .implicitlyWait(Integer.parseInt(Constants.IMPLICITLY_WAIT_VALUE.getValue()), TimeUnit.SECONDS);
    }

    protected void quitDriver() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }
}

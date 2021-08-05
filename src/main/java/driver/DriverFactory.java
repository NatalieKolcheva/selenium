package driver;

import consts.DriverConstants;
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

    public static void initDriver(final String browserName) {

        if (DriverConstants.CHROME_NAME.getValue().equalsIgnoreCase(browserName)) {
//            System.setProperty(Constants.DriverConfigs.CHROME_NAME, Constants.DriverConfigs.CHROME_DRIVER_LOCATION);
            webDriver = new ChromeDriver();
        } else if (DriverConstants.FIREFOX_NAME.getValue().equalsIgnoreCase(browserName)) {
            System.setProperty(DriverConstants.FIREFOX_NAME.getValue(), DriverConstants.FIREFOX_DRIVER_LOCATION.getValue());
            webDriver = new FirefoxDriver();
        } else if (DriverConstants.EDGE_NAME.getValue().equalsIgnoreCase(browserName)) {
            System.setProperty(DriverConstants.EDGE_NAME.getValue(), DriverConstants.EDGE_DRIVER_LOCATION.getValue());
            webDriver = new EdgeDriver();
        }
        webDriver.manage().window().maximize();
        webDriver.manage()
                .timeouts()
                .implicitlyWait(Integer.parseInt(DriverConstants.IMPLICITLY_WAIT_VALUE.getValue()), TimeUnit.SECONDS);
    }

    public static void quitDriver() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }
}

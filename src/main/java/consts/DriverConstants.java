package consts;

public enum DriverConstants {

    CHROME_NAME("webdriver.chrome.driver"),
    FIREFOX_NAME("webdriver.gecko.driver"),
    EDGE_NAME("webdriver.edge.driver"),
    CHROME_DRIVER_LOCATION("src/main/resources/chromedriver.exe"),
    FIREFOX_DRIVER_LOCATION(""),
    EDGE_DRIVER_LOCATION("src/main/resources/MicrosoftWebDriver.exe"),
    IMPLICITLY_WAIT_VALUE("10");

    private final String value;

    DriverConstants(String s) {
        this.value = s;
    }

    public String getValue() {
        return value;
    }
}

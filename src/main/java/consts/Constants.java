package consts;

public enum Constants {

    CHROME_NAME("webdriver.chrome.driver"),
    FIREFOX_NAME("webdriver.gecko.driver"),
    EDGE_NAME("webdriver.edge.driver"),
    CHROME_DRIVER_LOCATION("src/main/resources/chromedriver.exe"),
    FIREFOX_DRIVER_LOCATION(""),
    EDGE_DRIVER_LOCATION("src/main/resources/MicrosoftWebDriver.exe"),
    IMPLICITLY_WAIT_VALUE("10"),
    BASE_URL("https://training.by"),
    HOME_PAGE_URL(BASE_URL.value + "/#/Home");

    private final String value;

    Constants(String s) {
        this.value = s;
    }

    public String getValue() {
        return value;
    }
}

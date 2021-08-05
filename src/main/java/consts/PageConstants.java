package consts;

public enum PageConstants {

    BASE_URL("https://training.by"),
    HOME_PAGE_URL(BASE_URL.value + "/#/Home");

    private final String value;

    PageConstants(String s) {
        this.value = s;
    }

    public String getValue() {
        return value;
    }
}

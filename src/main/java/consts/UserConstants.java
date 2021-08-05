package consts;

public enum UserConstants {

    VALID_EMAIL("natalykolcheva@gmail.com"),
    VALID_PASSWORD("Forepam1");

    private final String value;

    UserConstants(String s) {
        this.value = s;
    }

    public String getValue() {
        return value;
    }
}

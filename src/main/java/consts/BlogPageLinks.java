package consts;

public enum BlogPageLinks {

    NEWS("//a[contains(@class, 'tab-nav__item ng-scope')]/span[contains(text(),'NEWS')]"),
    REAL_STORIES("//a[contains(@class, 'tab-nav__item ng-scope')]/span[contains(text(),'REAL STORIES')]"),
    MATERIALS("//a[contains(@class, 'tab-nav__item ng-scope')]/span[contains(text(),'MATERIALS')]"),
    HARD_SKILLS("//a[contains(@class, 'tab-nav__item ng-scope')]/span[contains(text(),'HARD SKILLS')]"),
    SOFT_SKILLS("//a[contains(@class, 'tab-nav__item ng-scope')]/span[contains(text(),'SOFT SKILLS')]"),
    EVENTS("//a[contains(@class, 'tab-nav__item ng-scope')]/span[contains(text(),'EVENTS')]");

    private final String xPath;

    BlogPageLinks(String s) {
        this.xPath = s;
    }

    public String getXPath() {
        return xPath;
    }
}

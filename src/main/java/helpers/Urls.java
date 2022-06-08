package helpers;

public enum Urls {
    KELLER_MAIN_PAGE("https://keller:sports17@stage.keller-sports.com"),
    CHECKOUT_PAGE("https://keller:sports17@checkout-stage.keller-sports.com");
    private final String url;

    Urls(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

}

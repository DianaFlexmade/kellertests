package helpers;

public enum Urls {
    KELLER_MAIN_PAGE("https://keller:sports17@stage.keller-sports.com"),
    CHECKOUT_PAGE("https://keller:sports17@checkout-stage.keller-sports.com"),
    PRODUCT_PAGE("https://keller:sports17@stage.keller-sports.com/p/nike-fury-3.0-headband-REQNI00O000.html"),
    PREMIUM_PAGE("https://keller:sports17@stage.keller-sports.com/premium-membership");
    private final String url;

    Urls(String url) {
        this.url = url;
    }
    public String getUrl() {
        return url;
    }

}



package hexlet.code.Url;

import hexlet.code.model.Flash;

public class BuildUrl {

    private Url url;
    private UrlCheck urlCheck;
    private Flash flash;

    public BuildUrl(Url url, Flash flash) {
        this.url = url;
        this.flash = flash;
    }

    public BuildUrl(UrlCheck urlCheck, Flash flash) {
        this.urlCheck = urlCheck;
        this.flash = flash;
    }

    public BuildUrl(Flash flash) {
        this.flash = flash;
    }

}

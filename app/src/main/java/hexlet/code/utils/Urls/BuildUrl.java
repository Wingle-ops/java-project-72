package hexlet.code.utils.Urls;

import hexlet.code.utils.flash.flash;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BuildUrl extends flash {

    private Url url;

    public BuildUrl(Url url, String flash) {
        super(flash);
        this.url = url;
    }
}
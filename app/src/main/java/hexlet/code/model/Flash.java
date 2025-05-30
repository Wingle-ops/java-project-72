package hexlet.code.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Flash {

    private String flash;
    private boolean isOn;
    private boolean status;

    public Flash(String string, boolean isOn, boolean status) {
        this.flash = string;
        this.isOn = isOn;
        this.status = status;
    }

    public Flash(String string) {
        this.flash = string;
    }

    public boolean getStatus() {
        return this.status;
    }
}

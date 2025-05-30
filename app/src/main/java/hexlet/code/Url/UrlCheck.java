package hexlet.code.Url;

import java.time.LocalDateTime;

import hexlet.code.utils.Operations;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UrlCheck {

    private Long id;
    private String url;
    private int codeAnswer;
    private String title;
    private String h1;
    private String description;
    private LocalDateTime dateCheck;

    public UrlCheck(Long id, int codeAnswer, String title, String h1, String description, LocalDateTime dateCheck) {
        this.id = id;
        this.dateCheck = dateCheck;
        this.codeAnswer = codeAnswer;
        this.title = title;
        this.h1 = h1;
        this.description = description;
    }

    public UrlCheck(Long id, String url, LocalDateTime dataCheck, int codeAnswer) {
        this.id = id;
        this.url = url;
        this.dateCheck = dataCheck;
        this.codeAnswer = codeAnswer;
    }

    public String getDateCheck() {
        return Operations.getFormattedDateCheck(dateCheck);
    }
}

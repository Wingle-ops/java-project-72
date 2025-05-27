package hexlet.code.Url;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UrlCheck {

    private Long id;
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

    public UrlCheck(Long id, String name, LocalDateTime dataCheck, int codeAnswer) {
        this.id = id;
        this.dateCheck = dataCheck;
        this.codeAnswer = codeAnswer;
    }

}

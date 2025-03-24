package hexlet.code.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Url {

    private Long id;
    private String name;
    private String createdAt;

}

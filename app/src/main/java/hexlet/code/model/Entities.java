package hexlet.code.model;

import hexlet.code.Url.Url;

import java.util.List;
import java.util.Optional;

public class Entities {

    protected static List<Url> entities;

    public static void add(Url entity) {
        entities.add(entity);
    }

//    public static List<Url> getEntities() {
//        return entities;
//    }

    public static Optional<Url> find(String name) {
        return entities.stream()
                .filter(el -> (el.getName()).equals(name))
                .findAny();
    }

}

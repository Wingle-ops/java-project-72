package hexlet.code.model;

import hexlet.code.Url.Url;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Entities {

    protected static List<Url> entities = new ArrayList<>();

    public static void add(Url entity) {
        entities.add(entity);
    }

    public static Optional<Url> findByName(String name) {
        return entities.stream()
                .filter(el -> (el.getName()).equals(name))
                .findAny();
    }

    public static Optional<Url> findById(Long id) {
        return entities.stream()
                .filter(el -> (el.getId()).equals(id))
                .findAny();
    }
}

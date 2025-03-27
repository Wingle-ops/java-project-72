package hexlet.code.utils.repository;

import hexlet.code.utils.Urls.Url;

import java.util.List;
import java.util.Optional;

public class UrlRepos {

    private static List<Url> entities;

    public static void add(Url entity) {
        entities.add(entity);
    }

    public static List<Url> getEntities() {
        return entities;
    }

    public static Optional<Url> findByName(String name) {
        return entities.stream()
                .filter(el -> (el.getName()).equals(name))
                .findAny();
    }

}

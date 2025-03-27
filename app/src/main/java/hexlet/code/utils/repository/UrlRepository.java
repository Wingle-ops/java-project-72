package hexlet.code.utils.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import hexlet.code.utils.Baserepo;
import hexlet.code.utils.Urls.BuildUrl;
import hexlet.code.utils.Urls.Url;
import static hexlet.code.utils.operationToUrl.operations.validateUrl;
import static hexlet.code.utils.operationToUrl.operations.date;

public class UrlRepository extends Baserepo {

    public static Optional<BuildUrl> setUrl(String sourceUrl) throws SQLException {
        String url = validateUrl(sourceUrl);
        String sql = "INSERT INTO urls (name) VALUES (?)";
        try (Connection connection = datasource.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            Optional<Url> optionalUrl = UrlRepos.findByName(url);
            if (optionalUrl.isEmpty()) {
                stmt.setString(1, url);
                // Т.к. у нас SQL автоматически устанавливает дату и время, и нам не нужна точность до миллисекунд,
                // передавать туда данные не требуется. Для этого был создан метод date,
                // который я буду использовать и создавать объект с текущими значениями даты и времени.
                stmt.executeUpdate();
                Url urlNew = new Url(url, date());
                ResultSet getKey = stmt.getGeneratedKeys();
                if (getKey.next()) {
                    urlNew.setId(getKey.getLong(1));
                } else {
                    throw new SQLException("Не удалось установить id объекта");
                }
                UrlRepos.add(urlNew);
                BuildUrl buildUrl = new BuildUrl(urlNew, "Страница успешно добавлена");
                return Optional.of(buildUrl);
            }
            return Optional.of(new BuildUrl(optionalUrl.get(), "Страница уже существует"));
        }
    }

    public static Optional<Url> find(Long id) throws SQLException {
        String sql = "SELECT * FROM urls WHERE id = ?";
        try (Connection connection = datasource.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                Timestamp created_at = resultSet.getTimestamp("created_at");
                String created_atString = created_at.toString();
                Url url = new Url(name, created_atString);
                url.setId(id);
                return Optional.of(url);
            }
            return Optional.empty();
        }
    }

    public static List<Url> getUrls() throws SQLException {
        String sql = "SELECT * FROM urls";
        try (Connection connection = datasource.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet resultSet = stmt.executeQuery();
            List<Url> urls = new ArrayList<>();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                Timestamp created_at = resultSet.getTimestamp("created_at");
                String created_atString = created_at.toString();
                Url url = new Url(name, created_atString);
                url.setId(resultSet.getLong("id"));
                urls.add(url);
            }
            return urls;
        }
    }
}

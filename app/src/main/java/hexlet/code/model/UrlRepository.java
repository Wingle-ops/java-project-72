package hexlet.code.model;

import hexlet.code.Url.Url;
import hexlet.code.Url.UrlCheck;
import hexlet.code.utils.Operations;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.Optional;

import static hexlet.code.Baserepo.datasource;

public class UrlRepository {

    public static Optional<Flash> setUrl(String url) throws SQLException {
        String sql = "INSERT INTO urls (name) VALUES (?)";
        String sql1 = "SELECT * FROM urls WHERE name = ?";
        try (Connection connection = datasource.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
             PreparedStatement stmt1 = connection.prepareStatement(sql1, PreparedStatement.RETURN_GENERATED_KEYS)) {
            Optional<Url> optionalUrl = Entities.find(Operations.validateUrl(url));
            if (optionalUrl.isEmpty()) {
                stmt.setString(1, url);
                stmt1.setString(1, url);
                stmt.executeUpdate();
                stmt1.executeQuery();
                ResultSet resultSet = stmt1.getGeneratedKeys();
                if (resultSet.next()) {
                    Long id = resultSet.getLong("id");
                    String name = resultSet.getString("name");
                    LocalDateTime createdAt = Operations.dateTransform(resultSet.getTimestamp("createdAt"));
                    Url newUrl = new Url(id, name, createdAt);
                    Entities.add(newUrl);
                    return Optional.of(new Flash("Страница успешно добавлена"));
                }
            } else {
                return Optional.of(new Flash("Страница уже существует"));
            }
        }
        return Optional.empty();
    }

    public static Optional<UrlCheck> getUrls() throws SQLException {
        String sql = "SELECT * FROM url_check";
        try (Connection connection = datasource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.executeQuery();
            ResultSet resultSet = stmt.getGeneratedKeys();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("url");
                LocalDateTime dateCheck = Operations.dateTransform(resultSet.getTimestamp("dateCheck"));
                int codeAnswer = resultSet.getInt("codeAnswer");
                UrlCheck urls = new UrlCheck(id, name, dateCheck, codeAnswer);
                return Optional.of(urls);
            }
        }
        return Optional.empty();
    }

    public static Optional<UrlCheck> getInfo(Long urlId) throws SQLException {
        String sql = "SELECT * FROM url_check WHERE id = ?";
        String sql1 = "SELECT * FROM urls WHERE id = ?";
        try (Connection connection = datasource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            PreparedStatement stmt1 = connection.prepareStatement(sql1, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setLong(1, urlId);
            stmt1.setLong(1, urlId);
            stmt.executeQuery();
            stmt1.executeQuery();
            ResultSet resultSet = stmt.getGeneratedKeys();
            if (resultSet.next()) {
                Long id = resultSet.getLong("id");
                int codeAnswer = resultSet.getInt("codeAnswer");
                String title = resultSet.getString("title");
                String h1 = resultSet.getString("h1");
                String description = resultSet.getString("description");
                LocalDateTime dateCheck = resultSet.getDate("dateCheck");

                // Дальше тут должны выбираться данные из таблицы urls, создаваться нвоый объект, а затем возвращаться
                // 2 объекта. Далее должен происходить рендер на страничку с информацией и отображаться все данные
                // Если данных нет, то отобрадается пустота.

//                id SERIAL PRIMARY KEY,
//                url_id BIGINT NOT NULL,
//                codeAnswer INT,
//                title TEXT,
//                h1 TEXT,
//                description TEXT,
//                dateTest TIMESTAMP NOT NULL DEFAULT NOW(),
//                FOREIGN KEY (url_id) REFERENCES urls(id) ON DELETE CASCADE

//                private Long id;
//                private String name;
//                private int codeAnswer;
//                private String title;
//                private String h1;
//                private String description;
//                private LocalDateTime dateCheck;

            }
        }


        // При запуске проверки мы обновляем все данные и отображаем информацию по сайту. А при перехоже на информацию
        // без запуска проверки, просто получаем информацию. То есть надо написать 2 метода. Один обновляет инфу проверки
        // а второй получает все данные, или воспольхзоваться уже имеющимися
    }

    public static Optional<UrlCheck> getCheck(String url) throws SQLException {

    }


}

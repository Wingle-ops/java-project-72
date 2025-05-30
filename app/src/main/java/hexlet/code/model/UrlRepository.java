package hexlet.code.model;

import hexlet.code.App;
import hexlet.code.Url.BuildUrl;
import hexlet.code.Url.Url;
import hexlet.code.Url.UrlCheck;
import hexlet.code.utils.Operations;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static hexlet.code.Baserepo.datasource;

public class UrlRepository {

    public static void createTable() {
        try (Connection connection = datasource.getConnection();
             Statement stmt = connection.createStatement();
             BufferedReader reader = new BufferedReader
                     (new InputStreamReader(App.class.getResourceAsStream("/urls.sql")))) {
            StringBuilder sql = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sql.append(line).append("\n");
            }
            stmt.execute(sql.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Flash setUrl(String url) throws SQLException { // Метод на добавление Url в БД
        String sql1 = "INSERT INTO urls (name) VALUES (?)";
        try (Connection connection = datasource.getConnection();
             PreparedStatement stmt1 = connection.prepareStatement(sql1, PreparedStatement.RETURN_GENERATED_KEYS)) {
            Optional<Url> optionalUrl = Entities.findByName(Operations.validateUrl(url));
            if (optionalUrl.isEmpty()) {
                stmt1.setString(1, url);
                stmt1.executeUpdate();
                ResultSet resultSet = stmt1.getGeneratedKeys();
                if (resultSet.next()) {
                    Long id = resultSet.getLong(1);
                    Url newUrl = new Url(id, url, LocalDateTime.now());
                    Entities.add(newUrl);
                    return new Flash("Страница успешно добавлена");
                } else {
                    throw new IllegalStateException("Не удалось получить сгенерированный ключ при добавлении URL");
                }
            } else {
                return new Flash("Страница уже существует");
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при добавлении новой записи в БД " + e.getMessage());
            throw e;
        }
    }

    public static List<UrlCheck> getUrls() throws SQLException { // метод на получение всех Url
        List<UrlCheck> urlCheckCount = new ArrayList<>();
        String sql = "SELECT * FROM url_check";
        try (Connection connection = datasource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("url");
                LocalDateTime dateCheck = Operations.dateTransform(resultSet.getTimestamp("dateCheck"));
                int codeAnswer = resultSet.getInt("codeAnswer");
                UrlCheck urlCheck = new UrlCheck(id, name, dateCheck, codeAnswer);
                urlCheckCount.add(urlCheck);
            }
            return urlCheckCount;
        } catch (SQLException e) {
            System.err.println("Ошибка при получении списка URL " + e.getMessage());
            throw e;
        }
    }

    public static Optional<BuildUrl> getInfo(Long urlId) throws SQLException { // метод на получение данных с БД
        String sql = "SELECT * FROM url_check WHERE id = ?";
//        String sql1 = "SELECT * FROM urls WHERE id = ?";
        try (Connection connection = datasource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) {
//            PreparedStatement stmt1 = connection.prepareStatement(sql1, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setLong(1, urlId);
//            stmt1.setLong(1, urlId);
     //       stmt1.executeQuery();
            ResultSet resultSet = stmt.executeQuery();;
            if (resultSet.next()) {
                Long id = resultSet.getLong("id");
                int codeAnswer = resultSet.getInt("codeAnswer");
                String title = resultSet.getString("title");
                String h1 = resultSet.getString("h1");
                String description = resultSet.getString("description");
                LocalDateTime dateCheck = Operations.dateTransform(resultSet.getTimestamp("dateCheck"));
                UrlCheck urlCheck = new UrlCheck(id, codeAnswer, title, h1, description, dateCheck);
                Flash flash = new Flash("Страница успешно проверена");
                return Optional.of(new BuildUrl(urlCheck, flash));
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при получении информации о Url " + e.getMessage());
            throw e;
        }
            return Optional.empty(); // Возвращаем пустой объект, если получение данных не удалось
        }

    public static Optional<BuildUrl> check(Long id) throws SQLException { // Метод на запуск проверки
        String sql = "INSERT INTO url_check" +
                "(codeAnswer, title, h1, description) VALUES (?, ?, ?, ?)";
        try (Connection connection = datasource.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            String address = Entities.findById(id)
                    .orElseThrow(() -> new SQLException("Entity with id " + id + " not found"))
                    .getName();

            stmt.setInt(1, Operations.getAnswerCode(address));
            stmt.setString(2, Operations.getTitle(address));
            stmt.setString(3, Operations.getH1(address));
            stmt.setString(4, Operations.getDescription(address));
            stmt.executeUpdate();

            ResultSet resultSet = stmt.getGeneratedKeys();
            if (resultSet.next()) {
                return getInfo(id);
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при проведении проверки Url " + e.getMessage());
            throw e;
        }
        return Optional.empty();
    }
}

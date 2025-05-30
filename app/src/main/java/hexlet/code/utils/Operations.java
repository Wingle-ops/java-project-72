package hexlet.code.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Operations {

    public static String validateUrl(String url) { // метод на валидацию Url
        try {
            // Получает полный путь и извлекаем нужные нам данные
            URI address = new URI(url);
            String protocol = address.getScheme();
            String host = address.getHost();
            int port = address.getPort();
            if (protocol == null || protocol.isEmpty() || host == null || host.isEmpty() || (port <= 0)) {
                return "Некорректный URL";
            } else {
                return protocol + "://" + host + (port >= 1 ? ":" + port : ""); // Если порт не указан, не добавляем его
            }
        } catch (URISyntaxException e) {
            throw new RuntimeException("Ошибка при обработке URL");
        }
    }

    public static String getFormattedDateCheck(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return date != null ? date.format(formatter) : "";
    }

    public static LocalDateTime dateTransform(Timestamp timestamp) { // Метод для преобразования даты БД
        return timestamp.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    public static int getAnswerCode(String address) throws SQLException {
        try {
            URL url = new URL(address);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            return connection.getResponseCode();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getH1(String address) throws SQLException {
        try {
            Document doc = Jsoup.connect(address).get();
            Element h1 = doc.selectFirst("h1");
            return h1 != null ? String.valueOf(h1) : "Заголовок не найден";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String getTitle(String address) throws SQLException {
        try {
            Document doc = Jsoup.connect(address).get();
            return doc.title();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String getDescription(String address) throws SQLException {
        try {
            Document doc = Jsoup.connect(address).get();
            Element descriptionElement = doc.select("meta[name=description]").first();
            if (descriptionElement != null) {
                String description = descriptionElement.attr("content");
                System.out.println("Description: " + description);
            } else {
                System.out.println("Мета-тег description не найден.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

}

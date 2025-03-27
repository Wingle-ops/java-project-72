package hexlet.code.utils.operationToUrl;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class operations {

    public static String validateUrl(String url) { // метод на валидацию Url
        try {
            // Получает полный путь и извлекаем нужные нам данные
            URI address = new URI(url);
            String protocol = address.getScheme();
            String host = address.getHost();
            String port = String.valueOf(address.getPort());
            if (protocol.isEmpty() || host.isEmpty() || port.isEmpty()) {
                throw new RuntimeException("Некорректный URL");
            } else {
                return protocol + "://" + host + ":" + port;
            }
        } catch (URISyntaxException e) {
            throw new RuntimeException("Некорректный URL");
        }
    }

    public static String date() { // метод для получения даты и времени в формате строки без секунд
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return now.format(formatter);
    }

}

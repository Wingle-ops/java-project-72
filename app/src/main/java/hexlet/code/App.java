package hexlet.code;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import hexlet.code.NamedRouters.NamedRouters;
import hexlet.code.UrlController.UrlController;
import hexlet.code.model.UrlRepository;
import io.javalin.Javalin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.javalin.rendering.template.JavalinJte;

import hexlet.code.utils.PatternSettings;

public class App {

    // ПО - переменная окружения
    private static final Logger log = LoggerFactory.getLogger(App.class); // создаем объект для логирования

    public static Javalin getApp() {

        Javalin app = Javalin.create(config -> {
            // Указываем настройки конфига для приложения (Логирование)
            config.bundledPlugins.enableDevLogging();
            // Добавляем использование Jte шаблонизатора
            config.fileRenderer(new JavalinJte(PatternSettings.createTemplateEngine()));
        });

        // Создаем пул соединений. Далее мы указываем, что будем использовать тип БД
        // либо из ПО, либо локальный тип БД. Далее указываем путь соединения для пула БД.
        // После указываем, что создаем новый объект для управления пула соединений и отправляем его в Baserepo
        HikariConfig hConfig = new HikariConfig();
        String dataBase = System.getenv().getOrDefault("JDBC_DATABASE_URL", "jdbc:h2:mem:urls");
        hConfig.setJdbcUrl(dataBase + ";DB_CLOSE_DELAY=-1");
        Baserepo.datasource = new HikariDataSource(hConfig);
        UrlRepository.createTable();


        app.get(NamedRouters.index(), UrlController::main); // Переход на главную страничку сайта
        app.post(NamedRouters.urls(), UrlController::setUrl); // Добавление url в список сайтов
        app.get(NamedRouters.urls(), UrlController::urls); // Переход на список сайтов
        app.get(NamedRouters.urlInfo(), UrlController::getInfo); // Открытие странички с подробной информацией
        app.post(NamedRouters.urlCheck(), UrlController::check); // запуск проверки сайта

        return app;
    }

    public static int getPort() { // Метод для получения порта, либо из ПО, либо стандартный
        String port = System.getenv().getOrDefault("PORT", "7070");
        return Integer.parseInt(port);
    }

    public static void main(String[] args) { // создаем приложение и запускаем его
        Javalin app = getApp();
        app.start(getPort());
        log.info("servet start on port: {}", getPort()); // Получаем лог о порте подключения
    }

}

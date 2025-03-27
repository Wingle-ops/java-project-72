package hexlet.code;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import hexlet.code.utils.Urls.UrlController;
import hexlet.code.utils.operationToUrl.NamedRouters;
import hexlet.code.utils.repository.UrlRepository;
import io.javalin.Javalin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.javalin.rendering.template.JavalinJte;
import static io.javalin.rendering.template.TemplateUtil.model;

import hexlet.code.utils.Baserepo;
import hexlet.code.utils.patternSettings;

public class App {

    // ПО - переменная окружения
    private static final Logger log = LoggerFactory.getLogger(App.class); // создаем объект для логирования

    public static Javalin getApp() {

        Javalin app = Javalin.create(config -> {
            // Указываем настройки конфига для приложения (Логирование)
            config.bundledPlugins.enableDevLogging();
            // Добавляем использоване Jte шаблонизатора
            config.fileRenderer(new JavalinJte(patternSettings.createTemplateEngine()));
        });

        // Создаем пул соединений. Далее мы указываем, что будем использовать тип БД
        // либо из ПО, либо локальный тип БД. Далее указывем путь соединения для пула БД.
        // После указываем, что создаем новый объект для управления пула соединений и отправляем его в Baserepo
        HikariConfig hConfig = new HikariConfig();
        String dataBase = System.getenv().getOrDefault("JDBC_DATABASE_URL", "jdbc:h2:mem:project");
        hConfig.setJdbcUrl(dataBase + ";DB_CLOSE_DELAY=-1");
        HikariDataSource datasource = new HikariDataSource(hConfig);
        Baserepo.datasource = datasource;

        app.get(NamedRouters.index(), UrlController::index);
        app.get(NamedRouters.urls(), UrlController::urls);
        app.post(NamedRouters.urlsId(), UrlController::urlsId);

        return app;
    }

    public static int getPort() { // Метод для получения порта, либо из ПО, либо стандартный
        String port = System.getenv().getOrDefault("PORT", "7070");
        return Integer.valueOf(port);
    }

    public static void main(String[] args) { // создаем приложение и запускаем его
        Javalin app = getApp();
        app.start(getPort());
        log.info("servet start on port: " + getPort()); // Получаем лог о порте подключения
    }
}

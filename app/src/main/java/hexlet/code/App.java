package hexlet.code;

import io.javalin.Javalin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static Javalin getApp() {

        Javalin app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        app.get("/", ctx -> {
           ctx.result("Hello World");
           log.info("Start!");
        });

        return app;
    }

    public static void main(String[] args) {
        String portEnv = System.getenv("PORT");
        int port = (portEnv != null) ? Integer.parseInt(portEnv) : 7000;

        Javalin app = getApp();
        app.start(port);
        log.info("servet start on port: " + port);
    }
}

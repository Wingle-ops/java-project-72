package hexlet.code.UrlController;

import hexlet.code.model.Flash;
import hexlet.code.model.UrlRepository;
import hexlet.code.utils.Operations;
import io.javalin.http.Context;

import java.sql.SQLException;

import static io.javalin.rendering.template.TemplateUtil.model;

// Тут находятся обработчики маршрутов
public class UrlController {

    public static void main(Context ctx) {
        ctx.render("urls/main.jte");
    }

    public static void setUrl(Context ctx) throws SQLException {
        String url = ctx.formParam("url");
        if (Operations.validateUrl(url).equals("Некорректный URL")) {
            ctx.render("urls/main.jte", model("error", new Flash("Некорректный URL")));
        } else {
            ctx.render("urls/urls.jte",
                    model("flash", UrlRepository.setUrl(url).get(), "urls", UrlRepository.getUrls().get()));
        }
    }

    public static void urls(Context ctx) throws SQLException {
        ctx.render("urls/urls.jte", model("urls", UrlRepository.getUrls().get()));
    }

    public static void getInfo(Context ctx) throws SQLException {
        Long id = Long.parseLong(ctx.pathParam("id"));
        ctx.render("urls/urlInfo.jte", model("url", UrlRepository.getInfo(id).get()));
    }

}

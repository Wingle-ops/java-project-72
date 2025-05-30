package hexlet.code.UrlController;

import hexlet.code.model.Entities;
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
                ctx.render("urls/urls.jte", // Тут мы возвращаем список значений UrlCheck
                        model("flash", UrlRepository.setUrl(url), "urls", UrlRepository.getUrls()));
        }
    }

    public static void urls(Context ctx) throws SQLException { // Тут мы возвращаем список значений UrlCheck
        ctx.render("urls/urls.jte",
                model("flash", new Flash("", false, false), "urls", UrlRepository.getUrls()));
    }

    public static void getInfo(Context ctx) throws SQLException {
        Long id = Long.parseLong(ctx.pathParam("id"));
        ctx.render("urls/urlInfo.jte",
                model("url", Entities.findById(id).get(), "info", UrlRepository.getInfo(id).get()));
    }

    public static void check(Context ctx) throws SQLException {
        Long id = Long.parseLong(ctx.pathParam("id"));
        ctx.render("urls/urlInfo.jte",
                model("url", Entities.findById(id).get(), "check", UrlRepository.check(id)));
    }

}

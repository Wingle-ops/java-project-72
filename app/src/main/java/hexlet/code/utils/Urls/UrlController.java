package hexlet.code.utils.Urls;

import hexlet.code.utils.operationToUrl.NamedRouters;
import io.javalin.http.Context;
import hexlet.code.utils.repository.UrlRepository;

import java.sql.SQLException;
import java.util.Optional;

import static io.javalin.rendering.template.TemplateUtil.model;

public class UrlController {

    public static void index(Context ctx) {
          ctx.render("models/index.jte");
    }

    public static void urls(Context ctx) throws SQLException {
        ctx.render("models/urls.jte", model("page", UrlRepository.getUrls()));
    }

    public static void urlsId(Context ctx) throws SQLException {
        Long id = ctx.pathParamAsClass("{id}", Long.class).get();
        Optional<Url> url = UrlRepository.find(id);
        url.ifPresent(value -> ctx.render(NamedRouters.urlsId(), model("id", value)));
    }

}






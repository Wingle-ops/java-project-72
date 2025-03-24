package hexlet.code.utils;

import hexlet.code.App;
import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.resolve.ResourceCodeResolver;

public class patternSettings {

    public static TemplateEngine createTemplateEngine() {
        // Создаем объект, который указывает, что в первую очередь при запуске программы будет загружать этот класс
        ClassLoader classLoader = App.class.getClassLoader();
        // Указываем путь до шаблонов и какой класс лоадер будет с ними работать
        ResourceCodeResolver codeResolver = new ResourceCodeResolver("templates", classLoader);
        // Создаем объект и что мы будет рендерить. В моем случае страницу HTML
        TemplateEngine templateEngine = TemplateEngine.create(codeResolver, ContentType.Html);
        return templateEngine;
    }
}

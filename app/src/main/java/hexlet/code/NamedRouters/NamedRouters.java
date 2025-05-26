package hexlet.code.NamedRouters;

public class NamedRouters {

    // Именованные маршруты
    public static String index() {
        return "/";
    }

    public static String urls() {
        return "/urls";
    }

    public static String urlInfo() {
        return urls() + "{id}";
    }

    public static String urlCheck() {
        return urlInfo() + "check";
    }

}

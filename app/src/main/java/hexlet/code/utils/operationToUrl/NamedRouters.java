package hexlet.code.utils.operationToUrl;

public class NamedRouters {

    public static String index() {
        return "/";
    }

    public static String urls() {
        return "models/urls";
    }

    public static String urlsId() {
        return urls() + "/{id}";
    }

}

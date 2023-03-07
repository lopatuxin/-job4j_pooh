package ru.job4j.pooh;

public class Req {
    private final String httpRequestType;
    private final String poohMode;
    private final String sourceName;
    private final String param;

    public Req(String httpRequestType, String poohMode, String sourceName, String param) {
        this.httpRequestType = httpRequestType;
        this.poohMode = poohMode;
        this.sourceName = sourceName;
        this.param = param;
    }

    private static String searchParam(String[] array) {
        String result = "";
        for (int i = 0; i < array.length; i++) {
            if (array[i].contains("=")) {
                result = array[i];
                break;
            }
        }
        return result;
    }

    public static Req of(String content) {
        /* TODO parse a content */
        String[] array = content.split(System.lineSeparator());
        String[] params = array[0].split("/");
        if (params.length == 5) {
            return new Req(params[0].trim(), params[1].trim(), params[2].trim(), params[3].split(" ")[0]);
        } else {
            return new Req(params[0].trim(), params[1].trim(), params[2].split(" ")[0], searchParam(array));
        }
    }

    public String httpRequestType() {
        return httpRequestType;
    }

    public String getPoohMode() {
        return poohMode;
    }

    public String getSourceName() {
        return sourceName;
    }

    public String getParam() {
        return param;
    }
}

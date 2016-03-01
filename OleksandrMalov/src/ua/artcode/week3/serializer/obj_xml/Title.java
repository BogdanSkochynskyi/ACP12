package ua.artcode.week3.serializer.obj_xml;

/**
 * Created by Олександр on 29.02.2016.
 */
public class Title {

    private String lang;
    private String title;

    public Title(String title) {
        this.title = title;
    }

    public Title(String lang, String title) {
        this.lang = lang;
        this.title = title;
    }

    @Override
    public String toString() {
        if (lang == null)
            return "" + title;
        else
            return " lang=\"" + lang + "\">" + title;

    }
}

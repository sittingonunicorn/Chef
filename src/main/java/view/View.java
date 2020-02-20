package view;

import java.util.Locale;
import java.util.ResourceBundle;

public class View implements  TextConstant{
    static final String MESSAGES_BUNDLE_NAME = "messages";
    private ResourceBundle bundle;

    public View() {

    }

    public ResourceBundle getBundle() {
        return bundle;
    }

    public void setBundle(String lang) {
        bundle = ResourceBundle.getBundle(MESSAGES_BUNDLE_NAME, setLocale(lang));
    }

    public Locale setLocale(String lang) {
        Locale locale = new Locale("en");
        if (lang.equals("2")) {
            locale = new Locale("ua");
        }
        return locale;
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public String concatenationString(String... message) {
        StringBuilder concatString = new StringBuilder();
        for (String v : message) {
            concatString = concatString.append(bundle.getString(v)+System.lineSeparator());
        }
        return new String(concatString);
    }

    public void printStringInput(String message) {
        printMessage( bundle.getString(message));
    }
}

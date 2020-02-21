package view;

import model.entity.Ingredient;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class View implements TextConstant {
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
            concatString.append(bundle.getString(v));
            concatString.append(System.lineSeparator());
        }
        return new String(concatString);
    }

    public void printStringInput(String message) {
        printMessage(bundle.getString(message));
    }

    public String menuToPrint(String[] message) {
        StringBuilder concatString = new StringBuilder();
        for (int i = 0; i < message.length; i++) {
            concatString.append(i + 1).append(". ").append(bundle.getString(message[i])).append(System.lineSeparator());
        }
        return new String(concatString);
    }

    public void printMenuLine(int number, String message) {
        System.out.print(number + ". ");
        printMessage(bundle.getString(message));
    }

    public void printInfoMenu() {
        printMenuLine(1, COOK);
        printMenuLine(2, SORT_BY_COST);
        printMenuLine(3, SORT_BY_CALORIES);
        printMenuLine(4, GET_VEGETABLES_DIAPASON);
        printMenuLine(5, COUNT_CALORIES);
        printMenuLine(0, BACK_TO_MAIN_MENU);
    }

    public void printIngredientsCalories(List<Ingredient> ingredients) {
        for (Ingredient ingredient : ingredients) {
            System.out.println(bundle.getString(ingredient.toString()) + ": " + ingredient.getCalories() + bundle.getString("message.calories.100g"));
        }


    }

    public void printIngredientsCost(List<Ingredient> ingredients) {
        for (Ingredient ingredient : ingredients) {
            System.out.println(bundle.getString(ingredient.toString()) + ": " + ingredient.getCost() + bundle.getString("message.hrn"));
        }
    }
    public void printIntAndStringInput(int number, String message){
        System.out.print(number + " ");
        printStringInput(message);
    }
    public void printEmptyString(){
        System.out.println();
    }

    public void printEndMenu(){
        printMenuLine(0, "message.end");
        printMenuLine(1, "message.back.to.main.menu");
        printMenuLine(2, "message.back.to.info.menu");
    }
}

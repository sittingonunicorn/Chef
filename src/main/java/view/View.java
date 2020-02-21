package view;

import model.entity.Ingredient;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class View implements TextConstant {
    /**
     * Resource Bundle name.
     */
    static final String MESSAGES_BUNDLE_NAME = "messages";
    /**
     * Resource Bundle instance.
     */
    private ResourceBundle bundle;

    public View() {
    }

    /**
     * Utility getter.
     * @return Resource Bundle instance.
     */
    public ResourceBundle getBundle() {
        return bundle;
    }
    /**
     * Setter. Sets Resource Bundle instance for chosen locale.
     */
    public void setBundle(String lang) {
        bundle = ResourceBundle.getBundle(MESSAGES_BUNDLE_NAME, setLocale(lang));
    }
    /**
     * Setter. Sets locale.
     */
    public Locale setLocale(String lang) {
        Locale locale = new Locale("en");
        if (lang.equals("2")) {
            locale = new Locale("ua");
        }
        return locale;
    }

    /**
     * Prints message.
     * @param message - any String message.
     */
    public void printMessage(String message) {
        System.out.println(message);
    }

    /**
     * Concatenates random number of messages.
     * @param message - random number of messages.
     * @return concatenated String
     */
    public String concatenationString(String... message) {
        StringBuilder concatString = new StringBuilder();
        for (String v : message) {
            concatString.append(bundle.getString(v));
            concatString.append(System.lineSeparator());
        }
        return new String(concatString);
    }
    /**
     * Prints message from Resource Bundle.
     * @param message - message from Resource Bundle.
     */
    public void printStringInput(String message) {
        printMessage(bundle.getString(message));
    }

    /**
     *
     * @param message
     * @return
     */
    public String menuToPrint(String[] message) {
        StringBuilder concatString = new StringBuilder();
        for (int i = 0; i < message.length; i++) {
            concatString.append(i + 1).append(". ").append(bundle.getString(message[i])).append(System.lineSeparator());
        }
        return new String(concatString);
    }

    /**
     * Prints menu
     * @param number - of menu lines.
     * @param message - info for menu line
     */
    public void printMenuLine(int number, String message) {
        System.out.print(number + ". ");
        printMessage(bundle.getString(message));
    }

    /**
     * Forms info menu.
     */
    public void printInfoMenu() {
        printMenuLine(1, COOK);
        printMenuLine(2, SORT_BY_COST);
        printMenuLine(3, SORT_BY_CALORIES);
        printMenuLine(4, GET_VEGETABLES_DIAPASON);
        printMenuLine(5, COUNT_CALORIES);
        printMenuLine(6, SEE_INGREDIENTS);
        printMenuLine(0, BACK_TO_MAIN_MENU);
    }

    /**
     * Prints ingredients with calorific value.
     * @param ingredients - ingredients of salad
     */
    public void printIngredientsCalories(List<Ingredient> ingredients) {
        for (Ingredient ingredient : ingredients) {
            System.out.println(bundle.getString(ingredient.toString()) + ": " + ingredient.getCalories() + bundle.getString("message.calories.100g"));
        }
    }

    /**
     * Prints ingredients with cost.
     * @param ingredients - ingredients of salad
     */
    public void printIngredientsCost(List<Ingredient> ingredients) {
        for (Ingredient ingredient : ingredients) {
            System.out.println(bundle.getString(ingredient.toString()) + ": " + ingredient.getCost() + bundle.getString("message.hrn"));
        }
    }

    /**
     * prints list of ingredients.
     * @param ingredients- ingredients of salad
     */
    public void printIngredients(List<Ingredient> ingredients) {
        for (Ingredient ingredient : ingredients) {
            System.out.println(bundle.getString(ingredient.toString()));
        }
    }

    /**
     * Prints int with String input.
     * @param number - int value
     * @param message - String input
     */
    public void printIntAndStringInput(int number, String message){
        System.out.print(number + " ");
        printStringInput(message);
    }


    public void printEmptyString(){
        System.out.println();
    }

    /**
     * Forms end menu.
     */
    public void printEndMenu(){
        printMenuLine(0, "message.end");
        printMenuLine(1, "message.back.to.main.menu");
        printMenuLine(2, "message.back.to.info.menu");
    }
}

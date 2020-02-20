package model;


import java.util.List;

public class Menu {
    static Salad spicy_salad;
    static Salad vinaigrette;
    static Salad spring;

    static {
        spicy_salad = new Salad("salad.spicy", new Vegetable(Ingredients.SWEET_RED_PEPPER, 30, false),
                new Vegetable(Ingredients.WHITE_CABBAGE, 50, false), new Vegetable(Ingredients.CARROT, 30, false),
                new Vegetable(Ingredients.GARLIC, 5, false), new Ingredient(Ingredients.SALT, 5),
                new Ingredient(Ingredients.PARSLEY, 5), new Ingredient(Ingredients.PEPPER, 5),
                new Ingredient(Ingredients.VINEGAR, 10));
        vinaigrette = new Salad("salad.vinaigrette", new Vegetable(Ingredients.POTATOES, 25, true),
                new Vegetable(Ingredients.BEET, 50, true), new Vegetable(Ingredients.CARROT, 25, true),
                new Vegetable(Ingredients.GREEN_PEAS, 30, false), new Vegetable(Ingredients.CUCUMBERS, 30, false),
                new Ingredient(Ingredients.PARSLEY, 10), new Ingredient(Ingredients.SALT, 5),
                new Ingredient(Ingredients.OIL, 20));
        spring = new Salad("salad.spring", new Vegetable(Ingredients.TOMATOES, 130, false),
                new Vegetable(Ingredients.WHITE_CABBAGE, 250, false), new Vegetable(Ingredients.CARROT, 85, false),
                new Vegetable(Ingredients.BULB_ONIONS, 20, false), new Vegetable(Ingredients.CUCUMBERS, 30, false),
                new Vegetable(Ingredients.GREEN_ONION, 20, false), new Vegetable(Ingredients.RADISH, 20, false),
                new Ingredient(Ingredients.PEPPER, 5), new Ingredient(Ingredients.MAYONNAISE, 15));

    }


    public static List<Ingredient> getSpicySalad() {
        return spicy_salad.getSalad();
    }

    public static List<Ingredient> getVinaigrette() {
        return vinaigrette.getSalad();
    }

    public static List<Ingredient> getSpring() {
        return spring.getSalad();
    }

    public static String[] menuToArray(){
        String [] menu = new String[]{spicy_salad.getName(), vinaigrette.getName(), spring.getName()};
        return menu;
    }
}

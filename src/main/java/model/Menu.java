package model;


import java.util.List;

public class Menu {
    private final static Salad SPICY_SALAD;
    private final static Salad VINAIGRETTE;
    private final static Salad SPRING;
    private final static Salad VITAMIN;
    private final static Salad RED_CABBAGE;

    static {
        SPICY_SALAD = new Salad("salad.spicy", new Vegetable(Ingredients.SWEET_RED_PEPPER, 30, false),
                new Vegetable(Ingredients.WHITE_CABBAGE, 50, false), new Vegetable(Ingredients.CARROT, 30, false),
                new Vegetable(Ingredients.GARLIC, 5, false), new Ingredient(Ingredients.SALT, 5),
                new Ingredient(Ingredients.PARSLEY, 5), new Ingredient(Ingredients.PEPPER, 5),
                new Ingredient(Ingredients.VINEGAR, 10));
        VINAIGRETTE = new Salad("salad.vinaigrette", new Vegetable(Ingredients.POTATOES, 25, true),
                new Vegetable(Ingredients.BEET, 50, true), new Vegetable(Ingredients.CARROT, 25, true),
                new Vegetable(Ingredients.GREEN_PEAS, 30, false), new Vegetable(Ingredients.CUCUMBERS, 30, false),
                new Ingredient(Ingredients.PARSLEY, 10), new Ingredient(Ingredients.SALT, 5),
                new Ingredient(Ingredients.OIL, 20));
        SPRING = new Salad("salad.spring", new Vegetable(Ingredients.TOMATOES, 130, false),
                new Vegetable(Ingredients.WHITE_CABBAGE, 50, false), new Vegetable(Ingredients.CARROT, 25, false),
                new Vegetable(Ingredients.BULB_ONIONS, 10, false), new Vegetable(Ingredients.CUCUMBERS, 15, false),
                new Vegetable(Ingredients.GREEN_ONION, 10, false), new Vegetable(Ingredients.RADISH, 10, false),
                new Ingredient(Ingredients.PEPPER, 5), new Ingredient(Ingredients.MAYONNAISE, 10));
        VITAMIN = new Salad("salad.vitamin", new Vegetable(Ingredients.SALAD, 30, false),
                new Vegetable(Ingredients.GREEN_BEANS, 20, false), new Vegetable(Ingredients.ZUCCHINI, 30, true),
                new Vegetable(Ingredients.TOMATOES, 20, false), new Ingredient(Ingredients.DILL, 10),
                new Ingredient(Ingredients.ROSEMARY, 5), new Ingredient(Ingredients.OIL, 10));
        RED_CABBAGE = new Salad("salad.red.cabbage", new Vegetable(Ingredients.RED_CABBAGE, 80, false),
                new Vegetable(Ingredients.BULB_ONIONS, 15, false), new Vegetable(Ingredients.GARLIC, 10, false),
                new Ingredient(Ingredients.ROSEMARY, 5), new Ingredient(Ingredients.MAYONNAISE, 10));
    }


    public static List<Ingredient> getSpicySalad() {
        return SPICY_SALAD.getSalad();
    }

    public static List<Ingredient> getSalad(int number) {
        List<Ingredient> result = SPICY_SALAD.getSalad();
        switch (number) {
            case 1:
                result = VINAIGRETTE.getSalad();
                break;
            case 2:
                result = SPRING.getSalad();
                break;
            case 3:
                result = VITAMIN.getSalad();
                break;
            case 4:
                result = RED_CABBAGE.getSalad();
        }
        return result;
    }


    public static String[] menuToArray() {
        return new String[]{SPICY_SALAD.getName(), VINAIGRETTE.getName(), SPRING.getName(), VITAMIN.getName(), RED_CABBAGE.getName()};
    }
}

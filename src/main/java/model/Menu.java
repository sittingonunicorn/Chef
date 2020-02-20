package model;


public class Menu {
    public Salad spicy_salad = new Salad("Spicy salad", new Vegetable(Ingredients.SWEET_RED_PEPPER, 30, false),
            new Vegetable(Ingredients.WHITE_CABBAGE, 50, false), new Vegetable(Ingredients.CARROT, 30, false),
            new Vegetable(Ingredients.GARLIC, 5, false), new Ingredient(Ingredients.SALT, 5),
            new Ingredient(Ingredients.PARSLEY, 5), new Ingredient(Ingredients.PEPPER, 5),
            new Ingredient(Ingredients.VINEGAR, 10));
    public Salad vinaigrette = new Salad("Vinaigrette", new Vegetable(Ingredients.POTATOES, 25, true),
            new Vegetable(Ingredients.BEET, 50, true), new Vegetable(Ingredients.CARROT, 25, true),
            new Vegetable(Ingredients.GREEN_PEAS, 30, false), new Vegetable(Ingredients.CUCUMBERS, 30, false),
            new Ingredient(Ingredients.PARSLEY, 10), new Ingredient(Ingredients.SALT, 5),
            new Ingredient(Ingredients.OIL, 20));
    public Salad spring = new Salad("Spring salad", new Vegetable(Ingredients.TOMATOES, 130, false),
            new Vegetable(Ingredients.WHITE_CABBAGE, 250, false), new Vegetable(Ingredients.CARROT, 85, false),
            new Vegetable(Ingredients.BULB_ONIONS, 20, false), new Vegetable(Ingredients.CUCUMBERS, 30, false),
            new Vegetable(Ingredients.GREEN_ONION, 20, false), new Vegetable(Ingredients.RADISH, 20, false),
            new Ingredient(Ingredients.PEPPER, 5), new Ingredient(Ingredients.MAYONNAISE, 15));
}

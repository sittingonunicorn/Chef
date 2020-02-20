package model;


public class ChiefCook {
    Salad spicy_salad = new Salad("Spicy salad", new Vegetable(Ingredients.SWEET_RED_PEPPER, 30),
            new Vegetable(Ingredients.WHITE_CABBAGE, 500), new Vegetable(Ingredients.CARROT, 30),
            new Vegetable(Ingredients.GARLIC, 5), new Ingredient(Ingredients.SALT, 5),
            new Ingredient(Ingredients.PARSLEY, 5), new Ingredient(Ingredients.PEPPER, 5),
            new Ingredient(Ingredients.VINEGAR, 10));
    Salad vinaigrette = new Salad("Vinaigrette", new Vegetable(Ingredients.POTATOES, 25),
            new Vegetable(Ingredients.BEET, 50), new Vegetable(Ingredients.CARROT, 25),
            new Vegetable(Ingredients.GREEN_PEAS, 30), new Vegetable(Ingredients.CUCUMBERS, 30),
            new Ingredient(Ingredients.PARSLEY, 10), new Ingredient(Ingredients.SALT, 5),
            new Ingredient(Ingredients.OIL, 20));
    Salad spring = new Salad("Spring salad", new Vegetable(Ingredients.TOMATOES, 130),
            new Vegetable(Ingredients.WHITE_CABBAGE, 250), new Vegetable(Ingredients.CARROT, 85),
            new Vegetable(Ingredients.BULB_ONIONS, 20), new Vegetable(Ingredients.CUCUMBERS, 30),
            new Vegetable(Ingredients.GREEN_ONION, 20), new Vegetable(Ingredients.RADISH, 20),
            new Ingredient(Ingredients.PEPPER, 5), new Ingredient(Ingredients.MAYONNAISE, 15));

    public boolean cookSalad(Salad salad) {
        boolean isReady = true;
        for (Ingredient component : salad.getSalad()) {
            if (component.getClass() == Vegetable.class) {
                ((Vegetable) component).cut();
                isReady=((Vegetable) component).isCut();
            }
        }
        return isReady;
    }
}
package model;


public enum Ingredients {
    GREEN_PEAS("vegetable.green.peas", 72, 5),
    ZUCCHINI("vegetable.zucchini", 27, 7),
    WHITE_CABBAGE("vegetable.white.cabbage", 28, 3),
    RED_CABBAGE("vegetable.red.cabbage", 31, 5),
    POTATOES("vegetable.potatoes", 83, 2),
    GREEN_ONION("vegetable.green.onion", 22, 10),
    BULB_ONIONS("vegetable.bulb.onion", 43, 3),
    CARROT("vegetable.carrot", 33, 2),
    CUCUMBERS("vegetable.cucumbers", 15, 3),
    SWEET_RED_PEPPER("vegetable.sweet.red.pepper", 27, 8),
    PARSLEY("vegetable.parsley", 45, 10),
    RADISH("vegetable.radish", 20, 7),
    SALAD("vegetable.salad", 14, 10),
    BEET("vegetable.beet", 48, 4),
    TOMATOES("vegetable.tomatoes", 19, 5),
    GREEN_BEANS("vegetable.green.beans", 32, 4),
    GARLIC("vegetable.garlic", 106, 8),
    MAYONNAISE("flavoring.mayonnaise", 629, 8),
    OREGANO("flavoring.oregano", 265, 25),
    ROSEMARY("flavoring.rosemary", 331, 20),
    OIL("flavoring.oil", 800, 4),
    SALT("flavoring.salt", 0, 2),
    DILL("flavoring.dill", 253, 8),
    VINEGAR("flavoring.vinegar", 88, 3),
    PEPPER("flavoring.pepper", 263, 5);

    private final String name;
    private final int CALORIES;
    private final int COST;


    Ingredients(String name, int CALORIES, int cost) {
        this.name = name;
        this.CALORIES = CALORIES;
        this.COST = cost;
    }


    public int getCALORIES() {
        return this.CALORIES;
    }

    public int getCOST() {
        return COST;
    }

    @Override
    public String toString() {
        return this.name;
    }

}


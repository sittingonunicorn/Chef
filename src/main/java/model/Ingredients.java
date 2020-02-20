package model;


import java.util.Comparator;

public enum Ingredients {
    GREEN_PEAS("vegetable.green.peas", Classification.BEAN_FAMILY, 72, 5),
    ZUCCHINI("vegetable.zucchini", Classification.GOURD_FAMILY, 27, 7),
    WHITE_CABBAGE("vegetable.white.cabbage", Classification.CABBAGES, 28, 3),
    RED_CABBAGE("vegetable.red.cabbage", Classification.CABBAGES, 31, 5),
    POTATOES("vegetable.potatoes", Classification.TUBERS, 83, 2),
    GREEN_ONION("vegetable.green.onion", Classification.ONIONS, 22, 10),
    BULB_ONIONS("vegetable.bulb.onion", Classification.ONIONS, 43, 3),
    CARROT("vegetable.carrot", Classification.ROOTS, 33, 2),
    CUCUMBERS("vegetable.cucumbers", Classification.GOURD_FAMILY, 15, 3),
    SWEET_RED_PEPPER("vegetable.sweet.red.pepper", Classification.TOMATOES, 27, 8),
    PARSLEY("vegetable.parsley", Classification.SPICY, 45, 10),
    RADISH("vegetable.radish", Classification.ROOTS, 20, 7),
    SALAD("vegetable.salad", Classification.SALADS, 14, 10),
    BEET("vegetable.beet", Classification.ROOTS, 48, 4),
    TOMATOES("vegetable.tomatoes", Classification.TOMATOES, 19, 5),
    GREEN_BEANS("vegetable.green.beans", Classification.BEAN_FAMILY, 32, 4),
    GARLIC("vegetable.garlic", Classification.ONIONS, 106, 8),
    MUSTARD("flavoring.mustard", Classification.SAUCE, 143, 15),
    MAYONNAISE("flavoring.mayonnaise", Classification.SAUCE, 629, 8),
    OREGANO("flavoring.oregano", Classification.HERB, 265, 25),
    ROSEMARY("flavoring.rosemary", Classification.HERB, 331, 20),
    OIL("flavoring.oil", Classification.SAUCE, 800, 4),
    SALT("flavoring.salt", Classification.SEASONING, 0, 2),
    DILL("flavoring.dill", Classification.HERB, 253, 8),
    VINEGAR("flavoring.vinegar", Classification.SAUCE, 88, 3),
    PEPPER("flavoring.pepper", Classification.SEASONING, 263, 5);

    private final String name;
    private final Classification CLASSIFICATION;
    private final int CALORIES;
    private final int COST;


    Ingredients(String name, Classification CLASSIFICATION, int CALORIES, int cost) {
        this.name = name;
        this.CLASSIFICATION = CLASSIFICATION;
        this.CALORIES = CALORIES;
        COST = cost;
    }


    public int getCALORIES() {
        return this.CALORIES;
    }

    public Classification getCLASSIFICATION() {
        return CLASSIFICATION;
    }

    public int getCOST() {
        return COST;
    }

    @Override
    public String toString() {
        return this.name;
    }

    private static class ClassificationComparator implements Comparator<Ingredients> {
        @Override
        public int compare(Ingredients v1, Ingredients v2) {
            return v1.getCLASSIFICATION().compareTo(v2.getCLASSIFICATION());
        }
    }



}

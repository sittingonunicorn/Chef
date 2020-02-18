package model;


import java.util.Comparator;

public enum Ingredient {
    GREEN_PEAS(Classification.BEAN_FAMILY, 72),
    ZUCCHINI(Classification.GOURD_FAMILY, 27),
    WHITE_CABBAGE(Classification.CABBAGES, 28),
    RED_CABBAGE(Classification.CABBAGES, 31),
    POTATOES(Classification.TUBERS, 83),
    GREEN_ONION(Classification.ONIONS, 22),
    BULB_ONIONS(Classification.ONIONS, 43),
    CARROT(Classification.ROOTS, 33),
    CUCUMBERS(Classification.GOURD_FAMILY, 15),
    SWEET_RED_PEPPER(Classification.TOMATOES, 27),
    PARSLEY(Classification.SPICY, 45),
    RADISH(Classification.ROOTS, 20),
    SALAD(Classification.SALADS, 14),
    BEET(Classification.ROOTS, 48),
    TOMATOES(Classification.TOMATOES, 19),
    GREEN_BEANS(Classification.BEAN_FAMILY, 32),
    GARLIC(Classification.ONIONS,  106);


    private final Classification classification;
    private final int calories;


    Ingredient(Classification classification,  int calories) {
        this.classification = classification;
        this.calories = calories;
    }

    public Classification classification() {
        return this.classification;
    }


    public int calories() {
        return this.calories;
    }

    private static class ClassificationComparator implements Comparator<Ingredient> {
        @Override
        public int compare(Ingredient v1, Ingredient v2) {
            return v1.classification().compareTo(v2.classification());
        }
    }

}

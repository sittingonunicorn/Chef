package model;


import java.util.Comparator;

public enum Vegetables {
    GREEN_PEAS(Classification.BEAN_FAMILY, Color.GREEN, 72),
    ZUCCHINI(Classification.GOURD_FAMILY, Color.GREEN, 27),
    WHITE_CABBAGE(Classification.CABBAGES, Color.WHITE, 28),
    RED_CABBAGE(Classification.CABBAGES, Color.VIOLET, 31),
    POTATOES(Classification.TUBERS, Color.WHITE, 83),
    GREEN_ONION(Classification.ONIONS, Color.GREEN, 22),
    BULB_ONIONS(Classification.ONIONS, Color.WHITE, 43),
    CARROT(Classification.ROOTS, Color.ORANGE, 33),
    CUCUMBERS(Classification.GOURD_FAMILY, Color.GREEN, 15),
    SWEET_RED_PEPPER(Classification.TOMATOES, Color.RED, 27),
    PARSLEY(Classification.SPICY, Color.GREEN, 45),
    RADISH(Classification.ROOTS, Color.RED, 20),
    SALAD(Classification.SALADS, Color.GREEN, 14),
    BEET(Classification.ROOTS, Color.VIOLET, 48),
    TOMATOES(Classification.TOMATOES, Color.RED, 19),
    GREEN_BEANS(Classification.BEAN_FAMILY, Color.GREEN, 32),
    GARLIC(Classification.ONIONS, Color.WHITE, 106);


    private final Classification classification;
    private final Color color;
    private final int calories;


    Vegetables(Classification classification, Color color, int calories) {
        this.classification = classification;
        this.color = color;
        this.calories = calories;
    }

    public Classification classification() {
        return this.classification;
    }

    public Color color() {
        return this.color;
    }

    public int calories() {
        return this.calories;
    }

    private static class ClassificationComparator implements Comparator<Vegetables> {
        @Override
        public int compare(Vegetables v1, Vegetables v2) {
            return v1.classification().compareTo(v2.classification());
        }
    }

}

package model;


import java.util.Comparator;

public enum Ingredients {
    GREEN_PEAS(Classification.BEAN_FAMILY, 72, 5),
    ZUCCHINI(Classification.GOURD_FAMILY, 27, 7),
    WHITE_CABBAGE(Classification.CABBAGES, 28, 3),
    RED_CABBAGE(Classification.CABBAGES, 31, 5),
    POTATOES(Classification.TUBERS, 83, 2),
    GREEN_ONION(Classification.ONIONS, 22, 10),
    BULB_ONIONS(Classification.ONIONS, 43, 3),
    CARROT(Classification.ROOTS, 33, 2),
    CUCUMBERS(Classification.GOURD_FAMILY, 15, 3),
    SWEET_RED_PEPPER(Classification.TOMATOES, 27, 8),
    PARSLEY(Classification.SPICY, 45, 10),
    RADISH(Classification.ROOTS, 20, 7),
    SALAD(Classification.SALADS, 14, 10),
    BEET(Classification.ROOTS, 48, 4),
    TOMATOES(Classification.TOMATOES, 19, 5),
    GREEN_BEANS(Classification.BEAN_FAMILY, 32, 4),
    GARLIC(Classification.ONIONS, 106, 8),
    MUSTARD(Classification.SAUCE, 143, 15),
    MAYONNAISE(Classification.SAUCE, 629, 8),
    OREGANO(Classification.HERB, 265, 25),
    ROSEMARY(Classification.HERB, 331, 20),
    OIL(Classification.SAUCE, 800, 4),
    SALT(Classification.SEASONING, 0, 2),
    DILL(Classification.HERB, 253, 8),
    VINEGAR(Classification.SAUCE, 88, 3),
    SALVIA(Classification.HERB, 315, 25),
    PEPPER(Classification.SEASONING, 263, 5);


    private final Classification CLASSIFICATION;
    private final int CALORIES;
    private final int COST;


    Ingredients(Classification CLASSIFICATION, int CALORIES, int cost) {
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

    private static class ClassificationComparator implements Comparator<Ingredients> {
        @Override
        public int compare(Ingredients v1, Ingredients v2) {
            return v1.getCLASSIFICATION().compareTo(v2.getCLASSIFICATION());
        }
    }

}

package model;

public class Ingredient {
    private Ingredients name;
    private Classification classification;
    private int calories;
    private int cost;
    private int quantity;

    public Ingredient(Ingredients name, int quantity) {
        this.name = name;
        this.calories = name.getCALORIES();
        this.classification = name.getCLASSIFICATION();
        this.cost=name.getCOST();
        this.quantity = quantity;
    }

    public Ingredients getName() {
        return name;
    }

    public Classification getClassification() {
        return classification;
    }

    public int getCalories() {
        return calories;
    }

    public int getCost() {
        return cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}

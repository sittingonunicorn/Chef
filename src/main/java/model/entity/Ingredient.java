
package model.entity;

public class Ingredient {
    private Ingredients name;
    private int calories;
    private int cost;
    private int quantity;

    public Ingredient(Ingredients name, int quantity) {
        this.name = name;
        this.calories = name.getCALORIES();
        this.cost = name.getCOST();
        this.quantity = quantity;
    }

    public Ingredients getName() {
        return name;
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

    @Override
    public String toString() {
        return name.toString();
    }
}
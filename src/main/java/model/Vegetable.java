package model;

public class Vegetable extends Ingredient implements ICuttable {
    private boolean isCut = false;

    public Vegetable(Ingredients name, int quantity) {
        super(name, quantity);
    }

    public boolean isCut() {
        return isCut;
    }


    @Override
    public void cut() {
        this.isCut = true;
    }
}
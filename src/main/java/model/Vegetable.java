package model;

public class Vegetable extends Ingredient implements ICuttable {
    private boolean isCut = false;
    private boolean needsBoiling;

    public Vegetable(Ingredients name, int quantity, boolean needsBoiling) {
        super(name, quantity);
        this.needsBoiling= needsBoiling;
    }

    public boolean isCut() {
        return isCut;
    }


    @Override
    public void cut() {
        this.isCut = true;
    }


}
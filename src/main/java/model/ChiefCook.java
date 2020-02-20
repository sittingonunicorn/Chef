package model;


import java.util.ArrayList;
import java.util.List;

public class ChiefCook {
    private List<Ingredient> salad = new ArrayList<>();

    public ChiefCook(List<Ingredient> salad) {
        for (Ingredient ingredient :
                salad) {
            this.salad.add(ingredient);
        }
    }

    public List<Ingredient> getSalad() {
        return salad;
    }

    public void setSalad(List<Ingredient> salad) {
        this.salad = salad;
    }

    public boolean cookSalad() {
        boolean isReady = true;
        for (Ingredient component : this.getSalad()) {
            if (component.getClass() == Vegetable.class) {
                ((Vegetable) component).cut();
                isReady = ((Vegetable) component).isCut();
            }
        }
        return isReady;
    }
}
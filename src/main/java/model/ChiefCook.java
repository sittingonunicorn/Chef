package model;


import java.util.ArrayList;
import java.util.List;

public class ChiefCook {
    String name;
    private List<Ingredient> salad = new ArrayList<>();

    public ChiefCook(String name, List<Ingredient> salad) {
        this.name = name;
        for (Ingredient ingredient :
                salad) {
            this.salad.add(ingredient);
        }
    }

    public String getName() {
        return name;
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
package model;

import java.util.ArrayList;
import java.util.List;

public class Salad {
    private String name;
    private List<Ingredient> salad;

    public Salad(String name, Ingredient... ingredients) {
        this.name = name;
        List<Ingredient> salad = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {
            if (ingredient != null) {
                salad.add(ingredient);
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getSalad() {
        return salad;
    }

}
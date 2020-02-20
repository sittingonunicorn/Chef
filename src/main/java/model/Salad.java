package model;

import java.util.ArrayList;
import java.util.List;

public class Salad {
    private String name;
    private List<Ingredient> salad;

    public Salad(String name, Ingredient... components) {
        this.name = name;
        salad = new ArrayList<Ingredient>();
        for (Ingredient i : components) {
            this.salad.add(i);
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

    @Override
    public String toString() {
        return name + System.lineSeparator() +
                salad;
    }
}
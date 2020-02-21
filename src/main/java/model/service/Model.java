package model.service;

import model.entity.Ingredient;
import model.entity.Vegetable;

import java.util.ArrayList;
import java.util.List;

public class Model {

    public int countCalories(List<Ingredient> salad) {
        double calories = 0;
        for (Ingredient ingredient : salad) {
            if (ingredient != null) {
                calories += Math.round(ingredient.getCalories() * ingredient.getQuantity() / 100.0);
            }
        }
        return (int) calories;
    }

    public List<Ingredient> getVegetablesCaloriesDiapason(List<Ingredient> salad, int min, int max) {
        List<Ingredient> result = new ArrayList<>();
        for (Ingredient ingredient : salad) {
            if (ingredient != null && ingredient.getClass() == Vegetable.class &&
                    ingredient.getCalories() >= min && ingredient.getCalories() <= max) {
                result.add(ingredient);
            }
        }
        return result;
    }
}
package model;

import java.util.List;

public class Model {
    public int countCalories (List<Ingredient> salad){
        int calories = 0;
        for (Ingredient ingredient: salad) {
            if (ingredient!=null){
                calories+=ingredient.getCalories();
            }
        }
        return calories;
    }
}

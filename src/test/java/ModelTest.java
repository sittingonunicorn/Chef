import model.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ModelTest {

    @Test
    public void countCaloriesTest() {
        Model model = new Model();
        ChiefCook chiefCook = new ChiefCook(Menu.getSpicySalad());
        chiefCook.cookSalad();
        int x = model.countCalories(chiefCook.getSalad());
        assertTrue(x >= 61 && x <= 62);
    }

    @Test
    public void getVegetablesCaloriesDiapasonTest(){
        Model model = new Model();
        ChiefCook chiefCook = new ChiefCook(Menu.getSpicySalad());
        chiefCook.cookSalad();
        List<Ingredient> result = model.getVegetablesCaloriesDiapason(chiefCook.getSalad(), 10, 50);
        for (Ingredient i:
        result) {
            System.out.println(i);
        }
        assertNotNull(result);
    }



}

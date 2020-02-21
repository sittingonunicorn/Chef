import model.entity.Ingredient;
import model.service.ChiefCook;
import model.service.Menu;
import model.service.Model;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ModelTest {

    @Test
    public void countCaloriesTest() {
        Model model = new Model();
        ChiefCook chiefCook = new ChiefCook("spicy_salad", Menu.getSpicySalad());
        chiefCook.cookSalad();
        int x = model.countCalories(chiefCook.getSalad());
        assertTrue(x >= 61 && x <= 62);
    }

    @Test
    public void getVegetablesCaloriesDiapasonTest(){
        Model model = new Model();
        ChiefCook chiefCook = new ChiefCook("spicy_salad",Menu.getSpicySalad());
        chiefCook.cookSalad();
        List<Ingredient> result = model.getVegetablesCaloriesDiapason(chiefCook.getSalad(), 10, 50);
        for (Ingredient i:result) {
           assertTrue(i.getCalories()>=10&&i.getCalories()<=50);
        }
        assertNotNull(result);
    }



}

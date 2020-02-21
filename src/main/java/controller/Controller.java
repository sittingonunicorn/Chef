package controller;

import model.ChiefCook;
import model.Ingredient;
import model.Menu;
import model.Model;
import view.View;

import java.util.List;
import java.util.Scanner;

/**
 * Control class, that gets:
 *
 */
public class Controller {
    private Model model;
    private View view;
    private Scanner sc;


    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        sc = new Scanner(System.in);
    }

    public String selectLanguage() {
        String inputString;
        view.printMessage(View.CHOOSE_ENGLISH);
        view.printMessage(View.CHOOSE_UKRAINIAN);
        for (; ; ) {
            while (!sc.hasNext()) {
                view.printMessage(View.WRONG_INPUT_INTERNATIONAL);
                view.printMessage(View.CHOOSE_ENGLISH);
                view.printMessage(View.CHOOSE_UKRAINIAN);
                sc.next();
            }
            if (!((inputString = sc.nextLine()).equals("1") || inputString.equals("2"))) {
                view.printMessage(View.WRONG_INPUT_INTERNATIONAL);
                view.printMessage(View.CHOOSE_ENGLISH);
                view.printMessage(View.CHOOSE_UKRAINIAN);
                continue;
            }
            break;
        }
        return inputString;
    }

    public void processUser() {
        this.view.setBundle(selectLanguage());
        coreDialog();


    }

    private void coreDialog() {
        int mainMenu = 0;
        int infoMenu = 0;
        ChiefCook chiefCook = null;
        Menu menu = new Menu();
        while (mainMenu == 0) {
            view.printEmptyString();
            view.printStringInput("message.read.menu");
            infoMenu = mainMenu();
            chiefCook = new ChiefCook(Menu.menuToArray()[infoMenu - 1], Menu.getSalad(infoMenu - 1));
            mainMenu = infoMenu;
        }

        infoMenu (chiefCook);
    }


    private int infoMenu(ChiefCook chiefCook) {
        view.printStringInput(chiefCook.getName());
        view.printEmptyString();
        view.printInfoMenu();
        view.printStringInput("message.choose.menu");
        int infoMenu = getNumberConsole(0,5);
        if (infoMenu == 0) {
            coreDialog();
        }
        getInfo(infoMenu, chiefCook);
        return infoMenu;
    }


    private void getInfo(int infoMenu, ChiefCook chiefCook) {
        List<Ingredient> ingredients = chiefCook.getSalad();
        switch (infoMenu) {
            case 1: {
                cooking(chiefCook);
                break;
            }
            case 2: {
                sortByCost(ingredients);
                break;
            }
            case 3: {
                sortByCalories(ingredients);
                break;
            }
            case 4: {
                outputDiapason(ingredients);
                break;
            }
            case 5: {
                outputCalorificValue(ingredients);
                break;
            }

        }
        endMenu(chiefCook);

    }

    private void endMenu(ChiefCook chiefCook) {
        view.printEndMenu();
        int x = getNumberConsole(0,2);
        if (x == 1) {
            coreDialog();
        } else if (x == 2) {
            infoMenu(chiefCook);
        }
    }

    private void outputCalorificValue(List<Ingredient> ingredients) {
        view.printIntAndStringInput(model.countCalories(ingredients), view.CALORIES_PORTION);
    }

    private void outputDiapason(List<Ingredient> ingredients) {
        int min ;
        int max ;
        for (; ; ) {
            view.printStringInput("message.input.minimum");
            while (!sc.hasNextInt()) {
                view.printStringInput(View.WRONG_INPUT);
                sc.next();
            }
            min = sc.nextInt();
            view.printStringInput("message.input.maximum");
            while (!sc.hasNextInt()) {
                view.printStringInput(View.WRONG_INPUT);
                sc.next();
            }
            max = sc.nextInt();
            if (min > max || min < 0 || max < 0) {
                view.printStringInput(View.WRONG_INPUT);
                continue;
            }

            break;
        }
        List<Ingredient> result = model.getVegetablesCaloriesDiapason(ingredients, min, max);
        if (result.size() == 0) {
            view.printStringInput(view.NO_VEGETABLES_FOUND);

        } else {
            view.printIngredientsCalories(result);
        }

    }

    private void sortByCalories(List<Ingredient> ingredients) {
        ingredients.sort((v1, v2) -> v1.getCalories() - v2.getCalories());
        view.printIngredientsCalories(ingredients);
    }

    private void sortByCost(List<Ingredient> ingredients) {
        ingredients.sort((v1, v2) -> v1.getCost() - v2.getCost());
        view.printIngredientsCost(ingredients);
    }

    private void cooking(ChiefCook chiefCook) {
        chiefCook.cookSalad();
        view.printStringInput(view.SALAD_IS_READY);
    }

    private int mainMenu() {

        view.printMessage(view.menuToPrint(Menu.menuToArray()));
        view.concatenationString();
        view.printStringInput("message.choose.menu");
        return getNumberConsole(1, Menu.menuToArray().length);

    }

    public int getNumberConsole(int min, int max) {
        int inputNumber;
        for (; ; ) {
            while (!sc.hasNextInt()) {
                view.printStringInput(View.WRONG_INPUT);
                sc.next();
            }
            if ((inputNumber = sc.nextInt()) < min || (inputNumber > max)) {
                view.printStringInput(View.WRONG_INPUT);
                continue;
            }
            break;
        }
        return inputNumber;

    }

}

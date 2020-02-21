package controller;

import model.service.ChiefCook;
import model.entity.Ingredient;
import model.service.Menu;
import model.service.Model;
import view.View;

import java.util.List;
import java.util.Scanner;

/**
 * Control class, that gets Model and View objects. Leads all the process for program.
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

    /**
     * Method gets from console variable to select language of user interface
     *
     * @return int language
     */
    public String selectLanguage() {
        String language;
        view.printMessage(View.CHOOSE_ENGLISH);
        view.printMessage(View.CHOOSE_UKRAINIAN);
        for (; ; ) {
            while (!sc.hasNext()) {
                view.printMessage(View.WRONG_INPUT_INTERNATIONAL);
                view.printMessage(View.CHOOSE_ENGLISH);
                view.printMessage(View.CHOOSE_UKRAINIAN);
                sc.next();
            }
            if (!((language = sc.nextLine()).equals("1") || language.equals("2"))) {
                view.printMessage(View.WRONG_INPUT_INTERNATIONAL);
                view.printMessage(View.CHOOSE_ENGLISH);
                view.printMessage(View.CHOOSE_UKRAINIAN);
                continue;
            }
            break;
        }
        return language;
    }

    /**
     * Core method of program. Calls all the rest of methods
     */
    public void processUser() {
        this.view.setBundle(selectLanguage());
        coreRun();


    }

    /**
     * Core run of the program. Calls the main menu, creates object of ChiefCook, and calls info menu.
     */
    private void coreRun() {
        int mainMenu = 0;
        ChiefCook chiefCook = null;
        while (mainMenu == 0) {
            view.printEmptyString();
            view.printStringInput(view.MENU);
            mainMenu = mainMenu();
            chiefCook = new ChiefCook(Menu.menuToArray()[mainMenu - 1], Menu.getSalad(mainMenu - 1));
        }

        infoMenu(chiefCook);
    }

    /**
     * Provides user the choice of acts with chosen salad.
     *
     * @param chiefCook - instance of ChiefCook with chosen salad
     */
    private void infoMenu(ChiefCook chiefCook) {
        view.printStringInput(chiefCook.getName());
        view.printEmptyString();
        view.printInfoMenu();
        view.printStringInput(view.CHOOSE_MENU);
        int infoMenu = getNumberConsole(0, 6);
        if (infoMenu == 0) {
            coreRun();
        }
        getInfo(infoMenu, chiefCook);
    }

    /**
     * Calls the methods to perform the requested action with salad.
     *
     * @param infoMenu  - number of chosen menu line
     * @param chiefCook - instance of ChiefCook with chosen salad
     */
    private void getInfo(int infoMenu, ChiefCook chiefCook) {
        List<Ingredient> ingredients = chiefCook.getSalad();
        switch (infoMenu) {
            case 1: {
                model.cooking(chiefCook);
                view.printStringInput(view.SALAD_IS_READY);
                break;
            }
            case 2: {
                model.sortByCost(ingredients);
                view.printIngredientsCost(ingredients);
                break;
            }
            case 3: {
                model.sortByCalories(ingredients);
                view.printIngredientsCalories(ingredients);
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
            case 6: {
                view.printIngredients(ingredients);
                break;
            }

        }
        endMenu(chiefCook);

    }

    /**
     * Provides menu to choose if program should end its work or continue.
     *
     * @param chiefCook - instance of ChiefCook with chosen salad
     */
    private void endMenu(ChiefCook chiefCook) {
        view.printEmptyString();
        view.printEndMenu();
        int x = getNumberConsole(0, 2);
        if (x == 1) {
            coreRun();
        } else if (x == 2) {
            infoMenu(chiefCook);
        }
    }

    /**
     * Outputs calorific value of each ingredient.
     *
     * @param ingredients - chosen salad
     */
    private void outputCalorificValue(List<Ingredient> ingredients) {
        view.printIntAndStringInput(model.countCalories(ingredients), view.CALORIES_PORTION);
    }

    /**
     * Outputs the vegetables with calorific values in chosen diapason.
     *
     * @param ingredients - chosen salad
     */
    private void outputDiapason(List<Ingredient> ingredients) {
        int min;
        int max;
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


    /**
     * Forms main menu from Menu.
     *
     * @return number of chosen menu line
     */
    private int mainMenu() {
        view.printMessage(view.menuToPrint(Menu.menuToArray()));
        view.concatenationString();
        view.printStringInput(view.CHOOSE_MENU);
        return getNumberConsole(1, Menu.menuToArray().length);

    }

    /**
     * Gets min and max values from console.
     *
     * @param min - min value
     * @param max - max value
     * @return input number
     */
    private int getNumberConsole(int min, int max) {
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
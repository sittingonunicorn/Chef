package controller;

import model.ChiefCook;
import model.Menu;
import model.Model;
import view.View;

import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public String selectLanguage(Scanner sc) {
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
                view.printMessage(View.WRONG_INPUT);
                view.printMessage(View.CHOOSE_ENGLISH);
                view.printMessage(View.CHOOSE_UKRAINIAN);
                continue;
            }
            break;
        }
        return inputString;
    }

    public void processUser() {
        Scanner sc = new Scanner(System.in);
        this.view.setBundle(selectLanguage(sc));

        view.printStringInput("read.menu");
        Menu menu = new Menu();
        view.printMessage(view.menuToPrint(menu.menuToArray()));
        view.concatenationString();
        view.printStringInput("message.choose.salad");
        ChiefCook chiefCook = new ChiefCook (Menu.getSalad(getNumberConsole(sc, Menu.menuToArray())));
        chiefCook.cookSalad();
    }

    public int getNumberConsole(Scanner sc, String [] menu) {
        int inputNumber;
        for (; ; ) {
            while (!sc.hasNextInt()) {
                view.printStringInput(View.WRONG_INPUT);
                sc.next();
            }
            if ((inputNumber = sc.nextInt())<1||(inputNumber>menu.length)) {
                view.printStringInput(View.WRONG_INPUT);
                continue;
            }
            break;
        }
        return inputNumber;

    }
}

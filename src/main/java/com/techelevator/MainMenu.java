package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class MainMenu extends Menu {

PurchaseMenu purchaseMenu;
    public MainMenu() {
        super();
        this.purchaseMenu = new PurchaseMenu();
    }

    public void mainMenu(Logger logger){
        Map<Integer,String> mainMenu = new HashMap<>();
        mainMenu.put(1,"Display Vending Machine Items");
        mainMenu.put(2,"Purchase");
        mainMenu.put(3,"Exit");
        displayMenuOptions(mainMenu);
        this.logger = logger;
    }
    public boolean mainMenuSelection(int userInput){

        switch(userInput){
            //break need to be included or this will run all the cases one by one instead of one at time of selection
            case 1:
                displayMenuOptions(inventory.getInventoryList());
                break;
            case 2:
                System.out.println("Current Money Provided: $"+ wallet.getCurrentAmount());

                purchaseMenu.purchaseMenu();
                //TODO: This needs to open the "purchaseMenu". Which may also need its own loop as to not exit back to
                // the main menu once a selection is made
                break;
            case 3:
                return false;
        }
        return true;
    }
    public boolean sendUserInput(int userInput) {
        return mainMenuSelection(userInput);
    }
}

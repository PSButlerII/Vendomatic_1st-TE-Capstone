package com.techelevator;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class PurchaseMenu extends Menu {

    public PurchaseMenu() {
        super();
    }

    public void purchaseMenu(){
        Map<Integer,String> purchaseMenu = new HashMap<>();
        purchaseMenu.put(1,"Feed Money");
        purchaseMenu.put(2,"Select Product");
        purchaseMenu.put(3,"Finish Transaction");

        boolean isPurchaseMenu=true;
        while(isPurchaseMenu){
            displayMenuOptions(purchaseMenu);
            System.out.println("Make a selection please!");
            try {
                int userInput = Integer.parseInt(scanner.nextLine());
                isPurchaseMenu = purchaseMenuSelection(userInput);
            }
            catch (NumberFormatException e){
                System.out.println("not a number valid number!");
            }
        }
    }
    public boolean purchaseMenuSelection(int userInput){
        switch(userInput){
            //break need to be included or this will run all the cases one by one instead of one at time of selection
            case 1:
                // should add money to the machine
                System.out.println("Enter amount of money: ");
                wallet.addMoney(BigDecimal.valueOf(Integer.parseInt(scanner.nextLine())));
                System.out.println("Current balance: $" + wallet.getCurrentAmount());

                break;
            case 2:
                System.out.println("Current Money Provided: $"+ wallet.getCurrentAmount());
                productSelection();
                break;
            case 3:
                System.out.println(wallet.giveChange() + " is your change!");
                return false;
        }
        return true;
    }
    public void productSelection(){
        System.out.println("Select a category:" + "\n" + "1: Gum" + "\n" + "2: Drink" + "\n" + "3: Munchy" + "\n" + "4: Candy");
        String category;
        int userInput = Integer.parseInt(scanner.nextLine());
        if(!getCategoriesNotMagicStrings(userInput).isEmpty()) {
            category = getCategoriesNotMagicStrings(userInput);
            boolean isSelection = true;
            while (isSelection) {
                Map<String, Item> items = inventory.getItemsByCategory(category);
                for (Map.Entry<String, Item> entry : items.entrySet()) {
                    Item item = entry.getValue();
                    System.out.println(entry.getKey() + ": " + item.getName() + "| Price: $" + item.getPrice() + " " + "|Quantity: " + item.getQuantity());
                }

                System.out.println("Enter the item code to add to cart:");
                String itemCode = scanner.nextLine().toUpperCase();
                addItemToCart(itemCode);
                isSelection = false;

            }
        }
    }
    private String getCategoriesNotMagicStrings(int choice){
        switch (choice){
            case 1:return "Gum";
            case 2:return "Drink";
            case 3:return "Munchy";
            case 4:return "Candy";
            default:return "";
        }
    }
}

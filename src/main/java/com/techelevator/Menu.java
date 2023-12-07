package com.techelevator;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

public class Menu {

    protected Logger logger = new Logger("C:\\Users\\Student\\workspace\\pairs\\java-purple-minicapstonemodule1-team5\\log.txt");
    Inventory inventory;
    Wallet wallet;
    Scanner scanner;
    Item item;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.inventory = Inventory.getInstance();
        this.wallet = new Wallet();
        this.item = new Item();
    }
    public void displayMenuOptions(Map<?,?> menuOptions){
        // Loops through the "Map" and prints each item to the screen?
    // we can reuse this for every menu that is of type Map.
        for (Map.Entry<?,?> entry :menuOptions.entrySet()) {
            System.out.println(entry.getKey()+ ": "+entry.getValue()+" ");
        }
    }
    public void addItemToCart(String itemCode){
     itemCode = itemCode.toUpperCase();
     Item myItem;
     if(inventory.isAvailable(itemCode)){
          myItem =inventory.getItem(itemCode);
         BigDecimal price = BigDecimal.valueOf((myItem.getPrice()));
         if(wallet.getCurrentAmount().compareTo(price)>=0){
             ShoppingCart shoppingCart = new ShoppingCart(inventory);
             shoppingCart.addItem(itemCode);
             wallet.completePurchase(price);
             logger.log(myItem.getName()+" "+myItem.getSlotLocation()+" "+myItem.getPrice()+" "+wallet.getCurrentAmount());
             System.out.println(myItem + " " + item.printVendingMessage(myItem.getType()));
             System.out.println("Purchase successful. Remaining balance: $" + wallet.getCurrentAmount()+"\n");
         }
         else{
             System.out.println("Insufficient funds.");
         }
     }
     else{
         System.out.println("Item not available");
     }
 }
}

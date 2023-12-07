package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private Map<String,Integer> itemsCart;
    private Inventory inventory;
    Wallet wallet = new Wallet();
    Logger logger = new Logger("C:\\Users\\Student\\workspace\\pairs\\java-purple-minicapstonemodule1-team5\\log.txt");
    public ShoppingCart(Inventory inventory){
        this.itemsCart = new HashMap<>();
        this.inventory = inventory;

    }


    // add items
    public void addItem(String itemCode){
        itemCode = itemCode.toUpperCase(); // Standardizing item code to uppercase
        if (inventory.isAvailable(itemCode)) {
            itemsCart.put(itemCode, itemsCart.getOrDefault(itemCode, 0) + 1);
            inventory.reduceItemQuantity(itemCode);

            //logger.log(inventory.getItem(itemCode).getName()+" "+ inventory.getItem(itemCode).getSlotLocation()+" "+ inventory.getItem(itemCode).getPrice()+" " + wallet.getCurrentAmount());
        } else {
            System.out.println("Item " + itemCode + " is not available.");
        }
    }


    //reduce items


    //clear items?


}

package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Inventory {
    //please don't yell at me for this
    private static Inventory inventory;
    private Map<String, Item> inventoryList;
    public Inventory () {
        this.inventoryList = new HashMap<>();
        loadInventory("C:\\Users\\Student\\workspace\\pairs\\java-purple-minicapstonemodule1-team5\\main.csv" );
    }

    /**
     * https://stackoverflow.com/questions/10477281/please-tell-me-when-to-use-getinstance-method-in-java
     * @return
     */
    public static Inventory getInstance(){
        if(inventory ==null){
            inventory = new Inventory();
        }
        return inventory;
    }
    public void loadInventory(String filePath){
        //String filePath = ;
        File file = new File(filePath);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] fields = line.split(",");
                Item item = new Item();
                    item.setSlotLocation(fields[0]);
                    item.setName(fields[1]);
                    item.setPrice(Double.parseDouble(fields[2]));
                    item.setType(fields[3]);
                    inventoryList.put(fields[0], item);
            }
        }
        catch(NullPointerException n){
            System.out.println(n.getMessage() );
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found" + e.getMessage());
        }

    }
    public boolean isAvailable(String itemCode){
        Item item = inventoryList.get(itemCode);
        return item != null && item.getQuantity()>0;
    }
    public Map<String, Item> getInventoryList() {
        return inventoryList;
    }
    public Map<String, Item> getItemsByCategory(String category) {
        Map<String, Item> itemsByCategory = new HashMap<>();
        for (Item item : inventoryList.values()) {
            if (item.getType().equalsIgnoreCase(category)) {
                itemsByCategory.put(item.getSlotLocation(), item);
            }
        }
        return itemsByCategory;
    }
    public Item  getItem(String itemCode) {
        return inventoryList.get(itemCode);
    }
    public void reduceItemQuantity(String itemCode) {
        if (inventoryList.containsKey(itemCode.toUpperCase())) {
            Item item = inventoryList.get(itemCode.toUpperCase());
            if (item.getQuantity() > 0) {
                item.setQuantity(item.getQuantity() - 1);
            } else {
                System.out.println("Item " + itemCode + " is out of stock.");
            }
        }
    }
}

package com.techelevator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void loadInventory() {
        Map<String, Item> inventoryList = new HashMap<>();
        String fileName = "C:\\Users\\Student\\workspace\\pairs\\java-purple-minicapstonemodule1-team5\\alternate.csv";
        Inventory inventory = new Inventory();
        inventory.loadInventory(fileName);
        Map<String,Item> string = inventory.getInventoryList();
        File file = new File(fileName);
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
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        assertNotEquals(inventoryList,string);

    }

    @Test
    void testLoadInventory() {
    }

    @Test
    void isAvailable() {
    }

    @Test
    void getInventory() {
    }

}
package com.techelevator;

public class Item {
    private String name;
    private String type;
    private String slotLocation;
    private double price;
    private int quantity=5;


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getSlotLocation() {
        return slotLocation;
    }
    public void setSlotLocation(String slotLocation) {
        this.slotLocation = slotLocation;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public void dispense(){
        //TODO: finish method
    }


    public String printVendingMessage(String itemCode){
//        Dispensing an item prints the item name, cost, and the money remaining. Dispensing also returns a message:

        switch (itemCode){
            case "Munchy":
                return /*All Munchy items print*/ "Crunch Crunch, Yum!";
            case "Candy":
                return/*All Candy items print*/ "Yummy Yummy, So Sweet!";
            case "Drink":
                return /*All Drink items print */"Glug Glug, Yum!";
            case "Gum":
                return/* All Gum items print */ "Chew Chew, Yum!";
            default:
                System.out.println("MEW!!!");
        }
        return "";
    }

    @Override
    public String toString() {
        return  "Item: " + name + "| "+
                "Type: " + type + "| " +
                "Price: " + price + "| "+
                "Quantity: " + quantity;
    }
}



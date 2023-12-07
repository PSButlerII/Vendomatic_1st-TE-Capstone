package com.techelevator;

import java.math.BigDecimal;

public class Wallet {
    // Need to use BigDecimal in order get the correct amounts in change.
    //TODO: Add all the change variables, pennies, nickels, quarters, and dimes.
    BigDecimal pennies;
    BigDecimal dimes;
    BigDecimal nickels;
    BigDecimal quarters;
    BigDecimal currentAmount;
    Logger logger = new Logger("C:\\Users\\Student\\workspace\\pairs\\java-purple-minicapstonemodule1-team5\\log.txt");

    private boolean applyDiscount(){
        return itemsPurchased % 2 == 0;
    } //to track if discount applies
    private int itemsPurchased; //counter for number of items
    public Wallet() {
        pennies = BigDecimal.ZERO;
        dimes = BigDecimal.ZERO;
        nickels = BigDecimal.ZERO;
        quarters = BigDecimal.ZERO;
        currentAmount = BigDecimal.ZERO;
        itemsPurchased = 0;
    }

    public void setPennies(BigDecimal pennies) {
        this.pennies = pennies;
    }
    public void setCurrentAmount(BigDecimal currentAmount) {
        this.currentAmount = currentAmount;
    }
    public void  setQuarters(BigDecimal quarters) {
        this.quarters = quarters;
    }
    public void setDimes(BigDecimal dimes) {
        this.dimes = dimes;
    }
    public void setNickels(BigDecimal nickels) {
        this.nickels = nickels;
    }
    public BigDecimal getCurrentAmount() {
        return currentAmount;
    }
    public void addMoney(BigDecimal userMoneyIn){


        currentAmount = currentAmount.add(userMoneyIn);

        logger.log("FEED MONEY "+userMoneyIn +" "+getCurrentAmount());
        //TODO: need to add logger here for FEED Money

    }

    /**
     * https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/math/BigDecimal.html
     * @return
     */
    public String giveChange(){
        BigDecimal hundred= new BigDecimal("100");
        BigDecimal amountRemaining = currentAmount.multiply(hundred);  // this should convert the amount into cents

        BigDecimal[] dividedAmount= amountRemaining.divideAndRemainder(new BigDecimal("25"));
        setQuarters(dividedAmount[0]);
        amountRemaining = dividedAmount[1];

        dividedAmount= amountRemaining.divideAndRemainder(new BigDecimal("10"));
        setDimes(dividedAmount[0]);
        amountRemaining = dividedAmount[1];

        dividedAmount= amountRemaining.divideAndRemainder(new BigDecimal("5"));
        setNickels(dividedAmount[0]);
        amountRemaining = dividedAmount[1];

        setPennies(amountRemaining);

        BigDecimal loggerInfo = currentAmount;
        // Reset currentAmount to zero
        currentAmount = BigDecimal.ZERO;
        logger.log("CHANGE GIVEN: "+ loggerInfo +" "+currentAmount);
        return StringifyTheChange();
    }

    /**
     * Using BigDecimal
     * @return
     */
    private String StringifyTheChange() {
        String details = "";
        if(quarters.compareTo(BigDecimal.ZERO)>0){
            details += "Quarters: " + quarters + ", ";
        }
        if(dimes.compareTo(BigDecimal.ZERO)>0){
            details += "Dimes: " + dimes + ", ";
        }
        if(nickels.compareTo(BigDecimal.ZERO)>0){
            details += "Nickles: " + nickels + ", ";
        }
        if (pennies.compareTo(BigDecimal.ZERO)>0){
            details += "Pennies: " + pennies + ", ";
        }
        if(details.endsWith(", ")){
            details = details.substring(0, details.length()-2);
        }
        return details;
    }
    public void completePurchase(BigDecimal price){
        itemsPurchased++;
        if (applyDiscount()){
            price = price.subtract(BigDecimal.valueOf(1));
        }
        //TODO: need to add logger here for the purchase

        setCurrentAmount(getCurrentAmount().subtract(price));
    }


}

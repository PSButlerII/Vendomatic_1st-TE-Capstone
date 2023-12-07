package com.techelevator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    private String fileName;

    public Logger(String fileName) {
        this.fileName = fileName;
    }
    public void log(String message) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            writer.println(timeStamp + " - " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


// TODO:   Sales report
//    The output sales report file is pipe-delimited for consistency. Each line is a separate product with the number of sales for the applicable product. At the end of the report is a blank line followed by the TOTAL SALES dollar amount indicating the gross sales from the vending machine.
//
//      Items purchased at a discount through the BOGODO sale are the last number in the row for each item in the following format:
//
//    Taste Elevator Sales Report item|amount sold full price|amount sold with BOGODO discount
//
//    For example:
//
//    Potato Crisps|0|0
//    Stackers|1|0
//    Grain Waves|0|0
//    Cloud Popcorn|0|0
//    Moonpie|3|1
//    Cowtales|0|0
//    Wonka Bar|0|0
//    Crunchie|0|0
//    Cola|2|1
//    Dr. Salt|0|0
//    Mountain Melter|0|0
//    Heavy|0|0
//    U-Chews|0|0
//    Little League Chew|1|0
//    Chiclets|1|0
//    Triplemint|0|0
//
//            **TOTAL SALES** $31.05




}


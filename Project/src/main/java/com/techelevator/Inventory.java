package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.*;

public class Inventory {

    private List<Item> items = new ArrayList<>();
    private String filePath = "C:\\Users\\Student\\workspace\\java-minicapstonemodule1-team3\\capstone\\vendingmachine.csv";
    private int quantity = 5;

    File file = new File(filePath);

    public  Inventory() throws FileNotFoundException {
            try (Scanner readCSV = new Scanner(file)) {


                while (readCSV.hasNextLine()) {


                    String line = readCSV.nextLine();
                    String[] splitItemstring = line.split(",");
                    String slotLocation = splitItemstring[0];
                    String itemName = splitItemstring[1];
                    double itemPrice = Double.parseDouble(splitItemstring[2]);
                    String itemType = splitItemstring[3];


                    Item item = new Item(slotLocation, itemName, itemPrice, itemType, quantity);
                    items.add(item);

                }

            }
            catch (Exception exception) {

            }
    }
    public List<Item> getItems(){
        return this.items;
    }
    public void displayItems(){
        List<Item> displayItems = getItems();

        for(Item item : displayItems){
            String remarks = "";
            if(item.getItemQuantity() == 0) {
                remarks = "Sold Out";
            }
            System.out.println(item.getSlotLocation() + " " + item.getItemName() + " " + item.getItemPrice() + " " + "Quantity" + " " +  item.getItemQuantity() + " " + remarks);
        }
    }
}

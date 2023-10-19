package com.pluralsight;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;
import java.io.*;
public class SearchMapInventory {

    public static HashMap<Integer, Product> inventory = new HashMap<Integer, Product>();

    public static void main(String[] args) {
        String choice;
        do {
            loadInvetory();
            Scanner input = new Scanner(System.in);
            System.out.println("What item number are you interested in?");
            int id = input.nextInt();
            Product matchedProduct = inventory.get(id);
            if(matchedProduct == null){
                System.out.println("We do not have that at this moment.");
                return;
            }
            System.out.printf("We have %s and the price is %.2f",
                    matchedProduct.getName(), matchedProduct.getPrice());
            System.out.println();
            input.nextLine();
            System.out.println("Do you want to look again for something?(Y/N)");
            choice = input.nextLine();
        }while(choice.equalsIgnoreCase("y"));
    }

    public static void loadInvetory() {
        try{
            FileReader fileReader = new FileReader("src/main/resources/inventory.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int counter = 0;
            String keyboard;
            while ((keyboard = bufferedReader.readLine()) != null){
                String[] line = keyboard.split("\\|");
                int id = Integer.parseInt((line[0]));
                String name = line[0];
                float price = Float.parseFloat(line[2]);
                counter++;
                inventory.put(id,new Product(id, price, name));
            }
        }catch (IOException e){
            e.getStackTrace();
        }
    }
}

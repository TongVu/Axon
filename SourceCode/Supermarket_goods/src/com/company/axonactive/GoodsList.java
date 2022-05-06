package com.company.axonactive;

import java.text.ParseException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class GoodsList {

    private Set<Goods> goodsList = new TreeSet<>(new NameComparator());

    public GoodsList() throws ParseException {
        Foods food1 = new Foods("1","banana",12,50,"Vietnam","05/05/2022","05/05/2022");
        Foods food2 = new Foods("","hamburger",22,5,"Vietnam","05/05/2022","05/05/2022");
        Foods food3 = new Foods("3","apple",32,60,"Vietnam","05/05/2022","05/05/2022");
        Electronics elec1 = new Electronics("4","TV",100,10,12,500);
        Electronics elec2 = new Electronics("5","Fridge",145,10,12,500);
        Ceramics cre1 = new Ceramics("6","crenamic",200,5,"aa","06/02/2022");

//        goodsList.addAll(food1,food2,food3,elec1,elec2,cre1);

        goodsList.add(food1);
        goodsList.add(food2);
        goodsList.add(food3);
        goodsList.add(elec1);
        goodsList.add(elec2);
        goodsList.add(cre1);



    }

    public void addGoods() throws ParseException {
        Scanner kb = new Scanner(System.in);
        String choice;

        System.out.print("Type of product (1.Food | 2.Electronic | 3.Ceramic).\n" +
                "Enter (1,2,3): ");
        choice = kb.nextLine();
        Goods newGoods = null;

        switch (choice){
            case "1" -> newGoods = createFood();
            case "2" -> newGoods = createElectronic();
            case "3" -> newGoods = createCeramic();
        }
        System.out.print("Enter id: ");
        newGoods.setId(kb.nextLine());
        System.out.print("Enter name: ");
        newGoods.setGoodsName(kb.nextLine());
        System.out.print("Enter price: ");
        newGoods.setPrice(kb.nextDouble());
        System.out.print("Enter stock units: ");
        newGoods.setStockUnit(kb.nextInt());

        goodsList.add(newGoods);
    }

    public Goods createFood() throws ParseException {
        Scanner kb = new Scanner(System.in);
        Foods newFood = new Foods();

        System.out.print("Enter manufacturer: ");
        newFood.setManufacturer(kb.nextLine());

        System.out.print("Enter production date (dd/mm/yyyy): ");
        newFood.setProductionDate(kb.nextLine()); //input directly into set method

        System.out.print("Enter expired date (dd/mm/yyyy): ");
        newFood.setExpiredDate(kb.nextLine());

        return newFood;
    }
    public Goods createElectronic(){
        Scanner kb = new Scanner(System.in);
        Electronics newElectronic = new Electronics();

        System.out.print("Enter number of month for warranty: ");
        newElectronic.setWarranty(kb.nextDouble());

        System.out.print("Enter power of the device: ");
        newElectronic.setPower(kb.nextDouble());

        return newElectronic;
    }
    public Goods createCeramic() throws ParseException {
        Ceramics newCeramics = new Ceramics();

        System.out.print("Enter manufacturer: ");
        newCeramics.setManufacturer(new Scanner(System.in).nextLine()); // I can also use this one

        System.out.print("Enter imported date (dd/mm/yyyy): ");
        newCeramics.setImportedDate(new Scanner(System.in).nextLine());

        return newCeramics;
    }

    public void printAll(){
        for (Goods item: goodsList)
            System.out.println(item.toString());
    }

    public void printSelective(){
        Scanner kb = new Scanner(System.in);

        System.out.print("Enter type of goods to show: \n" +
                "1.Foods\n"+
                "2.Electronics\n" +
                "3.Ceramic\n" +
                "Your choice: ");

        String choice = kb.nextLine();
        if (choice.equals("1")) {
            for (Goods item : goodsList)
                if (item instanceof Foods) System.out.println(item);
        }
        else if(choice.equals("2")) {
            for (Goods item : goodsList)
                if (item instanceof Electronics) System.out.println(item);
        }
        else if (choice.equals("3")){
            for (Goods item : goodsList)
                if (item instanceof Ceramics) System.out.println(item);
        }
        else System.out.println("Invalid input");
    }

    public Goods searchById(){
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter product's id to search: ");
        String idSearch = kb.nextLine();

        Goods foundItem = null;
        for (Goods item:
             goodsList) {
            if(item.getId().equals(idSearch)) {
                foundItem = item;
            }
        }

        return foundItem;
    }

    public void sortByName(){
        for (Goods item:
             goodsList) {
            System.out.println(item);
        }
    }
    public void sortByQuantity(){
        Set<Goods> listSortByQuantity = new TreeSet<>(new QuantityComparator());
        listSortByQuantity.addAll(goodsList);

        for (Goods item: goodsList)  System.out.println(item);
    }

    public void deleteById(){
        Goods findItem = searchById();
        if(findItem == null) System.out.println("not found item");
        else {
            goodsList.remove(findItem);
            System.out.println("Item deleted");
        }


    }

    public void showHardSellingItem(){
        for (Goods item:
             goodsList) {
            if(item.checkSalesRate().equals("Hard to sell"))
                System.out.println(item);
        }
    }

    public void editPrice(){
        Goods itemEdited = searchById();
        if (itemEdited != null){
            System.out.print("Enter the price to edit for the product: ");
            double newPrice = new Scanner(System.in).nextDouble();
            for (Goods item :
                    goodsList) {
                if (item.getId().equals(item.getId()))
                    item.setPrice(newPrice);
            }
        } else System.out.println("Item not FOUNDED");
    }

    public void start() throws ParseException {
        Scanner kb = new Scanner(System.in);
        int choice;
        System.out.println("Menu: ");
        do {
            System.out.println("1. Add item(s)");
            System.out.println("2. Print all items");
            System.out.println("3. Print specific item");
            System.out.println("4. Search items by ID");
            System.out.println("5. Sort items by name");
            System.out.println("6. Sort items by quantity");
            System.out.println("7. Delete item by ID");
            System.out.println("8. Show all hard selling items");
            System.out.println("9. Edit item's price through ID");
            System.out.println("10.Exit");
            System.out.print("Enter your choice: ");
            choice = kb.nextInt();
            switch (choice){
                case 1 -> addGoods();
                case 2 -> printAll();
                case 3 -> printSelective();
                case 4 -> {
                    Goods newGood = searchById();

                    if (newGood != null) System.out.println(newGood);
                    else System.out.println("not found");

                }
                case 5 -> sortByName();
                case 6 -> sortByQuantity();
                case 7 -> deleteById();
                case 8 -> showHardSellingItem();
                case 9 -> editPrice();
                case 10 -> System.out.println("Exit!");
            }
        }while (choice <9 && choice >0);



    }

}

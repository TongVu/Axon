package com.company.axonactive;

import java.text.ParseException;
import java.util.*;

public class GoodsList {
    private Set<Goods> goodsList = new TreeSet<>(new NameComparator());

    /*
        4 methods below is use to check date if it's legit
     */

    /**
     * isNumber check if date, month, or year is a number
     */
    private boolean isNumber(String dateMonthOrYear) {
        if (dateMonthOrYear == null) return false;

        try {
            Integer.parseInt(dateMonthOrYear);
        } catch (NumberFormatException numberFormatException) {
            return false;
        }

        return true;
    }

    /**
     * checkDay check if day in range 1 - 31
     */
    private boolean checkDay(String day) {
        if (Integer.parseInt(day) > 0 &&
                Integer.parseInt(day) <= 31) {
            return true;
        } else return false;
    }

    /**
     * checkMonth check if month in range 1-12
     */
    private boolean checkMonth(String month) {
        if (Integer.parseInt(month) > 0 &&
                Integer.parseInt(month) < 13) {
            return true;
        } else return false;
    }

    /**
     * checkYear check if Year from 2000 - THIS_YEAR
     * THIS_YEAR is get from Calendar class
     */
    private boolean checkYear(String year) {
        int THIS_YEAR = Calendar.getInstance().get(Calendar.YEAR); // I check this one on stack_overflow, not know it in advance

        if (Integer.parseInt(year) >= 2000 &&
                Integer.parseInt(year) <= THIS_YEAR) {
            return true;
        } else return false;
    }


    private boolean isDateValid(String day, String month, String year) {
        if (!checkDay(day)) {// if day in range 1 -31
            System.out.println("Day have to be in range 1 - 31");
            return false;
        }
        if (!checkMonth(month)) { // if month in range 1 - 12
            System.out.println("Month have to be in range 1 - 12");
            return false;
        }
        if (!checkYear(year)) {// if month in range 2000 - now
            System.out.println("Year have to be in range 2000 - now");
            return false;
        }
        return true;
    }

    private boolean isDateBeforeNow(String day, String month, String year) throws ParseException {
        StringBuilder date = new StringBuilder();
        date.append(day).append("/").append("/").append(year);

        int THIS_YEAR = Calendar.getInstance().get(Calendar.YEAR);
        int THIS_MONTH = Calendar.getInstance().get(Calendar.MONTH) + 1;
        int THIS_DAY = Calendar.DAY_OF_WEEK_IN_MONTH;

        if (Integer.parseInt(year) < THIS_YEAR) return true;
        else if(Integer.parseInt(year) == THIS_YEAR){
            if(Integer.parseInt(month) == THIS_MONTH){
                if(Integer.parseInt(day) > THIS_DAY) return false;
                else return true;
            }else if(Integer.parseInt(month) < THIS_MONTH) return true;
            else return false;
        }
        return false;
    }

    public GoodsList() throws ParseException {
        Foods food1 = new Foods("1", "banana", 12, 50, "Vietnam", "05/05/2022", "05/05/2022");
        Foods food2 = new Foods("2", "hamburger", 22, 5, "Vietnam", "05/05/2022", "05/05/2022");
        Foods food3 = new Foods("3", "apple", 32, 60, "Vietnam", "05/05/2022", "05/05/2022");
        Electronics elec1 = new Electronics("4", "TV", 100, 10, 12, 500);
        Electronics elec2 = new Electronics("5", "Fridge", 145, 10, 12, 500);
        Ceramics cre1 = new Ceramics("6", "crenamic", 200, 5, "aa", "06/02/2022");
        Ceramics cre2 = new Ceramics("1234", "CHECKING CERAMIC", 200, 52, "VIE", "05/05/2022");
        Ceramics cre3 = new Ceramics("5678", "CHECKING CERAMIC 2", 200, 65, "VIE", "26/04/2022");

        goodsList.add(food1);
        goodsList.add(food2);
        goodsList.add(food3);
        goodsList.add(elec1);
        goodsList.add(elec2);
        goodsList.add(cre1);
        goodsList.add(cre2);
        goodsList.add(cre3);
    }

    public void addGoods() throws ParseException {
        Scanner kb = new Scanner(System.in);
        String choice;

        System.out.print("============= Add Goods =========== \n" +
                "Type of product ( 1.Food | 2.Electronic | 3.Ceramic )\n" +
                "Enter (1,2,3): ");
        choice = kb.nextLine();
        Goods newGoods = null;

        switch (choice) {
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

        String productionDate,
                expiredDate;
        boolean isProductionDateValid = true,
                isExpiredDateValid = true;
        /*
            check production date
         */
        do {
            if (!isProductionDateValid)
                System.out.println("Something went wrong! Please make sure the date you input is correct");

            System.out.print("Enter production date (dd/mm/yyyy).Default is today: ");
            productionDate = kb.nextLine();

            StringTokenizer tokens = new StringTokenizer(productionDate, "/");
            String day = String.valueOf(tokens.nextToken().toCharArray());
            String month = String.valueOf(tokens.nextToken().toCharArray());
            String year = String.valueOf(tokens.nextToken().toCharArray());

            if (isNumber(day) && isNumber(month) && isNumber(year)) { // if day - month - year are all number
                if (isDateValid(day, month, year) &&
                        isDateBeforeNow(day, month, year)) {
                    newFood.setProductionDate(productionDate);
                    isProductionDateValid = true;
                } else isProductionDateValid = false;
            } else isProductionDateValid = false;
        } while (!isProductionDateValid);

        do {
            if (!isExpiredDateValid)
                System.out.println("Something went wrong! Please make sure the date you input is correct");

            System.out.print("Enter expired date (dd/mm/yyyy).Default is today: ");
            expiredDate = kb.nextLine();

            StringTokenizer tokens = new StringTokenizer(expiredDate, "/");
            String day = String.valueOf(tokens.nextToken().toCharArray());
            String month = String.valueOf(tokens.nextToken().toCharArray());
            String year = String.valueOf(tokens.nextToken().toCharArray());

            if (isNumber(day) && isNumber(month) && isNumber(year)) { // if day - month - year are all number
                if (isDateValid(day, month, year) &&
                        !isDateBeforeNow(day, month, year)) { // expired date have to come after today
                    newFood.setExpiredDate(expiredDate);
                    isExpiredDateValid = true;
                } else isExpiredDateValid = false;
            } else isExpiredDateValid = false;
        } while (!isExpiredDateValid);

        return newFood;
    }

    public Goods createElectronic() {
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
        newCeramics.setManufacturer(new Scanner(System.in).nextLine());

        boolean dateValid = true; // set it to true to get rid of the if(!isDateValid) line below for the first time
        do {
            if (!dateValid)
                System.out.println("Something went wrong! Please make sure the date you input is correct");

            System.out.print("Enter imported date (dd/mm/yyyy): ");
            String importedDate = new Scanner(System.in).nextLine();

            StringTokenizer tokens = new StringTokenizer(importedDate, "/");
            String day = String.valueOf(tokens.nextToken().toCharArray());
            String month = String.valueOf(tokens.nextToken().toCharArray());
            String year = String.valueOf(tokens.nextToken().toCharArray());

            if (isNumber(day) && isNumber(month) && isNumber(year)) { // if day - month - year are all number
                if (isDateValid(day, month, year) &&
                        isDateBeforeNow(day, month, year)) {
                    newCeramics.setImportedDate(importedDate);
                    dateValid = true;
                } else dateValid = false;
            } else dateValid = false;
        } while (!dateValid);

        return newCeramics;
    }

    public void printAll() {
        for (Goods item : goodsList)
            System.out.println(item.toString() + "\n");
    }

    public void printSelective() {
        Scanner kb = new Scanner(System.in);

        System.out.print("=========== PRINT SELECTIVE ITEMS ==========\n" +
                "Enter type of goods to show: \n" +
                "1.Foods\n" +
                "2.Electronics\n" +
                "3.Ceramic\n" +
                "Your choice: ");

        String choice = kb.nextLine();
        if (choice.equals("1")) {
            for (Goods item : goodsList)
                if (item instanceof Foods) System.out.println(item);
        } else if (choice.equals("2")) {
            for (Goods item : goodsList)
                if (item instanceof Electronics) System.out.println(item);
        } else if (choice.equals("3")) {
            for (Goods item : goodsList)
                if (item instanceof Ceramics) System.out.println(item);
        } else System.out.println("Invalid input");
    }

    public Goods searchById() {
        Scanner kb = new Scanner(System.in);
        System.out.print("========== SEARCH BY ID ========== \n" +
                "Enter product's id to search: ");
        String idSearch = kb.nextLine();

        Goods foundItem = null;
        for (Goods item :
                goodsList) {
            if (item.getId().equals(idSearch)) {
                foundItem = item;
            }
        }

        return foundItem;
    }

    public void sortByName() {
        System.out.println("=========== SORT BY NAME =========");
        for (Goods item :
                goodsList) {
            System.out.println(item);
        }
    }

    public void sortByQuantity() {
        System.out.println("=========== SORT BY QUANTITY =========");
        TreeSet<Goods> listSortByQuantity = new TreeSet<>(new QuantityComparator());
        listSortByQuantity.addAll(goodsList);

        for (Goods item : listSortByQuantity) System.out.println(item);
    }

    public void deleteById() {
        System.out.println("=========== DELETE BY ID =========");
        Goods findItem = searchById();
        if (findItem == null) System.out.println("not found item");
        else {
            goodsList.remove(findItem);
            System.out.println("Item deleted");
        }
    }

    public void showHardSellingItem() {
        System.out.println("=========== HARD SELLING ITEMS =========");
        for (Goods item :
                goodsList) {
            if (item.checkSalesRate().equals("Hard to sell"))
                System.out.println(item);
        }
    }

    public void editPrice() {
        System.out.println("=========== EDIT PRICE BY ID =========");
        Goods itemEdited = searchById();
        if (itemEdited != null) {
            System.out.print("Enter the price to edit for the product: ");
            double newPrice = new Scanner(System.in).nextDouble();
            for (Goods item :
                    goodsList) {
                if (item.getId().equals(itemEdited.getId()))
                    item.setPrice(newPrice);
            }
        } else System.out.println("Item not FOUNDED");
    }

    public void start() throws ParseException {
        Scanner kb = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n" +
                    "=========== Menu ===========");
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
            switch (choice) {
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
                case 10 -> System.out.println("Exit! Thank you");
            }
        } while (choice < 10
                && choice > 0);
    }

}

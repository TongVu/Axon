package com.axonactive.programmingChallenges.Problem1_SmartPhoneManagement;

import java.util.*;

/**
 * This program can
 * 1.Add more phone to the list,
 * 2.Find phone via id
 * 3.Find phone in price range
 * 4.Order phone via price
 * 5.Show phone via manufacturer
 */

public class PhoneManager {
    private HashMap<String, SmartPhone> phonesList;

    public PhoneManager() { // This default constructor is used for easier testing
        phonesList = new HashMap<>();
        SmartPhone initialP1 = new SmartPhone("4131",  // phone 1
                "China",
                35,
                "25 Dec",
                "iPhone 7 max option"),
                initialP2 = new SmartPhone("4121", // phone 2
                        "Vie",
                        40,
                        "24 Arp",
                        "iPhone 8 max option"),
                initialP3 = new SmartPhone("3121", // phone 3
                        "Vie",
                        45,
                        "01 Jan",
                        "iPhone X max option"),
                initialP4 = new SmartPhone("1121", // phone 4
                        "Vie",
                        105,
                        "15 May",
                        "iPhone 12 max option");

        phonesList.put(initialP1.getId(), initialP1);
        phonesList.put(initialP2.getId(), initialP2);
        phonesList.put(initialP3.getId(), initialP3);
        phonesList.put(initialP4.getId(), initialP4);
    }

    public void addPhone() {
        String id,
                manufacturer,
                date,
                description;
        double price;
        Scanner input = new Scanner(System.in);

        System.out.println("\nADD PHONE ===========================");
        System.out.print("ID : ");
        id = input.nextLine();

        System.out.print("Manufacturer: ");
        manufacturer = input.nextLine();

        System.out.print("Price: "); // price should be postitive
        do {
            price = input.nextDouble();
            input.nextLine();
        } while (price < 0);

        System.out.print("Date: "); // Date should have format
        date = input.nextLine();

        System.out.print("Description: ");
        description = input.nextLine();

        SmartPhone newPhone = new SmartPhone(id,
                manufacturer,
                price,
                date,
                description);

        phonesList.put(newPhone.getId(), newPhone);
    }

    public void deletePhone() {
        Scanner input = new Scanner(System.in);
        String idToDelete;

        System.out.println("\nDELETE PHONE ===========================");
        System.out.print("Enter the id the delete smart phone: ");
        idToDelete = input.nextLine();

        //Delete phone through id
        if (phonesList.containsKey(idToDelete))
            phonesList.remove(idToDelete);
        else
            System.out.print("Phone id not founded");
    }

    public void viewPhones() {
        System.out.println("\nPHONE LIST ===========================");
        phonesList.forEach((k, v) -> {
            System.out.println();
            System.out.println(v.toString());
        });

    }

    public void sortByPrice() {
        System.out.println("\nPHONE LIST BY PRICE ===========================");
        TreeMap<String, SmartPhone> sortedPhonesList = new TreeMap<>(phonesList);
        sortedPhonesList.forEach((k, v) -> System.out.println(v.toString()));
    }

    public void searchPhone() {
        String id;
        Scanner input = new Scanner(System.in);

        System.out.println("\nSEARCH PHONE ===========================");
        System.out.print("ID: ");
        id = input.nextLine();

        // show phones
        if (phonesList.containsKey(id)) {
            System.out.println(phonesList.get(id).toString());
        } else System.out.println("NOT FOUNDED");

    }

    public void searchByPrice() {
        // show phones
        double min, max; // holds prices from usr input
        Scanner input = new Scanner(System.in);

        System.out.println("\nSEARCH IN RANGE ===========================");
        System.out.print("Min price that you're looking for: ");
        min = input.nextDouble();
        input.nextLine();

        System.out.print("Max price that you're looking for: ");
        max = input.nextDouble();

        phonesList.forEach((k, v) -> {
            if (v.getPrice() <= max &&
                    v.getPrice() >= min)
                System.out.println(v.toString());
        });
    }

    public void viewPhonesByManufacturer() {
        // Allow usr input name of manufacturers
        // show all phone have that manufacturers
        String usrManu; // holds manufacturer from usr input
        Scanner input = new Scanner(System.in);

        System.out.println("\nSEARCH MANUFACTURER ===========================");
        System.out.print("Enter Manufacturer: ");
        usrManu = input.nextLine();
        phonesList.forEach((k, v) -> {
            if (v.getManufacturer().equalsIgnoreCase(usrManu)) {
                System.out.println(v.toString());
            }
        });
    }

    public void start() {
        Scanner input = new Scanner(System.in);
        int usr; // holds usr choice
        do {
            System.out.println("MENU                         =====================|");
            System.out.println("1. Add smart phone            ====================|");
            System.out.println("2. Delete smart phone        =====================|");
            System.out.println("3. View the list of all the phones           =====|");
            System.out.println("4. Sort the list of smart phones by price    =====|");
            System.out.println("5. Seach smart phone by ID                   =====|");
            System.out.println("6. Search smart phone by min price and max price =|");
            System.out.println("7. List of smart phones by manufacturer ==========|");
            System.out.println("8. Exit");
            usr = input.nextInt();

            switch (usr) {
                case 1:
                    addPhone();
                    break;
                case 2:
                    deletePhone();
                    break;
                case 3:
                    viewPhones();
                    break;
                case 4:
                    sortByPrice();
                    break;
                case 5:
                    searchPhone();
                    break;
                case 6:
                    searchByPrice();
                    break;
                case 7:
                    viewPhonesByManufacturer();
                    break;
                default:
                    System.out.println("EXIT");
                    break;
            }
        } while (0 < usr && usr < 8);
    }
}

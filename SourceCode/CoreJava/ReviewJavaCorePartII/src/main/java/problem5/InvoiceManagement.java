package problem5;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class InvoiceManagement {
    private Set<Invoice> invoiceSet = new HashSet<>();
    private int count;

    public void menu() throws ExceededHoursException {
        int choice = 0;
        Scanner input = new Scanner(System.in);

        do{
            System.out.println("1. Add invoice");
            System.out.println("2. Show number of invoices");
            System.out.println("3. Show all hourly invoices");
            System.out.println("4. Show all daily invoices");
            System.out.println("5. Calculate total income");
            System.out.println("6. Exit");
            System.out.println("Choice: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice){
                case 1 -> add();
                case 2 -> System.out.println(numberOfInvoices());
                case 3 -> showAllHourlyInvoice();
                case 4 -> showAllDailyInvoice();
                default -> caclTotalIncome();
            }
        }while(choice > 0 && choice < 6);

        if(choice == 6) System.out.println("EXIT");
    }

    public boolean add() {
        int choice;
        Scanner input = new Scanner(System.in);

        do {
            System.out.print("Enter invoice's type \n" +
                    "1.Daily Invoice\n" +
                    "2.Hourly Invoice(hours have to be less than 30 hours)\n" +
                    "Choice: ");
            choice = input.nextInt();
            input.nextLine();
        } while (choice != 1 && choice != 2);

        int day, month, year;
        if (choice == 1) { // usr chose to create Daily Invoice
            DailyInvoice newDailyInvoice = new DailyInvoice();
            System.out.print("Enter id: ");
            newDailyInvoice.setId(input.nextLine());

            System.out.print("Enter customer name: ");
            newDailyInvoice.setCustomerName(input.nextLine());

            System.out.print("Enter room's id: ");
            newDailyInvoice.setRoomId(input.nextLine());

            System.out.print("Enter room's price: ");
            newDailyInvoice.setPrice(input.nextDouble());

            System.out.print("Enter rented days: ");
            newDailyInvoice.setRentedDays(input.nextInt());

            System.out.println("Input date ==============================");
            System.out.print("Enter day: ");
            day = input.nextInt();

            System.out.print("Enter month: ");
            month = input.nextInt();

            System.out.print("Enter year: ");
            year = input.nextInt();
            LocalDate dateRented = LocalDate.of(year, month, day);
            newDailyInvoice.setDate(dateRented);

            invoiceSet.add(newDailyInvoice);
            this.count++;
            return true;
        }

        if (choice == 2) { // usr chose to create Hourly Invoice
            HourlyInvoice newHourlyInvoice = new HourlyInvoice();
            System.out.print("Enter id: ");
            newHourlyInvoice.setId(input.nextLine());

            System.out.print("Enter customer name: ");
            newHourlyInvoice.setCustomerName(input.nextLine());

            System.out.print("Enter room's id: ");
            newHourlyInvoice.setRoomId(input.nextLine());

            System.out.print("Enter room's price: ");
            newHourlyInvoice.setPrice(input.nextDouble());

            int rentedHours = 0;
            do {
                System.out.print("Enter rented hours: ");
                rentedHours = input.nextInt();
                newHourlyInvoice.setRentedHours(rentedHours);
            } while (rentedHours >= 30);

            System.out.println("Input date ==============================");
            System.out.print("Enter day: ");
            day = input.nextInt();

            System.out.print("Enter month: ");
            month = input.nextInt();

            System.out.print("Enter year: ");
            year = input.nextInt();

            LocalDate dateRented = LocalDate.of(year, month, day);
            newHourlyInvoice.setDate(dateRented);

            invoiceSet.add(newHourlyInvoice);
            this.count++;
            return true;
        }
        return false;
    }

    public int numberOfInvoices() {
        return this.count;
    }

    public void showAllInvoices() {
        for (Invoice invoice : invoiceSet) {
            if (invoice instanceof DailyInvoice) {
                DailyInvoice tmp = (DailyInvoice) invoice;
                System.out.println("[ " + invoice.getId() + " " +
                        invoice.getDate() + " " +
                        invoice.getCustomerName() + " " +
                        invoice.getRoomId() + " " +
                        invoice.getPrice() + " " +
                        ((DailyInvoice) invoice).getRentedDays() + " ]");
            }
            if (invoice instanceof HourlyInvoice) {
                HourlyInvoice tmp = (HourlyInvoice) invoice;
                System.out.println("[ " +
                        invoice.getId() + " " +
                        invoice.getDate() + " " +
                        invoice.getCustomerName() + " " +
                        invoice.getRoomId() + " " +
                        invoice.getPrice() + " " +
                        ((HourlyInvoice) invoice).getRentedHours() + " ]");
            }
        }
    }

    public int showAllHourlyInvoice() {
        int count = 0;
        String tableFormat = "| %-11s | %-11s | %-15s | %-9.1s  | %-12d | %-12.1f |%n";

        System.out.format("+-------------+-------------+-----------------+------------+--------------+--------------+  %n");
        System.out.format("| ID          | Date        | CustomerName    | RoomId     | Rented Hours |    Total     |  %n");
        System.out.format("+-------------+-------------+-----------------+------------+--------------+--------------+  %n");

        for (Invoice invoice : invoiceSet) {
            if (invoice instanceof HourlyInvoice) {
                count++;
                System.out.format(tableFormat,
                        invoice.getId(),
                        invoice.getDate(),
                        invoice.getCustomerName(),
                        invoice.getRoomId(),
                        ((HourlyInvoice) invoice).getRentedHours(),
                        invoice.getPrice());
            }
        }
        System.out.format("+-------------+-------------+-----------------+------------+--------------+--------------+  %n");
        return count;
    }

    public int showAllDailyInvoice() {
        int count = 0;
        String tableFormat = "| %-11s | %-11s | %-15s | %-9.1s  | %-12d | %-12.1f |%n";

        System.out.format("+-------------+-------------+-----------------+------------+--------------+--------------+  %n");
        System.out.format("| ID          | Date        | CustomerName    | RoomId     | Rented Days  |    Total     |  %n");
        System.out.format("+-------------+-------------+-----------------+------------+--------------+--------------+  %n");

        for (Invoice invoice : invoiceSet) {
            if (invoice instanceof DailyInvoice) {
                count++;
                System.out.format(tableFormat,
                        invoice.getId(),
                        invoice.getDate(),
                        invoice.getCustomerName(),
                        invoice.getRoomId(),
                        ((DailyInvoice) invoice).getRentedDays(),
                        invoice.getPrice());
            }
        }
        System.out.format("+-------------+-------------+-----------------+------------+--------------+--------------+  %n");

        return count;
    }

    public double caclTotalIncome() throws ExceededHoursException {
        double total = 0.0d;

        for (Invoice invoice: invoiceSet ) {
            total+= invoice.total();
        }

        return total;
    }
}

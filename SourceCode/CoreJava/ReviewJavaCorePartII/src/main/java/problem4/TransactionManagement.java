package problem4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TransactionManagement {
    public static void main(String[] args) {
        List<Transaction> transactionList = new ArrayList<>();
        MonetaryTransaction monTrans1, monTrans2, monTrans3;
        GoldTransaction goldTrans1, goldTrans2, goldTrans3;

        monTrans1 = MonetaryTransaction.builder()
                .id("1234")
                .transactionalDate(LocalDate.of(2021, 4, 20))
                .price(2000)
                .quantity(10)
                .unitPrice(23000)
                .type("USD")
                .build();
        transactionList.add(monTrans1);

        monTrans2 = MonetaryTransaction.builder()
                .id("1235")
                .transactionalDate(LocalDate.of(2021, 6, 24))
                .price(2600)
                .quantity(15)
                .unitPrice(27000)
                .type("Euro")
                .build();
        transactionList.add(monTrans2);

        monTrans3 = MonetaryTransaction.builder()
                .id("9584")
                .transactionalDate(LocalDate.of(2021, 12, 30))
                .price(25000000)
                .quantity(100)
                .unitPrice(1)
                .type("VN")
                .build();
        transactionList.add(monTrans3);

        goldTrans1 = GoldTransaction.builder()
                .id("8501")
                .transactionalDate(LocalDate.of(2021, 8, 8))
                .price(5000)
                .quantity(50)
                .type("Rose Gold")
                .build();
        transactionList.add(goldTrans1);

        goldTrans2 = GoldTransaction.builder()
                .id("9150")
                .transactionalDate(LocalDate.of(2021, 7, 24))
                .price(25000)
                .quantity(100)
                .type("Rose Gold")
                .build();
        transactionList.add(goldTrans2);

        goldTrans3 = GoldTransaction.builder()
                .id("1958")
                .transactionalDate(LocalDate.of(2021, 2, 14))
                .price(3000)
                .quantity(300)
                .type("Fine Gold")
                .build();
        transactionList.add(goldTrans3);

        System.out.println("TOTAL TRANSACTION OF EACH TYPE =================================================");
        int totalQuantityOfGoldTransaction = 0;
        int totalQuantityOfMonetaryTransaction = 0;
        for (Transaction transaction : transactionList) {
            if (transaction instanceof GoldTransaction)
                totalQuantityOfGoldTransaction += transaction.getQuantity();
            if (transaction instanceof MonetaryTransaction)
                totalQuantityOfMonetaryTransaction += transaction.getQuantity();
        }

        System.out.println("Total quantity of Gold Transaction: " + totalQuantityOfGoldTransaction + "\n" +
                "Total quantity of Monetary Trasaction: " + totalQuantityOfMonetaryTransaction);


        System.out.println("AVG EXCHANGE OF MONETARY TRANSACTION =================================================");
        int totalMonetaryTransactions = 0;
        double totalMonetaryExchange = 0;
        for (Transaction transaction : transactionList) {
            if (transaction instanceof MonetaryTransaction) {
                totalMonetaryTransactions++;
                totalMonetaryExchange += transaction.totalExchange();
            }
        }
        System.out.println("Average of monetary transaction: " + totalMonetaryExchange / totalMonetaryTransactions);

        System.out.println("SHOW EXCHANGES LARGER THAN 1 BILLION =================================================");
        for (Transaction transaction : transactionList)
            if (transaction.totalExchange() > 1000000000)
                System.out.println(transaction);
    }
}

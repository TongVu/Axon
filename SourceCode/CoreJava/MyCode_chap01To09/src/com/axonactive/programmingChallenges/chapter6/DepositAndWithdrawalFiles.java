package com.axonactive.programmingChallenges.chapter6;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DepositAndWithdrawalFiles {
    public static void main(String[] args) throws IOException {
        //Because these class are in the same folder so we can call SavingsAcount class without importing it
        SavingsAccount customerAccount;
        customerAccount = new SavingsAccount(500.00);


        // Create a deposits file object to read
        File depositsFile = new File("Deposits.txt");
        Scanner depositsFileToRead = new Scanner(depositsFile);

        // Create a withdrawal file object to read
        File withdrawalFile = new File("Withdrawals.txt");
        Scanner withdrawnFileToRead = new Scanner(withdrawalFile);

        double totalInterest = 0.0d,
                monthlyInterst;

        //Initialize annual interest rate in percent
        customerAccount.setAnnualInterestRate(20.0);

        while (depositsFileToRead.hasNext() && withdrawnFileToRead.hasNext()) {
            String strDeposits = depositsFileToRead.nextLine();
            double actualDeposits = Double.valueOf(strDeposits);

            String strWithdrawal = withdrawnFileToRead.nextLine();
            double actualWithdrawal = Double.valueOf(strWithdrawal);

            customerAccount.addDeposit(actualDeposits);
            customerAccount.subtractWithdrawal(actualWithdrawal);

            monthlyInterst = customerAccount.showInterest();
            totalInterest += monthlyInterst;
            System.out.printf("Monthly interest: %.4f\n", monthlyInterst);
        }

        System.out.printf("Total interest earned: $%.4f\n", totalInterest);
        System.out.printf("Balance : $%.4f", customerAccount.getBalance());

    }
}

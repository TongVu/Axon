package com.axonactive.programmingChallenges.chapter6;

import java.util.Scanner;

public class SavingsAccount {
    private double annualInterestRate;
    private double balance;

    public SavingsAccount(double startingBalance) {
        balance = startingBalance;
    }

    public void setAnnualInterestRate(double annualInterestRateInput) {
        annualInterestRate = annualInterestRateInput;
    }

    public double getBalance() {
        return balance;
    }

    public boolean subtractWithdrawal(double withdrawnMoney) {
        if ((balance - withdrawnMoney) >= 0) {
            balance = balance - withdrawnMoney;
            return true;
        } else {
            return false;
        }
    }

    public void addDeposit(double deposit) {
        balance += deposit;
    }

    // Monthly interest rate = annual interest rate / 12; remember that interest rate in percent
    // Monthly interest = monthly interest rate * balance
    // newBalance = balance + monthly interest rate * balance
    public double showInterest() {
        return (annualInterestRate / 12) * 0.01 * balance;
    }

    public void addMonthlyInterestToBalance() {
        balance = balance + (annualInterestRate / 12) * 0.01 * balance;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double annualInterestRate,
                startingBalance,
                monthsSinceAccountEstablished;

        System.out.print("Enter the annual interest rate: ");
        annualInterestRate = input.nextDouble();

        System.out.print("Enter the starting balance: ");
        startingBalance = input.nextDouble();

        // Create a customer account with a balance and interest rate
        SavingsAccount customerAccount = new SavingsAccount(startingBalance);
        customerAccount.setAnnualInterestRate(annualInterestRate);

        System.out.print("How long has the account been established? (in month): ");
        monthsSinceAccountEstablished = input.nextDouble();

        double deposit, totalDeposit = 0.0d,
                withdrawnMoney, totalWithdrawal = 0.0d,
                totalInterestEarned = 0.0d;

        for (int i = 1; i <= monthsSinceAccountEstablished; i++) {
            System.out.print("Month " + i + " enter the amount deposited into the account: ");
            deposit = input.nextDouble();
            // use class method to add this amount to the balance
            customerAccount.addDeposit(deposit);
            totalDeposit += deposit;

            System.out.print("Month " + i + " enter the amount withdrawn from the account: ");
            withdrawnMoney = input.nextDouble();
            if (customerAccount.subtractWithdrawal(withdrawnMoney)) {
                // use class method to subtract this amount from the balance
                totalWithdrawal += withdrawnMoney;
            } else {
                System.out.println("The balance is not enough for your money withdrawal.");
            }
            // use class method to calculate the monthly interest
            // calculate monthly interest also means the balance is added the interest into it monthly
            totalInterestEarned += customerAccount.showInterest();
            customerAccount.addMonthlyInterestToBalance();
            System.out.println("\n===========================================================\n");
        }

        /*
        display ending balance,
        total amount of deposits,
        total amount of withdrawals,
        total interest earned
         */
        System.out.println("Current balance: $" + customerAccount.getBalance());
        System.out.println("Total deposits during " + monthsSinceAccountEstablished + " months: $" + totalDeposit);
        System.out.println("Total withdrawal during " + monthsSinceAccountEstablished + " months: $" + totalWithdrawal);
        System.out.println("Total interest earned: $" + totalInterestEarned);

    }
}

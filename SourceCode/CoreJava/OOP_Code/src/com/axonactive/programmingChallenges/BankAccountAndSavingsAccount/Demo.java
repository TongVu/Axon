package com.axonactive.programmingChallenges.BankAccountAndSavingsAccount;

public class Demo {
    public static void main(String[] args) {
        SavingsAccount account = new SavingsAccount(29, 10); // initial balance is 29$

        System.out.println(account.getStatus()); // check if account is active

        account.withdraw(1);
        account.withdraw(1);
        account.withdraw(1);
        account.withdraw(1);
        account.withdraw(1); // 5 times withdraw, check if the status is inactive
        System.out.println(account.getStatus());
        System.out.println(account.getBalance()); // check the current balance


        account.deposit(5);
        System.out.println(account.getBalance()); // check the current balance
        System.out.println(account.getStatus());
        account.withdraw(1);
        account.withdraw(1);
        account.withdraw(1); // total number withdraws is 8 which means the account lost more 4$
        account.monthlyProcess();
        System.out.println(account.getBalance()); // check the current balance
    }
}

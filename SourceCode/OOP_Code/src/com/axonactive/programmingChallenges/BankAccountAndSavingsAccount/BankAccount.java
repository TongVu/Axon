package com.axonactive.programmingChallenges.BankAccountAndSavingsAccount;

/**
 * This abstract class demonstrate the Bank Account
 */

public abstract class BankAccount {
    private double balance;
    private int nDeposits; // nDeposits holds the number of deposits this month
    private int nWithdrawals; // nWithdrawls holds the number of withdrawals this month
    private double monthlySerCharge; // monthly service charge
    private double insRate; // insRate holds the annual interest rate


    /**
     * Default constructor set all fields to zero
     */
    public BankAccount() {
        this.balance = 0;
        this.nDeposits = 0;
        this.nWithdrawals = 0;
        this.monthlySerCharge = 0;
        this.insRate = 0;
    }

    /**
     * Constructor with the balance and insRate as arguments
     * Set the balance argument in the field to balance,
     * Set the insRate argument int the filds to insRate param
     * Set others fields to zero
     */
    public BankAccount(double balance, double insRate) {
        this.balance = balance;
        this.nDeposits = 0;
        this.nWithdrawals = 0;
        this.monthlySerCharge = 0;
        this.insRate = insRate;
    }

    /**
     * getBlance methods
     *
     * @return balance value
     */
    public double getBalance() {
        return balance;
    }

    /**
     * setBalance() set the balance in the account
     * account's balance have to larger than 0
     *
     * @param balance is the balance used to set for the account's balance
     */
    public void setBalance(double balance) {
        if (balance < 0)
            throw new IllegalArgumentException("Balance have to larger than 0");
        this.balance = balance;
    }

    /**
     * getnDeposits() get the number of deposits in the month
     *
     * @return the number of deposits of the month
     */
    public int getnDeposits() {
        return nDeposits;
    }

    /**
     * setnDeposits() set the number of deposits in the month
     * The number of times we deposit money have to larger than 0
     *
     * @param nDeposits
     */
    public void setnDeposits(int nDeposits) {
        if (nDeposits < 0) throw new IllegalArgumentException("Have to be positive");
        this.nDeposits = nDeposits;
    }

    /**
     * getnWithdrawals get the number of withdrawals in the month
     *
     * @return nWithdrawals
     */
    public int getnWithdrawals() {
        return nWithdrawals;
    }

    /**
     * setnWithdrawals set the number withdrawals in the month
     * the number withdrawals in a month have to larger than or equal 0
     *
     * @param nWithdrawals
     */
    public void setnWithdrawals(int nWithdrawals) {
        if (nWithdrawals < 0) throw new IllegalArgumentException("Have to be positive");
        this.nWithdrawals = nWithdrawals;
    }

    /**
     * getMonthlySerCharge() get the service charge of the month
     *
     * @return monthlySerCharge
     */
    public double getMonthlySerCharge() {
        return monthlySerCharge;
    }

    /**
     * setMonthlySerCharge sets the service charge of the month
     *
     * @param monthlySerCharge
     */
    public void setMonthlySerCharge(double monthlySerCharge) {
        this.monthlySerCharge = monthlySerCharge;
    }

    /**
     * deposit() methods that add the deposit to the balance,
     * increase the number of deposits of the month
     *
     * @param deposit
     */
    public void deposit(double deposit) {
        if (deposit <= 0) throw new IllegalArgumentException("Deposit have to be larger than zero");
        else {
            setBalance(getBalance() + deposit);
            setnDeposits(getnDeposits() + 1);
        }
    }

    /**
     * This method take substract the balance in the account
     * If the withrawalsAmount smaller than the balance then it's illegal
     * If the method proceeded successfully, the number of withdrawals increase by 1
     *
     * @param withdrawalsAmount
     */
    public void withdrawal(double withdrawalsAmount) {
        if (withdrawalsAmount > getBalance()) throw new IllegalArgumentException("Not enough money in the account");
        else {
            setnWithdrawals(getnWithdrawals() + 1);
            setBalance(getBalance() - withdrawalsAmount);
        }
    }

    /**
     * This method update the balance by calculating monthly interest rate earned by the account
     * then add the interest to the balance.<br/ >
     * Monthly interest rate = annual Interest rate / 12 <br/ >
     * Monthly interest = balance * monthly interest rate <br/ >
     * New balance = current balance + monthly interest
     */
    public void calcInterest() {
        double monthlyInsRate = insRate / 12; // monthlyInsRate is the monthly interest rate, insRate is the annual interest rate
        double monthlyIns = getBalance() * monthlyInsRate; // monthlyIns is monthly interest
        setBalance(getBalance() + monthlyIns); // update balance
    }

    /**
     * This method subtract the monthly service charge from the account's balance.
     * <p>
     * Call the calcInterest to update the balance <br/>
     * Finally, update the number of withdrawals, number of deposits and service charge to zero
     * </p>
     */
    public void monthlyProcess(){
        setBalance(getBalance() - monthlySerCharge); // monthlySerCharge is the monthly service charge
        calcInterest(); // update new balance after subtract the service charge
        setnDeposits(0); // update the number of deposits to zero
        setnWithdrawals(0); //update the number of withdrawals to zero
        setMonthlySerCharge(0);//update the monthly service charge to zero
    }

}

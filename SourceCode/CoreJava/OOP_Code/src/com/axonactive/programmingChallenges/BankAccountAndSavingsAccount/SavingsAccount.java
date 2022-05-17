package com.axonactive.programmingChallenges.BankAccountAndSavingsAccount;

public class SavingsAccount extends BankAccount {
    private boolean status = true;

    public SavingsAccount(double balance, double insterestRate) {
        super(balance, insterestRate);
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus() {
        if (getBalance() < 25) {
            this.status = false; // inactive
        } else this.status = true; // active if balance larger than 25$
    }

    public void withdraw(double money) { // money is the amount of money to withdraw
        if (getStatus() == false) throw new RuntimeException("The account is enough to proceed this operation");
        else {
            setBalance(getBalance() - money); // new balance = current balance subtract the withdrawal
            setStatus(); // check the balance if < 25$ then the status become inactive
        }
    }

    @Override
    public void deposit(double money) { // money is the amount of money to deposit
        setBalance(getBalance() + money); // update the balance
        setStatus(); // if status is false, and the balance after deposit is > 25 then change the status to true
    }

    @Override
    public void monthlyProcess(){
        if(getnWithdrawals() > 4){
            int nAdditionalWithdraw = getnWithdrawals() - 4;
            for (int i = 0; i < nAdditionalWithdraw; i++) {
                setMonthlySerCharge(getMonthlySerCharge() + 1);// +1$ to service charge for every withdrawal
            }

            // check balance after update it by subtract the total service charge
            if(getBalance() - getMonthlySerCharge() < 25) this.status = false; // if balance < 25 then status is inactive
        }
        super.monthlyProcess();
    }
}

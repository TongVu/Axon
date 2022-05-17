package com.axonactive.programmingChallenges.PersonAndCustomer;

public class Customer extends Person{
    private String customerNumber;
    private boolean onMailList; // this field indicates whether the customer wishes to be on a mailing list;

    public Customer(){
    }

    public Customer(String customerNumber){
        this.customerNumber = customerNumber;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public boolean isOnMailList() {
        return onMailList;
    }

    public void setOnMailList(boolean onMailList) {
        this.onMailList = onMailList;
    }

    public void showInfo(){
        System.out.println("Your Info ========================");
        System.out.println("Customer number: " + getCustomerNumber());
        System.out.println("Name: " + super.getName());
        System.out.println("Address: " + super.getAddress());
        System.out.println("Phone number: " + super.getPhoneNumber());
        System.out.println("On mail list: " + isOnMailList());
    }
}

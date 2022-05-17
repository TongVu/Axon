package com.axonactive.programmingChallenges.PersonAndCustomer;

public class PersonAndCustomerDemo {
    public static void main(String[] args) {
        Customer vip = new Customer("AXON-AAA");

        vip.setName("Tong");
        vip.setAddress("Ho Chi Minh city");
        vip.setPhoneNumber("091.xxx.7777");
        vip.setOnMailList(false);

        vip.showInfo();

    }
}

package com.axonactive.programmingChallenges.chapter6;

public class PersonalInformation {
    private String name;
    private String address;
    private int age;
    private String phoneNumber;

    public PersonalInformation(){}
    public PersonalInformation(String personName, String personalAddress, int personAge, String personPhoneNumb) {
        name = personName;
        address = personalAddress;
        age = personAge;
        phoneNumber = personPhoneNumb;
    }

    public void setName(String personName) {
        name = personName;
    }

    public void setAddress(String personalAddress) {
        address = personalAddress;
    }

    public void setAge(int personAge) {
        age = personAge;
    }

    public void setPhoneNumber(String personPhone) {
        phoneNumber = personPhone;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static void main(String[] args) {
        PersonalInformation tongVu, friend1, friend2;
        tongVu = new PersonalInformation("Tong Vu", "Ho Chi Minh city", 27, "0934.xxx.813");

        friend1 = new PersonalInformation();
        friend1.setName("Huu Phuoc");
        friend1.setAddress("Ho Chi Minh city");
        friend1.setAge(26);
        friend1.setPhoneNumber("xxx.252.777");

        friend2 = new PersonalInformation("Hoai Linh", "Da Nang", 44, "0909.777.777");

        System.out.println("Person 1: ");
        System.out.println(tongVu.getName());
        System.out.println(tongVu.getAddress());
        System.out.println(tongVu.getAge());
        System.out.println(tongVu.getPhoneNumber());


        System.out.println("Person 2: ");
        System.out.println(friend1.getName());
        System.out.println(friend1.getAddress());
        System.out.println(friend1.getAge());
        System.out.println(friend1.getPhoneNumber());

        System.out.println("Person 3: ");
        System.out.println(friend2.getName());
        System.out.println(friend2.getAddress());
        System.out.println(friend2.getAge());
        System.out.println(friend2.getPhoneNumber());
    }
}

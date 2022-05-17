package com.axonactive.programmingChallenges.chapter6;

public class PatientCharges {
    public static void main(String[] args) {
        Patient person1 = new Patient("Phuoc", "Huu", "Ho");
        person1.setAddress("Wonder Land");
        person1.setCity("Ho Chi Minh");
        person1.setState("Tan Binh");
        person1.setZip("7000");
        person1.setPhoneNumb("090.3333.666");
        person1.setNameInEmergency("Someone else");
        person1.setPhoneInEmergency("090.444.777");

        Procedure procedure1 = new Procedure("Physical Exam", "Today's date"),
        procedure2 = new Procedure("X-ray", "Today's date"),
        procedure3 = new Procedure("Blood test", "Today's date");

        procedure1.setPractioner("Dr. Irvine");
        procedure1.setCharge(250.00);

        procedure2.setPractioner("Jamison");
        procedure2.setCharge(500.00);

        procedure3.setPractioner("Dr. Smith");
        procedure3.setCharge(200.00);

        double totalCharge = procedure1.getCharge() + procedure2.getCharge() + procedure3.getCharge();

        System.out.println("=============== PATIENT'S INFORMATION ===============");
        System.out.printf("Full name: %s %s %s\n" , person1.getFirstName() , person1.getMiddleName() , person1.getLastName());
        System.out.printf("Location: %s - %s - %s -%s\n",person1.getAddress(), person1.getCity() , person1.getState() , person1.getZip());
        System.out.printf("Phone: %s\n", person1.getPhoneNumb());
        System.out.printf("Name and phone number of emergency contact: %s - %s\n", person1.getNameInEmergency(), person1.getPhoneInEmergency());

        System.out.println("\n=============== PROCEDURE 1 ===============");
        System.out.printf("Procedure name: %s\n" , procedure1.getProcedureName());
        System.out.printf("Date: %s\n" , procedure1.getDatePerform());
        System.out.printf("Practitioner: %s\n" , procedure1.getPractioner());
        System.out.printf("Charge: %s\n" , procedure1.getCharge());

        System.out.println("\n=============== PROCEDURE 2 ===============");
        System.out.printf("Procedure name: %s\n" , procedure2.getProcedureName());
        System.out.printf("Date: %s\n" , procedure2.getDatePerform());
        System.out.printf("Practitioner: %s\n" , procedure2.getPractioner());
        System.out.printf("Charge: %s\n" , procedure2.getCharge());

        System.out.println("\n=============== PROCEDURE 3 ===============");
        System.out.printf("Procedure name: %s\n" , procedure3.getProcedureName());
        System.out.printf("Date: %s\n" , procedure3.getDatePerform());
        System.out.printf("Practitioner: %s\n" , procedure3.getPractioner());
        System.out.printf("Charge: %s\n" , procedure3.getCharge());

        System.out.printf("\nTotal charge: %.4f", totalCharge);
    }
}

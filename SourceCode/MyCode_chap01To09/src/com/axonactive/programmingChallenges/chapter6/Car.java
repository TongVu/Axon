package com.axonactive.programmingChallenges.chapter6;

public class Car {
    private int yearModel;
    private String make;
    private int speed;

   public Car(int carYearModel, String makeOfTheCar){
       yearModel = carYearModel;
       make = makeOfTheCar;
       speed = 0;
   }

   public int getYearModel(){
       return yearModel;
   }

    public String getMake(){
        return make;
    }

    public int getSpeed(){
        return speed;
    }

    public int accelerate(){
       return speed = getSpeed() + 5;
    }
    public int brake(){
       return speed = getSpeed() - 5;
    }

    public static void main(String[] args) {
       Car ferrari = new Car(2021, "Carbon");

        System.out.println("====== Accelerate ======");
       for(int i = 0; i < 5; i++ ){
           ferrari.accelerate();
           System.out.println("The current speed is: " + ferrari.getSpeed() + " mph.");
       }

        System.out.println("====== Brake ======");
        for(int i = 0; i < 5; i++ ){
            ferrari.brake();
            System.out.println("The current speed is: " + ferrari.getSpeed() + " mph.");
        }
    }
}

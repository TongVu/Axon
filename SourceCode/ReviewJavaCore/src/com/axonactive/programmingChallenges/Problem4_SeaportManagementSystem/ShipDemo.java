package com.axonactive.programmingChallenges.Problem4_SeaportManagementSystem;

public class ShipDemo {
    public static void main(String[] args) {
        Ship[] shipsList = new Ship[5];
        shipsList[0] = new Ship("Aria", "1973");
        shipsList[1] = new CruiseShip("Oasis of the Seas", 5400);
        shipsList[2] = new CruiseShip("Mardi Gras", 6500);
        shipsList[3] = new CargoShip("OOCL Hong Kong", 21_413); //TEU: Twenty Equipment Unit
        shipsList[4] = new CargoShip("Madrid Maersk", 20_568);

        for (Ship ship :
                shipsList) {
            System.out.println(ship.toString());
        }
    }
}

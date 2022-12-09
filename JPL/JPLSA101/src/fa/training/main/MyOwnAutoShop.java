package fa.training.main;

import fa.training.entities.Ford;
import fa.training.entities.Sedan;
import fa.training.entities.Truck;

public class MyOwnAutoShop {
    public static void main(String[] args) {
        Sedan sedan = new Sedan();
        sedan.setSpeed(20);
        sedan.setRegularPrice(200.0);
        sedan.setColor("Red");
        sedan.setLength(50);
        System.out.println(sedan.toString());
        Ford ford = new Ford(30, 500.0, "Blue", 2019, 20);
        Ford ford1 = new Ford(50, 550.0, "Green", 2020, 50);
        System.out.println(ford.toString());
        System.out.println(ford1.toString());
        Truck truck = new Truck(100, 800.0, "Yellow", 500);
        Truck truck1 = new Truck(150, 700.0, "Pink", 800);
        System.out.println(truck);
        System.out.println(truck1);

    }
}

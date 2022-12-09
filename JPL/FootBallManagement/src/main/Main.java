package main;

import services.PitchService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        PitchService pitchService = new PitchService();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("1. Insert DB: ");
            System.out.println("2. List: ");
            System.out.println("3. Update Price: ");
            System.out.println("4. Delete Customer: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    pitchService.readPitchIntoDB();
                    break;
                case 2:
                    pitchService.listCustomer();

                    break;
                case 3:
                    pitchService.updateCost();
                    break;
                case 4:
                    pitchService.deleteCustomer();
                    break;
                default:
                    break;
            }

        } while (choice < 4);
    }
}

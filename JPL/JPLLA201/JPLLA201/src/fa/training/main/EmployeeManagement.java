package fa.training.main;

import fa.training.entities.AirPorts;
import fa.training.entities.Fixedwing;
import fa.training.entities.Helicopters;
import fa.training.services.AirPortsService;
import fa.training.utils.Validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManagement {

    static Scanner scanner = new Scanner(System.in);
    static AirPortsService airPortsService = new AirPortsService();
    static Validation validation = new Validation();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int choice;
        do {
            System.out.println();
            System.out.println("====== AIRPORT MANAGEMENT SYSTEM ======");
            System.out.println("1. Create Airport: ");
            System.out.println("2. Add Fixedwing into airport: ");
            System.out.println("3. Remove Fixedwing: ");
            System.out.println("4. Add Helicopters into airport: ");
            System.out.println("5. Remove Helicopters");
            System.out.println("6. Change plane type and min runway size: ");
            System.out.print("Please choose function you'd like to do: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addAirPort();
                    break;
                case 2:
                    addFixedwing();
                    break;
                case 3:
                    removeFixedwing();
                    break;
                case 4:
                    addHelicopters();
                    break;
                case 5:
                    removeHelicopters();
                    break;
                case 6:
                    updateFixedwing();
                    break;
                default:
                    break;
            }

        } while (choice != 7);


    }

    private static void updateFixedwing() {
        System.out.println("Enter ID: ");
        String id = scanner.nextLine();
        System.out.println("Enter plane type: ");
        String planeType = scanner.nextLine();
        System.out.println("Enter min runway size: ");
        double minRunway =scanner.nextDouble();
        airPortsService.updatefix(id,planeType, minRunway);

    }

    private static void removeHelicopters() {
    }

    private static void addHelicopters() {
        System.out.println("Enter ID: ");
        String id = String.valueOf(validation.checkID());
        System.out.println("Enter Model: ");
        String model = String.valueOf(validation.checkModel());
        System.out.println("Enter Cruise Speed: ");
        double cruiseSpeed = scanner.nextDouble();
        System.out.println("Enter Empty Weight: ");
        double emptyWeight = scanner.nextDouble();
        System.out.println("Enter Max Weight: ");
        double maxWeight = scanner.nextDouble();
        System.out.println("Enter Range: ");
        double range = scanner.nextDouble();

        Helicopters helicopters = new Helicopters(id, model, cruiseSpeed, emptyWeight, maxWeight, range);
        List<Helicopters> helicoptersList = new ArrayList<>();
        helicoptersList.add(helicopters);
        System.out.println("Enter ID Airport: ");
        String idAir = scanner.nextLine();
        airPortsService.addHelicopters(idAir, helicoptersList);
    }

    private static void addFixedwing() {
        scanner.nextLine();
        System.out.println("Enter ID: ");
        String id = String.valueOf(validation.checkID());
        System.out.println("Enter model: ");
        String model = String.valueOf(validation.checkModel());
        System.out.println("Enter plane type: ");
        String planeType = String.valueOf(validation.checkType());
        System.out.println("Enter cruise speed: ");
        int cruise = scanner.nextInt();
        System.out.println("Enter empty weight: ");
        double emtyWeight = scanner.nextDouble();
        System.out.println("Enter max take off weight: ");
        double maxTakeOffWeight =scanner.nextDouble();
        System.out.println("Enter min runway size: ");
        double minRunwaySize = scanner.nextDouble();

        Fixedwing fixedwing = new Fixedwing(id, model, planeType, cruise, emtyWeight, maxTakeOffWeight, minRunwaySize);
        List<Fixedwing> fixedwingList = new ArrayList<>();
        fixedwingList.add(fixedwing);
        scanner.nextLine();
        System.out.println("Enter id airport: ");
        String idAir = scanner.nextLine();
        airPortsService.updateFixedwing(idAir, fixedwingList);
    }

    private static void removeFixedwing() {
        System.out.println("Enter ID fixedwing: ");
        String fixedwing = scanner.nextLine();
        airPortsService.removeFixedwing(fixedwing);
    }

    private static void addAirPort() {
        scanner.nextLine();
        System.out.println("Enter ID: ");
        String id = scanner.nextLine();
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter runway size: ");
        double runwaySize = scanner.nextDouble();
        System.out.println("Enter max fixed wing: ");
        double maxFixed = scanner.nextDouble();
        System.out.println("Enter max rotated wing: ");
        double maxRotated = scanner.nextDouble();

        AirPorts ai = new AirPorts(id, name, runwaySize, maxFixed, maxRotated);
        airPortsService.add(ai);
        System.out.println(ai.toString());
    }
}

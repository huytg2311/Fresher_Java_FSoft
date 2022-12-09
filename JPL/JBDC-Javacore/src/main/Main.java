package main;

import service.CustomerService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();
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
                    customerService.readCustomerIntoDB();
                    break;
                case 2:
                    customerService.voidListCustomer();
                    break;
                case 3:
                    customerService.updateTicketPrice();
                    break;
                case 4:
                    customerService.deleteCustomer();
                    break;
                default:
                    break;
            }

        } while (choice < 4);
    }
}

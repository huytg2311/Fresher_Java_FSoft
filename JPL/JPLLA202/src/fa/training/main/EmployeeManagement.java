package fa.training.main;

import fa.training.entities.HourlyEmployee;
import fa.training.entities.SalariedEmployee;
import fa.training.services.EmployeeService;
import fa.training.utils.Validation;

import java.time.LocalDate;
import java.util.Scanner;

public class EmployeeManagement {

     Scanner scanner = new Scanner(System.in);
     EmployeeService employeeService = new EmployeeService();
     Validation validation = new Validation();
     SalariedEmployee salariedEmployee = new SalariedEmployee();
     HourlyEmployee hourlyEmployee = new HourlyEmployee();

    public static void main(String[] args) throws Exception {
        EmployeeManagement employeeManagement = new EmployeeManagement();
        employeeManagement.menu();
    }

    public void menu() throws Exception {

        int choose;
        do {
            System.out.println("==== EMPLOYEE MANAGEMENT SYSTEM ====" + "\n" +
                    "1. Add an employee" + "\n" +
                    "2. Display employees" + "\n" +
                    "3. Classify employees" + "\n" +
                    "4. Search book by (department, emp's name)" + "\n" +
                    "Please choose function you'd like to do: ");
            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    displayEmployees();
                    break;
                case 3:
                    classifyEmployees();
                    break;
                case 4:
                    searchBook();
                    break;
            }
        } while (choose < 5);
    }

    private void searchBook() {
        scanner.nextLine();
        System.out.println("1. Search Department: ");
        System.out.println("2. Search name employee: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter name department: ");
                scanner.nextLine();
                String department = scanner.nextLine();
                employeeService.searchDepartment(department);
                break;
            case 2:
                System.out.println("Enter name employee: ");
                scanner.nextLine();
                String name = scanner.nextLine();
                employeeService.searchName(name);
                break;
        }

    }

    private void classifyEmployees() {
        employeeService.listHourlyEmployee();
        employeeService.listSalariedEmployee();
    }

    private void displayEmployees() {
        employeeService.listEmployee();
    }

    private void addEmployee() throws Exception {
        System.out.println("1. Salaried Employee");
        System.out.println("2. Hourly Employee");
        System.out.println("Choose: ");
        int choose = scanner.nextInt();
        if (choose == 1) {
            System.out.println("Enter ssn: ");
            String ssn = scanner.nextLine();
            scanner.nextLine();
            System.out.println("Enter first name: ");
            String firstName = scanner.nextLine();
            System.out.println("Enter last name: ");
            String lastName = scanner.nextLine();

                System.out.println("Enter birthdate: ");
                String birthdate = String.valueOf(validation.checkBirthdate());

            System.out.println("Enter phone: ");
            String phone = validation.checkPhone();
            System.out.println("Enter email: ");
            String email = validation.inputEmail();
            System.out.println("Enter commission rate: ");
            double cr = scanner.nextDouble();
            System.out.println("Enter gross sales: ");
            double gs = scanner.nextDouble();
            System.out.println("Enter basic salary: ");
            double bs = scanner.nextDouble();

            salariedEmployee = new SalariedEmployee(ssn, firstName, lastName, LocalDate.parse(birthdate), phone, email, cr, gs, bs);
            employeeService.addSalariedEmployee(salariedEmployee);
        } else if (choose == 2) {
            System.out.println("Enter ssn: ");
            String ssn = scanner.nextLine();
            System.out.println("Enter first name: ");
            String firstName = scanner.nextLine();
            System.out.println("Enter last name: ");
            String lastName = scanner.nextLine();
            System.out.println("Enter birthday: ");
            String birthday = String.valueOf(validation.checkBirthdate());
            System.out.println("Enter phone: ");
            String phone = validation.checkPhone();
            System.out.println("Enter email: ");
            String email = validation.inputEmail();
            System.out.println("Enter wage: ");
            double wage = scanner.nextDouble();
            System.out.println("Enter workingHOurs: ");
            double workingHours = scanner.nextDouble();

            hourlyEmployee = new HourlyEmployee(ssn, firstName, lastName, LocalDate.parse(birthday), phone, email, wage, workingHours);
            employeeService.addHourlyEmployee(hourlyEmployee);
        }

    }


}

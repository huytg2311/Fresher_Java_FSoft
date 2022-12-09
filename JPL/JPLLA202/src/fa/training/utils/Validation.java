package fa.training.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Validation {

    Scanner scanner = new Scanner(System.in);

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    final String REGEX_PHONE = "^[0-9]{9,12}$";
    final String EMAIL_REGEX = "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";

    public String inputEmail() {
        while (true) {
            try {
                String email = scanner.nextLine();

                if (email.matches(EMAIL_REGEX)) {
                    return email;
                } else {
                    throw new Exception("The system has encountered an unexpected problem, sincerely sorry !!!");
                }
            } catch (Exception e) {
                System.out.println("The system has encountered an unexpected problem, sincerely sorry !!!");
                System.out.print("Enter again: ");
            }
        }
    }

    public LocalDate checkBirthdate() throws Exception{
        while (true) {
            try {
                LocalDate birthdate = LocalDate.parse(scanner.nextLine(), formatter);

                if (birthdate.getYear() > 1900) {
                    return birthdate;
                } else{
                    throw new Exception("Must Over Year 1900!!!");
                }

            } catch (DateTimeParseException e) {
                System.out.println("The system has encountered an unexpected problem, sincerely sorry !!!");
                System.out.println("Enter birthday: ");
            }
        }
    }

    public String checkPhone() {
        while (true) {
            try {
                String phone = scanner.nextLine();
                if (phone.matches(REGEX_PHONE)) {
                    return phone;
                } else {
                    throw new Exception("Invalid Phone. Must Over 9 number");
                }
            } catch (Exception e) {
                System.out.println("Invalid Phone. Must Over 9 number");
            }
        }
    }
}

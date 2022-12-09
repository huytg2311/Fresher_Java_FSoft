package fa.training.utils;

import java.util.Scanner;

public class Validation {
    final String REGEX_ID = "^[FW|RW|AP][0-9]{5}$";
    final String REGEX_MODEL = "^[A-Za-z]{1,40}$";
    Scanner scanner = new Scanner(System.in);

    public boolean checkID() {
        try {
            if (scanner.nextLine().matches(REGEX_ID)) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkModel() {
        try {
            if (scanner.nextLine().matches(REGEX_MODEL)) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkType() {
        try {
           if (scanner.nextLine().equals("Cargo") || scanner.nextLine().equals("Long range") || scanner.nextLine().equals("Private")) {
               return true;
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


}

package utils;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class DataNotMatchException {
//    ^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$
    final String CCCD_REGEX = "^[0-9]{12}$";
    static List<String> list = new ArrayList<>();

    public DataNotMatchException() {
        list.add("a");
    }

    public boolean checkIndentifyID(String indentifyID) {
        try {
            if (indentifyID.matches(CCCD_REGEX)) {
                return true;
            } else {
                throw new Exception("IdentifyID is invalid!!!");
            }
        } catch (Exception e) {
            System.out.println("IdentifyID is invalid!!!");
//            e.printStackTrace();
        }
        return false;
    }

    public boolean checkBirthday(LocalDate localDate) throws Exception {

            try {
                if (localDate.getYear() > 1900) {
                    return true;
                } else {
                    throw new BirthDayException("BirthDate must be before current date !!!");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        return false;
    }

    public boolean checkID(String id) {
        try {
            for (String s: list
            ) {
                if (s.equals(id)) {
                    System.out.println("Customer " + id + " has duplicate ID");
                    return false;
                }
            }
            list.add(id);
        } catch (Exception e) {
            System.out.println("Customer " + id + "has duplicate ID");

        }
        return true;
    }

}
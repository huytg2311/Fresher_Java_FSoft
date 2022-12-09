package utils;

import java.util.ArrayList;
import java.util.List;

public class DataAllException {
    final String REGEX_ID = "[SB]+[0-9]{4}";
    static List<String> list = new ArrayList<>();
    static int row = 0;

    public DataAllException() {
        list.add("a");
    }


    public boolean checkID(String pitchID) {
        row += 1;
        try {
            if (pitchID.matches(REGEX_ID)) {
                return true;
            } else {
                throw new DataNotMatchException("PitchID of row" + row + " is incorrect");
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return false;
    }

    public boolean checkStatus(String status) {
        try {
            if (status.equals("Available") || status.equals("Not Available")) {
                return true;
            }
            else {
                throw new DataNotMatchException("Status of row is incorrect");
            }
        } catch (Exception e) {
                e.getMessage();
        }
        return false;
    }

    public boolean checkDuplicateID(String id) {
        try {
            for (String s: list
            ) {
                if (s.equals(id)) {
                    throw new PitchDuplicateException("Pitch " + id + " has duplicateID");
                }
            }
            list.add(id);
        } catch (Exception e) {
            e.getMessage();
        }
        return true;
    }

}

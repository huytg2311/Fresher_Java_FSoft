package fa.training.services;

import fa.training.entities.Magazine;

import java.time.LocalDate;
import java.util.*;

public class MagazineService {

    List<Magazine> magazineList;


    public MagazineService() {
        magazineList = new ArrayList<>();
        magazineList.add(new Magazine(2019, "Doraemon", LocalDate.parse("2001-12-10"), "ABC", 2, 2));
        magazineList.add(new Magazine(2020, "Khoi", LocalDate.parse("2001-12-10"), "ABC", 12, 2));
        magazineList.add(new Magazine(2015, "Huy", LocalDate.parse("2001-12-10"), "ABC", 22, 2));
        magazineList.add(new Magazine(2010, "Huy2", LocalDate.parse("2001-12-10"), "ABC", 5, 2));
        magazineList.add(new Magazine(2012, "Huy3", LocalDate.parse("2001-12-10"), "ABC", 6, 2));
        magazineList.add(new Magazine(2012, "Huy4", LocalDate.parse("2001-12-10"), "ABC", 8, 2));
        magazineList.add(new Magazine(2012, "Huy5", LocalDate.parse("2001-12-10"), "ABC", 15, 2));
        magazineList.add(new Magazine(2012, "Huy6", LocalDate.parse("2001-12-10"), "ABC", 7, 2));
        magazineList.add(new Magazine(2012, "Huy7", LocalDate.parse("2001-12-10"), "ABC", 9, 2));
        magazineList.add(new Magazine(2012, "Huy8", LocalDate.parse("2001-12-10"), "ABC", 2, 2));
        magazineList.add(new Magazine(2012, "Huy9", LocalDate.parse("2001-12-10"), "ABC", 20, 2));
    }

    public void add(Magazine magazine) {
        if (!find(magazine.getAuthor())) {
            magazineList.add(magazine);
        } else {
            System.out.println("Record already exists in the book list");
        }
    }

    public boolean find(String author) {
        for (Magazine m : magazineList) {
            if (m.getAuthor().equals(author)) {
                System.out.println(m);
                return true;
            }
        }
        return false;
    }

    public void showListAll() {
        if (magazineList.isEmpty()) {
            System.out.println("The list magazine is empty\n");
        }

        for (Magazine m : magazineList) {
            System.out.println(m.toString());
        }
    }

    public void sortMagazine() {
        magazineList.sort(Comparator.comparing(Magazine::getVolumn));
        Collections.reverse(magazineList);

        for (int i = 0; i < 10; i++) {
            System.out.println(magazineList.get(i).toString());
        }
    }
}

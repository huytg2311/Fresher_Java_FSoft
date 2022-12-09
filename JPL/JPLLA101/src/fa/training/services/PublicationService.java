package fa.training.services;

import fa.training.entities.Book;
import fa.training.entities.Magazine;

import java.time.LocalDate;
import java.util.*;

public class PublicationService {
    List<PublicationService> publicationServiceList = new ArrayList<>();
    List<Book> bookLinkedList;
    List<Magazine> magazineLinkedList;
    Scanner scanner = new Scanner(System.in);


    public PublicationService() {
        bookLinkedList = new LinkedList<>();
        magazineLinkedList = new LinkedList<>();
        Set<String> authors = new HashSet<>();
        authors.add("Ironman");
        authors.add("Captain");
        authors.add("Thor");
        bookLinkedList.add(new Book(2019, "Doraemon", LocalDate.parse("2010-12-10"), "Book01", authors, "VietNam"));
        bookLinkedList.add(new Book(2005, "Sara Nova", LocalDate.parse("2021-12-10"), "Book02", authors, "Korean"));
        bookLinkedList.add(new Book(2007, "Doraemon", LocalDate.parse("2010-12-10"), "Book03", authors, "NY"));
        bookLinkedList.add(new Book(2010, "Nobita", LocalDate.parse("2002-12-10"), "Book04", authors, "Japan"));
        bookLinkedList.add(new Book(2011, "Xuka", LocalDate.parse("2003-12-10"), "Book05", authors, "Japan"));
        magazineLinkedList.add(new Magazine(2019, "Doraemon", LocalDate.parse("2001-12-10"), "ABC", 2, 2));
        magazineLinkedList.add(new Magazine(2020, "Khoi", LocalDate.parse("2001-12-10"), "ABC", 2, 2));
        magazineLinkedList.add(new Magazine(2015, "Huy", LocalDate.parse("2001-12-10"), "ABC", 2, 2));
        magazineLinkedList.add(new Magazine(2010, "Huy", LocalDate.parse("2001-12-10"), "ABC", 2, 2));
        magazineLinkedList.add(new Magazine(2012, "Huy", LocalDate.parse("2001-12-10"), "ABC", 2, 2));
    }

    public void filterObject() {
        for (Book b: bookLinkedList
             ) {
            for (Magazine m : magazineLinkedList) {
                if (b.getPublicationYear() == m.getPublicationYear() && b.getPublisher() == b.getPublisher()) {
                    System.out.println(m.toString());
                    System.out.println(b.toString());
                }
            }
        }
    }



}

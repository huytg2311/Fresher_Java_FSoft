package fa.training.services;

import fa.training.entities.Book;
import fa.training.entities.Magazine;

import java.time.LocalDate;
import java.util.*;

public class BookService {

    List<Book> list;
    Scanner scanner = new Scanner(System.in);

    public BookService() {
        list = new ArrayList<>();
        Set<String> authors = new HashSet<>();
        authors.add("Ironman");
        authors.add("Captain");
        authors.add("Thor");
        list.add(new Book(2019, "Doraemon", LocalDate.parse("2010-12-10"), "Book01", authors, "VietNam"));
        list.add(new Book(2005, "Sara Nova", LocalDate.parse("2021-12-10"), "Book04", authors, "Korean"));
        list.add(new Book(2007, "Doraemon", LocalDate.parse("2010-12-10"), "Book03", authors, "NY"));
        list.add(new Book(2010, "Nobita", LocalDate.parse("2002-12-10"), "Book2", authors, "Japan"));
        list.add(new Book(2011, "Xuka", LocalDate.parse("2003-12-10"), "Book05", authors, "Japan"));

    }

    public void add(Book book) {

        if (!find(book.getIsbn())) {
            list.add(book);
        } else {
            System.out.println("Record already exists in the book list");
        }
    }

    public boolean find(String isbn) {
        for (Book b : list) {
            if (b.getIsbn().equals(isbn)) {
                System.out.println(b);
                return true;
            }
        }
        return false;
    }

    public void showListAll() {
        if (list.isEmpty()) {
            System.out.println("The list book is empty\n");
        }

        for (Book b : list) {
            System.out.println(b.toString());
        }
    }

    public void checkAuthor(Set<String> author) {
        System.out.println("Enter Author: ");
        String inputAuthor = scanner.nextLine();
        for (String s: author
             ) {
            if (inputAuthor.equals(s)) {
                System.out.println("Author existed");

            } else {
//                String[] space = inputAuthor.split(",");
                author.add(inputAuthor);
                System.out.println("Add successfully");
            }
            break;
        }

    }

    public void findByISBN(String isbn) {
        for (Book b: list
             ) {
            if (isbn.equals(b.getIsbn())) {
                checkAuthor(b.getAuthor());
            }
        }
    }

    public void searchBook(int choice) {
        switch (choice) {
            case 1:
                System.out.print("Enter ISBN: ");
                String isbn = scanner.nextLine();
                searchByISBN(isbn);
                break;
            case 2:
                System.out.print("Enter Author: ");
                String author = scanner.nextLine();
                searchByAuthor(author);
                break;
            case 3:
                System.out.print("Enter Publisher: ");
                String publisher = scanner.nextLine();
                searchPublisher(publisher);
                break;
            default:
                break;
        }
    }

    private void searchPublisher(String publisher) {
        for (Book b: list
        ) {
            if (b.getPublisher().equals(publisher)) {
                System.out.println(b.toString());
            }
        }
    }

    private void searchByAuthor(String author) {
        for (Book b: list
        ) {
            for (String b2: b.getAuthor()
                 ) {
                if (b2.equals(author)) {
                    System.out.println(b.toString());
                }
            }
        }
    }

    private void searchByISBN(String isbn) {
        for (Book b: list
        ) {
            if (b.getIsbn().equals(isbn)) {
                System.out.println(b.toString());
            }
        }
    }



}

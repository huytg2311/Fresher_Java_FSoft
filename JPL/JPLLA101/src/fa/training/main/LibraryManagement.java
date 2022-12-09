package fa.training.main;

import fa.training.entities.Book;
import fa.training.entities.Magazine;
import fa.training.services.BookService;
import fa.training.services.MagazineService;
import fa.training.services.PublicationService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Consumer;

public class LibraryManagement {

    public Scanner scanner = new Scanner(System.in);
    public Book book;
    public Magazine magazine;
    public BookService bookService = new BookService();
    public MagazineService magazineService = new MagazineService();
    public PublicationService publicationService = new PublicationService();
    public DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

//    public SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public static void main(String[] args) throws ParseException {
        LibraryManagement libraryManagement = new LibraryManagement();
        libraryManagement.displayMainMenu();
    }

    public void displayMainMenu() throws ParseException {

        int choice;
        do {
            System.out.println();
            System.out.println("====== LIBRARY MANAGEMENT SYSTEM ======");
            System.out.println("1. Add a book");
            System.out.println("2. Add a magazine");
            System.out.println("3. Display books and magazines");
            System.out.println("4. Add author to book");
            System.out.println("5. Display top 10 of magazines by volume");
            System.out.println("6. Search book by (isbn, author, publisher)");
            System.out.print("Please choose function you'd like to do: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addNewBook();
                    break;
                case 2:
                    addNewMagazine();
                    break;
                case 3:
                    showBooksAndMagazines();
                    break;
                case 4:
                    addAuthor();
                    break;
                case 5:
                    showTop10();
                    break;
                case 6:
                    searchBook();
                    break;
                default:
                    break;
            }

        } while (choice != 7);


    }

    private void searchBook() {
        System.out.println("1. Search book by isbn");
        System.out.println("2. Search book by author");
        System.out.println("3. Search book by publisher");
        int choice = scanner.nextInt();
        bookService.searchBook(choice);
    }

    private void showTop10() {
        magazineService.sortMagazine();
    }

    private void addAuthor() {
        System.out.println("Enter ISBN: ");
        scanner.nextLine();
        String isbn = scanner.nextLine();
        bookService.findByISBN(isbn);
    }

    private void showBooksAndMagazines() {
        publicationService.filterObject();
    }

    private void addNewMagazine() throws ParseException {
        System.out.println("Enter Author: ");
        scanner.nextLine();
        String author = scanner.nextLine();
        System.out.println("Enter Volumn: ");
        int volumn = scanner.nextInt();
        System.out.println("Enter Edition: ");
        int edition = scanner.nextInt();
        System.out.println("Enter Publication Year: ");
        int publicationYear = scanner.nextInt();
        System.out.println("Enter Publisher: ");
        String publisher = scanner.nextLine();
        scanner.nextLine();
        System.out.print("Enter Publication Date: ");
        LocalDate publicationDate = LocalDate.parse(scanner.nextLine());

        magazine = new Magazine(publicationYear, publisher, publicationDate, author, volumn, edition);
        magazineService.add(magazine);
        System.out.println(magazine.toString());
    }

    private void addNewBook() throws ParseException {
        System.out.print("Enter ISBN: ");
        scanner.nextLine();
        String isbn = scanner.nextLine();
        System.out.print("Enter Author: ");
        Set<String> author = new HashSet<>();
        String inputAuthor = scanner.nextLine();
        author.add(inputAuthor);
        System.out.print("Enter Publication Place: ");
        String publicationPlace = scanner.nextLine();
        System.out.print("Enter Publication Year: ");
        int publicationYear = scanner.nextInt();
        System.out.print("Enter Publisher: ");
        scanner.nextLine();
        String publisher = scanner.nextLine();
        System.out.print("Enter Publication Date: ");
        LocalDate publicationDate = LocalDate.parse(scanner.nextLine());
        book = new Book(publicationYear, publisher, publicationDate, isbn, author, publicationPlace);
        bookService.add(book);
        System.out.println(book.toString());
    }
}

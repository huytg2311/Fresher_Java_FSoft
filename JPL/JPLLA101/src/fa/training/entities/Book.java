package fa.training.entities;

import java.time.LocalDate;
import java.util.Set;

public class Book extends Publication{
    private String isbn;
    private Set<String> author;
    private String publicationPlace;
    
    public Book(int publicationYear, String publisher, LocalDate publicationLocalDate, String isbn, Set<String> author, String publicationPlace) {
        super(publicationYear, publisher, publicationLocalDate);
        this.isbn = isbn;
        this.author = author;
        this.publicationPlace = publicationPlace;
    }

    public Book(int publicationYear, String publisher, LocalDate publicationLocalDate) {
        super(publicationYear, publisher, publicationLocalDate);
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<String> getAuthor() {
        return author;
    }

    public void setAuthor(Set<String> author) {
        this.author = author;
    }

    public String getPublicationPlace() {
        return publicationPlace;
    }

    public void setPublicationPlace(String publicationPlace) {
        this.publicationPlace = publicationPlace;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", author=" + author +
                ", publicationPlace=" + publicationPlace +
                ", publicationYear=" + getPublicationYear() +
                ", publisher=" + getPublisher() +
                ", publicationLocalDate=" + getPublicationLocalDate() +
                '}';
    }

    @Override
    public void display() {

    }
}

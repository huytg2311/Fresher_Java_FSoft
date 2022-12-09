package fa.training.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Magazine extends Publication {
    private String author;
    private int volumn;
    private int edition;


    public Magazine(int publicationYear, String publisher, LocalDate publicationLocalDate) {
        super(publicationYear, publisher, publicationLocalDate);
    }

    public Magazine(int publicationYear, String publisher, LocalDate publicationLocalDate, String author, int volumn, int edition) {
        super(publicationYear, publisher, publicationLocalDate);
        this.author = author;
        this.volumn = volumn;
        this.edition = edition;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getVolumn() {
        return volumn;
    }

    public void setVolumn(int volumn) {
        this.volumn = volumn;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "author='" + author + '\'' +
                ", volumn=" + volumn +
                ", edition=" + edition +
                ", publicationYear=" + getPublicationYear() +
                ", publisher=" + getPublisher() +
                ", publicationLocalDate=" + getPublicationLocalDate() +
                '}';
    }

    @Override
    public void display() {

    }


}

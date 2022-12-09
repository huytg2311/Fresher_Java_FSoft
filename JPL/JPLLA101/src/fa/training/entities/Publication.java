package fa.training.entities;

import java.time.LocalDate;

public abstract class Publication {
    private int publicationYear;
    private String publisher;
    private LocalDate publicationLocalDate;

    protected Publication(int publicationYear, String publisher, LocalDate publicationLocalDate) {
        this.publicationYear = publicationYear;
        this.publisher = publisher;
        this.publicationLocalDate = publicationLocalDate;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public LocalDate getPublicationLocalDate() {
        return publicationLocalDate;
    }

    public void setPublicationLocalDate(LocalDate publicationLocalDate) {
        this.publicationLocalDate = publicationLocalDate;
    }

    public abstract void display();
}

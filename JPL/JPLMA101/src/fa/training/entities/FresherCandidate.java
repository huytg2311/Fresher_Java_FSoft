package fa.training.entities;

import java.io.Serializable;
import java.time.LocalDate;

public class FresherCandidate extends Candidate implements Serializable {
    private LocalDate graduationDate;

    private String graduationRank;

    private String education;

    public FresherCandidate() {
    }

    public FresherCandidate(LocalDate graduationDate, String graduationRank, String education) {
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    public FresherCandidate(String firstname, String lastname, LocalDate birthdate, String address, String phone, String email, LocalDate graduationDate, String graduationRank, String education) {
        super(firstname, lastname, birthdate, address, phone, email);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    public LocalDate getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(LocalDate graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return "FresherCandidate{" +
                "firstName=" + getFirstname() +
                ",lastName=" + getLastname() +
                ", birthdate=" + getBirthdate() +
                ", address=" + getAddress() +
                ", phone=" + getPhone() +
                ", email=" + getEmail() +
                ", graduationDate=" + graduationDate +
                ", graduationRank=" + graduationRank +
                ", education=" + education +
                '}';
    }

    //    getFirstname() +
//            "," + getLastname() +
//            "," + getBirthdate() +
//            "," + getAddress() +
//            "," + getPhone() +
//            "," + getEmail() +
//            "," + graduationDate +
//            "," + graduationRank +
//            "," + education;
}

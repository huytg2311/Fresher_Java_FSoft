package fa.training.entities;

import java.time.LocalDate;

public class ExperienceCandidate extends Candidate {
    private int yearExperience;
    private String professionalSkill;

    public ExperienceCandidate() {
    }

    public ExperienceCandidate(int yearExperience, String professionalSkill) {
        this.yearExperience = yearExperience;
        this.professionalSkill = professionalSkill;
    }

    public ExperienceCandidate(String firstname, String lastname, LocalDate birthdate, String address, String phone, String email, int yearExperience, String professionalSkill) {
        super(firstname, lastname, birthdate, address, phone, email);
        this.yearExperience = yearExperience;
        this.professionalSkill = professionalSkill;
    }

    public int getYearExperience() {
        return yearExperience;
    }

    public void setYearExperience(int yearExperience) {
        this.yearExperience = yearExperience;
    }

    public String getProfessionalSkill() {
        return professionalSkill;
    }

    public void setProfessionalSkill(String professionalSkill) {
        this.professionalSkill = professionalSkill;
    }

    @Override
    public String toString() {
        return "ExperienceCandidate{" +
                "firstName=" + getFirstname() +
                ",lastName=" + getLastname() +
                ", birthdate=" + getBirthdate() +
                ", address=" + getAddress() +
                ", phone=" + getPhone() +
                ", email=" + getEmail() +
                ", yearExperience=" + yearExperience +
                ", professionalSkill=" + professionalSkill +
                '}';
    }
}

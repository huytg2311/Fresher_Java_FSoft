package entities;

import java.time.LocalDate;

public class Foreigner extends Customer {
    private String passport;
    private int travelTimes;

    public Foreigner() {
    }


    public Foreigner(String passport, int travelTimes) {
        this.passport = passport;
        this.travelTimes = travelTimes;
    }

    public Foreigner(String cusID, String name, LocalDate birthday, String sex, String indentifyID, int vaccineTimes, LocalDate travelDate, int ticketPrice, int type, String passport, int travelTimes) {
        super(cusID, name, birthday, sex, indentifyID, vaccineTimes, travelDate, ticketPrice, type);
        this.passport = passport;
        this.travelTimes = travelTimes;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public int getTravelTimes() {
        return travelTimes;
    }

    public void setTravelTimes(int travelTimes) {
        this.travelTimes = travelTimes;
    }

    @Override
    public void showInformation() {
        System.out.println("Foreigner{ " +
                "CusID: " + getCusID() +
                ", Name: " + getName() +
                ", BirthDay: " + getBirthday() +
                ", Sex: " + getSex() +
                ", Identify ID: " + getIndentifyID() +
                ", Vaccine times: " + getVaccineTimes() +
                ", Travel date: " + getTravelDate() +
                ", TicketPrice: " + getTicketPrice() +
                ", Type: " + getType() +
                ", Travel date: " + getTravelTimes() +
                ", Passport: " + passport +
                ", Travel times: " + travelTimes + " }"
        );
    }

}

package entities;

import java.time.LocalDate;

public class LocalPeople extends Customer{
    private String address;

    public LocalPeople() {
    }

    @Override
    public void showInformation() {
        System.out.println("OutLocalPeople{ " +
                "CusID: " + getCusID() +
                ", Name: " + getName() +
                ", BirthDay: " + getBirthday() +
                ", Sex: " + getSex() +
                ", Identify ID: " + getIndentifyID() +
                ", Vaccine times: " + getVaccineTimes() +
                ", Travel date: " + getTravelDate() +
                ", TicketPrice: " + getTicketPrice() +
                ", Type: " + getType() +
                ", Address: " + getAddress() + "}"
        );
    }

    public LocalPeople(String address) {
        this.address = address;
    }

    public LocalPeople(String cusID, String name, LocalDate birthday, String sex, String indentifyID, int vaccineTimes, LocalDate travelDate, int ticketPrice, int type, String address) {
        super(cusID, name, birthday, sex, indentifyID, vaccineTimes, travelDate, ticketPrice, type);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

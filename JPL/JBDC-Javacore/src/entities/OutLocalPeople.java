package entities;

import java.time.LocalDate;

public class OutLocalPeople extends Customer{
    private String province;

    public OutLocalPeople() {
    }

    public OutLocalPeople(String province) {
        this.province = province;
    }

    public OutLocalPeople(String cusID, String name, LocalDate birthday, String sex, String indentifyID, int vaccineTimes, LocalDate travelDate, int ticketPrice, int type, String province) {
        super(cusID, name, birthday, sex, indentifyID, vaccineTimes, travelDate, ticketPrice, type);
        this.province = province;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
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
                ", Province: " + getProvince() + "}"
        );
    }

}

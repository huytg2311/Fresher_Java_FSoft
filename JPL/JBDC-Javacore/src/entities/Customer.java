package entities;

import java.time.LocalDate;

public abstract class Customer {
    private String cusID;
    private String name;
    private LocalDate birthday;
    private String sex;
    private String indentifyID;
    private int vaccineTimes;
    private LocalDate travelDate;
    private int ticketPrice;
    private int type;


    public Customer() {
    }

    /**
     * @author huy
     * @param cusID
     * @param name
     * @param birthday
     * @param sex
     * @param indentifyID
     * @param vaccineTimes
     * @param travelDate
     * @param ticketPrice
     * @param type
     */
    public Customer(String cusID, String name, LocalDate birthday, String sex, String indentifyID, int vaccineTimes, LocalDate travelDate, int ticketPrice, int type) {
        this.cusID = cusID;
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
        this.indentifyID = indentifyID;
        this.vaccineTimes = vaccineTimes;
        this.travelDate = travelDate;
        this.ticketPrice = ticketPrice;
        this.type = type;
    }

    public String getCusID() {
        return cusID;
    }

    public void setCusID(String cusID) {
        this.cusID = cusID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIndentifyID() {
        return indentifyID;
    }

    public void setIndentifyID(String indentifyID) {
        this.indentifyID = indentifyID;
    }

    public int getVaccineTimes() {
        return vaccineTimes;
    }

    public void setVaccineTimes(int vaccineTimes) {
        this.vaccineTimes = vaccineTimes;
    }

    public LocalDate getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(LocalDate travelDate) {
        this.travelDate = travelDate;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public abstract void showInformation();


}

package entities;

import java.time.LocalDate;

public class WoodPitch extends Pitch{
    private int warrantYear;
    private String productionCountry;

    public WoodPitch(int warrantYear, String productionCountry) {
        this.warrantYear = warrantYear;
        this.productionCountry = productionCountry;
    }

    public WoodPitch(String pitchID, String name, int size, int cost, String status, LocalDate startDate, int type, int warrantYear, String productionCountry) {
        super(pitchID, name, size, cost, status, startDate, type);
        this.warrantYear = warrantYear;
        this.productionCountry = productionCountry;
    }

    public int getWarrantYear() {
        return warrantYear;
    }

    public void setWarrantYear(int warrantYear) {
        this.warrantYear = warrantYear;
    }

    public String getProductionCountry() {
        return productionCountry;
    }

    public void setProductionCountry(String productionCountry) {
        this.productionCountry = productionCountry;
    }

    @Override
    public void showInformation() {
        System.out.println("WoodPitch{ " +
                " pitchID=" + getPitchID() +
                ", name=" + getName() +
                ", size=" + getSize() +
                ", cost=" + getCost() +
                ", status=" + getStatus() +
                ", startDate=" + getStartDate() +
                ", warrantYear=" + warrantYear +
                ", productionCountry" + productionCountry + " }"
                );
    }
}

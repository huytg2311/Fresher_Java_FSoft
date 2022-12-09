package entities;

import java.time.LocalDate;

public class NaturalPitch extends Pitch{
    private int cuttingTime;

    public NaturalPitch(int cuttingTime) {
        this.cuttingTime = cuttingTime;
    }

    public NaturalPitch(String pitchID, String name, int size, int cost, String status, LocalDate startDate, int type, int cuttingTime) {
        super(pitchID, name, size, cost, status, startDate, type);
        this.cuttingTime = cuttingTime;
    }

    public int getCuttingTime() {
        return cuttingTime;
    }

    public void setCuttingTime(int cuttingTime) {
        this.cuttingTime = cuttingTime;
    }

    @Override
    public void showInformation() {
        System.out.println("NaturalPitch{ " +
                " pitchID=" + getPitchID() +
                ", name=" + getName() +
                ", size=" + getSize() +
                ", cost=" + getCost() +
                ", status=" + getStatus() +
                ", startDate=" + getStartDate() +
                ", type=" + getType() +
                ", CuttingTime=" + getCuttingTime() + " }"
                );
    }
}

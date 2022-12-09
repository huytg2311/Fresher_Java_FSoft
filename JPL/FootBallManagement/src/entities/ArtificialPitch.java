package entities;

import java.time.LocalDate;

public class ArtificialPitch extends Pitch{
    private int enduringYear;
    private String typeOfGrass;

    public ArtificialPitch(int enduringYear, String typeOfGrass) {
        this.enduringYear = enduringYear;
        this.typeOfGrass = typeOfGrass;
    }

    public ArtificialPitch(String pitchID, String name, int size, int cost, String status, LocalDate startDate, int type, int enduringYear, String typeOfGrass) {
        super(pitchID, name, size, cost, status, startDate, type);
        this.enduringYear = enduringYear;
        this.typeOfGrass = typeOfGrass;
    }

    public int getEnduringYear() {
        return enduringYear;
    }

    public void setEnduringYear(int enduringYear) {
        this.enduringYear = enduringYear;
    }

    public String getTypeOfGrass() {
        return typeOfGrass;
    }

    public void setTypeOfGrass(String typeOfGrass) {
        this.typeOfGrass = typeOfGrass;
    }

    @Override
    public void showInformation() {
        System.out.println("ArtificialPitch{ " +
                " pitchID=" + getPitchID() +
                ", name=" + getName() +
                ", size=" + getSize() +
                ", cost=" + getCost() +
                ", status=" + getStatus() +
                ", startDate=" + getStartDate() +
                ", enduringYear ="  + enduringYear +
                ", typeOfGrass=" + typeOfGrass + " }");
    }
}

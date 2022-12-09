package entities;

import java.time.LocalDate;
import java.util.List;

public abstract class Pitch {
    private String pitchID;
    private String name;
    private int size;
    private int cost;
    private String status;
    private LocalDate startDate;
    private int type;
    private List<WoodPitch> woodPitchList;

    public Pitch() {
    }

    public Pitch(String pitchID, String name, int size, int cost, String status, LocalDate startDate, int type) {
        this.pitchID = pitchID;
        this.name = name;
        this.size = size;
        this.cost = cost;
        this.status = status;
        this.startDate = startDate;
        this.type = type;
    }

    public List<WoodPitch> getWoodPitchList() {
        return woodPitchList;
    }

    public void setWoodPitchList(List<WoodPitch> woodPitchList) {
        this.woodPitchList = woodPitchList;
    }

    public String getPitchID() {
        return pitchID;
    }

    public void setPitchID(String pitchID) {
        this.pitchID = pitchID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Pitch{" +
                "pitchID='" + pitchID + '\'' +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", cost=" + cost +
                ", status='" + status + '\'' +
                ", startDate=" + startDate +
                '}';
    }

    public abstract void showInformation();
}

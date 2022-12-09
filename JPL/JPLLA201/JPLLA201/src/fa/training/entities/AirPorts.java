package fa.training.entities;

import java.util.List;

public class AirPorts {
    private String id;
    private String name;
    private double runwaySize;
    private double maxFixedWingParkingPlace;
    private double maxRouter;
    private List<Fixedwing> fixedwingList;
    private List<Helicopters> helicoptersList;

    public AirPorts() {
    }

    public AirPorts(String id, String name, double runwaySize, double maxFixedWingParkingPlace, double maxRouter) {
        this.id = id;
        this.name = name;
        this.runwaySize = runwaySize;
        this.maxFixedWingParkingPlace = maxFixedWingParkingPlace;
        this.maxRouter = maxRouter;
    }

    public AirPorts(String id, String name, double runwaySize, double maxFixedWingParkingPlace, double maxRouter, List<Fixedwing> fixedwingList, List<Helicopters> helicoptersList) {
        this.id = id;
        this.name = name;
        this.runwaySize = runwaySize;
        this.maxFixedWingParkingPlace = maxFixedWingParkingPlace;
        this.maxRouter = maxRouter;
        this.fixedwingList = fixedwingList;
        this.helicoptersList = helicoptersList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRunwaySize() {
        return runwaySize;
    }

    public void setRunwaySize(double runwaySize) {
        this.runwaySize = runwaySize;
    }

    public double getMaxFixedWingParkingPlace() {
        return maxFixedWingParkingPlace;
    }

    public void setMaxFixedWingParkingPlace(double maxFixedWingParkingPlace) {
        this.maxFixedWingParkingPlace = maxFixedWingParkingPlace;
    }

    public double getMaxRouter() {
        return maxRouter;
    }

    public void setMaxRouter(double maxRouter) {
        this.maxRouter = maxRouter;
    }

    public List<Fixedwing> getFixedwingList() {
        return fixedwingList;
    }

    public void setFixedwingList(List<Fixedwing> fixedwingList) {
        this.fixedwingList = fixedwingList;
    }

    public List<Helicopters> getHelicoptersList() {
        return helicoptersList;
    }

    public void setHelicoptersList(List<Helicopters> helicoptersList) {
        this.helicoptersList = helicoptersList;
    }

    @Override
    public String toString() {
        return "AirPorts{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", runwaySize=" + runwaySize +
                ", maxFixedWingParkingPlace=" + maxFixedWingParkingPlace +
                ", maxRouter=" + maxRouter +
                ", list fixed=" + fixedwingList +
                ", list helicopters=" + helicoptersList +
                '}';
    }
}

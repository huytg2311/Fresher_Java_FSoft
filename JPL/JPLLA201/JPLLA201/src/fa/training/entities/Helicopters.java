package fa.training.entities;

public class Helicopters {
    private String id;
    private String model;
    private double cruiseSpeed;
    private double emptyWeight;
    private double maxTakeOffWeight;
    private double range;
    private static String flyMethod = "rotatedWing";

    public Helicopters() {
    }

    public Helicopters(String id, String model, double cruiseSpeed, double emptyWeight, double maxTakeOffWeight, double range) {
        this.id = id;
        this.model = model;
        this.cruiseSpeed = cruiseSpeed;
        this.emptyWeight = emptyWeight;
        this.maxTakeOffWeight = maxTakeOffWeight;
        this.range = range;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getCruiseSpeed() {
        return cruiseSpeed;
    }

    public void setCruiseSpeed(double cruiseSpeed) {
        this.cruiseSpeed = cruiseSpeed;
    }

    public double getEmptyWeight() {
        return emptyWeight;
    }

    public void setEmptyWeight(double emptyWeight) {
        this.emptyWeight = emptyWeight;
    }

    public double getMaxTakeOffWeight() {
        return maxTakeOffWeight;
    }

    public void setMaxTakeOffWeight(double maxTakeOffWeight) {
        this.maxTakeOffWeight = maxTakeOffWeight;
    }

    public double getRange() {
        return range;
    }

    public void setRange(double range) {
        this.range = range;
    }
}

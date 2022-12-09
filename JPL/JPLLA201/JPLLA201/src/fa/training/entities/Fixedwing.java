package fa.training.entities;

public class Fixedwing {
    private String id;
    private String model;
    private String planeType;
    private int cruiseSpeed;
    private double emptyWeight;
    private double maxTakeoffWeight;
    private double minRunwaySize;
    private static String flyMethod = "Fixed Wing";

    public Fixedwing() {
    }

    public Fixedwing(String id, String model, String planeType, int cruiseSpeed, double emptyWeight, double maxTakeoffWeight, double minRunwaySize) {
        this.id = id;
        this.model = model;
        this.planeType = planeType;
        this.cruiseSpeed = cruiseSpeed;
        this.emptyWeight = emptyWeight;
        this.maxTakeoffWeight = maxTakeoffWeight;
        this.minRunwaySize = minRunwaySize;
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

    public String getPlaneType() {
        return planeType;
    }

    public void setPlaneType(String planeType) {
        this.planeType = planeType;
    }

    public int getCruiseSpeed() {
        return cruiseSpeed;
    }

    public void setCruiseSpeed(int cruiseSpeed) {
        this.cruiseSpeed = cruiseSpeed;
    }

    public double getEmptyWeight() {
        return emptyWeight;
    }

    public void setEmptyWeight(double emptyWeight) {
        this.emptyWeight = emptyWeight;
    }

    public double getMaxTakeoffWeight() {
        return maxTakeoffWeight;
    }

    public void setMaxTakeoffWeight(double maxTakeoffWeight) {
        this.maxTakeoffWeight = maxTakeoffWeight;
    }

    public double getMinRunwaySize() {
        return minRunwaySize;
    }

    public void setMinRunwaySize(double minRunwaySize) {
        this.minRunwaySize = minRunwaySize;
    }

    public static String getFlyMethod() {
        return flyMethod;
    }

    public static void setFlyMethod(String flyMethod) {
        Fixedwing.flyMethod = flyMethod;
    }
}

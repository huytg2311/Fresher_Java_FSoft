package fa.training.entities;

public class Truck extends Car {
    private int weight;

    public Truck(int weight) {
        this.weight = weight;
    }

    public Truck(int speed, double regularPrice, String color, int weight) {
        super(speed, regularPrice, color);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "fa.training.entities.Truck{" +
                " speed=" + getSpeed() +
                ", regularPrice=" + getRegularPrice() +
                ", color=" + getColor() +
                "weight=" + weight +
                '}';
    }

    @Override
    double getSalePrice() {
        if (weight > 2000) {
            return getRegularPrice() * 0.1;
        } else {
            return getRegularPrice() * 0.2;
        }
    }

}

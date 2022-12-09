package fa.training.entities;

public class Sedan extends Car {
    private int length;

    public Sedan(int length) {
        this.length = length;
    }

    public Sedan(int speed, double regularPrice, String color, int length) {
        super(speed, regularPrice, color);
        this.length = length;
    }

    public Sedan() {

    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "fa.training.entities.Sedan{" +
                " speed=" + getSpeed() +
                ", regularPrice=" + getRegularPrice() +
                ", color=" + getColor() +
                ", length=" + length +
                '}';
    }

    @Override
    double getSalePrice() {
        if (length > 20) {
            return getRegularPrice() * 0.05;
        } else {
            return getRegularPrice() * 0.1;
        }
    }
}

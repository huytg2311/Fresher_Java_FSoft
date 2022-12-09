package fa.training.entities;

public class Ford extends Car{
    private int year;
    private int manufacturerDiscount;

    public Ford(int year, int manufacturerDiscount) {
        this.year = year;
        this.manufacturerDiscount = manufacturerDiscount;
    }

    public Ford(int speed, double regularPrice, String color, int year, int manufacturerDiscount) {
        super(speed, regularPrice, color);
        this.year = year;
        this.manufacturerDiscount = manufacturerDiscount;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getManufacturerDiscount() {
        return manufacturerDiscount;
    }

    public void setManufacturerDiscount(int manufacturerDiscount) {
        this.manufacturerDiscount = manufacturerDiscount;
    }

    @Override
    public String toString() {
        return "fa.training.entities.Ford{" +
                " speed=" + getSpeed() +
                ", regularPrice=" + getRegularPrice() +
                ", color=" + getColor() +
                "year=" + year +
                ", manufacturerDiscount=" + manufacturerDiscount +
                '}';
    }

    @Override
    double getSalePrice() {
        return getRegularPrice() - manufacturerDiscount;
    }
}

package fa.training.entities;

public interface Shape {
    abstract int calculatePerimeter();
    abstract int calculateArea();
    abstract int getLength();
    abstract int getWidth();
    abstract void setLengthWidth(int len, int width);


}

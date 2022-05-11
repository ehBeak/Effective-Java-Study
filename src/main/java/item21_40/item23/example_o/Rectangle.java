package item21_40.item23.example_o;

public class Rectangle extends Shape {

    private final double length;
    public final double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }
}

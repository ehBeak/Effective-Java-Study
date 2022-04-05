package item23.example_x;

public class Figure {
    enum Shape {RECTANGLE, CIRCLE}

    // 태그 필드 - 현재 모양을 나타낸다.
    final Shape shape;

    // 다음 필드들은 모양이 사각형(RECTANGLE)일 때만 사용한다.
    double length;
    double width;

    // 다음 필드들은 모양이 원(CIRCLE)일 때만 사용한다.
    double radius;

    // 사격형용 생성자
    public Figure(double length, double width) {
        this.shape = Shape.RECTANGLE;
        this.length = length;
        this.width = width;
    }

    // 원용 생성자
    public Figure(double radius) {
        this.shape = Shape.CIRCLE;
        this.radius = radius;
    }

    double area() {
        switch (shape) {
            case RECTANGLE:
                return length * width;
            case CIRCLE:
                return Math.PI * (radius * radius);
            default:
        }
        throw new AssertionError(shape);
    }
}

package item10.transitivity;

import java.awt.*;
import java.util.Objects;

// 우회 방법 : 상속 대신 컴포지션 사용
public class ColorPoint {

    private final Point point;
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        this.point = new Point(x, y);
        this.color = Objects.requireNonNull(color);
    }

    /*
     * 이 ColorPoint의 Point 뷰를 반환한다.
     * */
    public Point asPoint() {
        return point;
    }

    @Override
    public boolean equals(Object o) { // LSP 위배
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColorPoint that = (ColorPoint) o;
        return Objects.equals(point, that.point) && Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point, color);
    }
}

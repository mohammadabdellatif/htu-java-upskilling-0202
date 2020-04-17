package jo.edu.htu.math;

import jo.edu.htu.Topics;
import jo.edu.htu.Version;

import java.util.Objects;

@Version(major = 1, minor = 2)
@Topics(value = "Immutable class", version = @Version(major = 1, minor = 0))
public class Point {

    public static final Point CENTER = new Point(0, 0);

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

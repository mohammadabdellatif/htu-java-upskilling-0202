package jo.edu.htu.utils;

import java.util.Objects;

public class Point implements Comparable<Point> {

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
    public String toString() {
        return "(" + x + "," + y + ')';
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

    @Override
    public int compareTo(Point other) {
        if(other == null){
            return 1;
        }
        if (x == other.x && y == other.y)
            return 0;
        if (x > other.x)
            return 1;
        if (x < other.x)
            return -1;
        if (y > other.y)
            return 1;
        return -1;
    }
}

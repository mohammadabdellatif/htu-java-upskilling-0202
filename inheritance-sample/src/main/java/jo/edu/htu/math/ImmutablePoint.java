package jo.edu.htu.math;

import java.util.Objects;

public class ImmutablePoint {

    protected final int x;
    protected final int y;
    private final int hashValue;

    public ImmutablePoint() {
        this(0, 0);
    }

    public ImmutablePoint(int x, int y) {
        this.y = y;
        this.x = x;

        int hash = 13;
        hash += 37 * x;
        hash += 37 * y;

        hashValue = hash;
    }

    public final int getY() {
        return y;
    }

    public final int getX() {
        return x;
    }

    public String coordinates() {
        return coordinates("(%d,%d)");
    }

    public String coordinates(String format) {
        return String.format(format, x, y);
    }

    @Override
    public String toString() {
        return format(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ImmutablePoint point = (ImmutablePoint) o;
        return getX() == point.getX() &&
                getY() == point.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }

    public static String format(int x, int y) {
        return String.format("(%d,%d)", x, y);
    }
}

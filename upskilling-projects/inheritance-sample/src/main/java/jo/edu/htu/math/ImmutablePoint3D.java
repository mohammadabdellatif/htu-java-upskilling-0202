package jo.edu.htu.math;

import java.util.Objects;

public final class ImmutablePoint3D extends ImmutablePoint {

    private int z;

    public ImmutablePoint3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public int getZ() {
        return z;
    }

    @Override
    public String coordinates() {
        return String.format("(%d,%d,%d)",
                getX(), getY(), z);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        ImmutablePoint3D point3D = (ImmutablePoint3D) o;
        return getZ() == point3D.getZ();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getZ());
    }

    public String coordinates(String format) {
        return String.format(format, getX(), getY(), getZ());
    }

    public static String format(int x, int y) {
        return String.format("3D (%d,%d)", x, y);
    }
}

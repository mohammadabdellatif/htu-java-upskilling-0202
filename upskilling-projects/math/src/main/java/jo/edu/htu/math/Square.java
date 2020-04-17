package jo.edu.htu.math;

public class Square extends PolygonShape {
    private final int side;

    public Square(int side) {
        this.side = side;
    }

    @Override
    public double circumference() {
        return 4 * side;
    }

    @Override
    public double area() {
        return side * side;
    }

    public int getSide() {
        return side;
    }

    @Override
    public int sides() {
        return 4;
    }
}

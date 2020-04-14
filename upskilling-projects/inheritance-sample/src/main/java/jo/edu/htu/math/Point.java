package jo.edu.htu.math;

public class Point {
    protected int x;
    protected int y;

    public Point() {
        super();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moveHorizontally(int steps) {
        x += steps;
    }

    public void moveVertically(int steps) {
        y += steps;
    }
}

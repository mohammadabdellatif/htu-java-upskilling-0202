package jo.edu.htu.math;

public class Rectangle extends PolygonShape {

    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }


    @Override
    public int sides() {
        return 4;
    }

    @Override
    public double circumference() {
        return 2 * width + 2 * height;
    }

    @Override
    public double area() {
        return width * height;
    }
}

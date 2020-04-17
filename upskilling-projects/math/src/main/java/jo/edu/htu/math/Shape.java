package jo.edu.htu.math;

public abstract class Shape {

    public abstract double circumference();

    public abstract double area();

    @Override
    public String toString() {
        String shapeName = getClass().getSimpleName();
        return String.format("%s->area: %f, circumference: %f",
                shapeName,
                area(), circumference());
    }
}


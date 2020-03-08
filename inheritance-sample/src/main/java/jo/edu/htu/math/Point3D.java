package jo.edu.htu.math;

import jo.edu.htu.math.Point;

public class Point3D extends Point {
    private int z;

    public Point3D(){
        super();
    }

    public int getZ() {
        return z;
    }

    public void moveInDepth(int steps) {
        z+= steps;
    }
}

package jo.edu.htu.util;

public class PenFiller {

    // lower-bound wildcard
    // I can refer to a box of pen, stationery, object
    // because Pen can be passed to all of those types
    public void fill(Box<? super Pen> penBox) {
        Pen pen = new Pen();
        penBox.put(pen);
        // with lower-bound, out parameters is always object
        // because it is 100% an object
        Object obj = penBox.item();
    }
}

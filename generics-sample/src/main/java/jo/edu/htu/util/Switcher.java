package jo.edu.htu.util;

// to read upper bound
// to write lower bound
public class Switcher {

    public void movePen(Box<? extends Pen> from, Box<? super Pen> to) {
        Pen pen = from.item();
        to.put(pen);
    }

}

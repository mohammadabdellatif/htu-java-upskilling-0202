package jo.edu.htu.util;

// to read upper bound
// to write lower bound
public class Switcher {

    public <ITEM> void moveItem(Box<? extends ITEM> from, Box<? super ITEM> to) {
        if (from.isEmpty())
            throw new IllegalStateException("from box is empty");
        if (!to.isEmpty())
            throw new IllegalStateException("to box is full");
        ITEM item = from.item();
        from.put(null);
        to.put(item);
    }

    public void movePen(Box<? extends Pen> from, Box<? super Pen> to) {
        if (from.isEmpty())
            throw new IllegalStateException("from box is empty");
        if (!to.isEmpty())
            throw new IllegalStateException("to box is full");
        Pen pen = from.item();
        // you could pass null,
        // it is acceptable regardless
        // of generic type
        from.put(null);
        to.put(pen);
    }

}

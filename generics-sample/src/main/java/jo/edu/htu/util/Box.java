package jo.edu.htu.util;

// General purpose class
// Generic Type
public class Box<ITEM> {

    private ITEM item;

    // in parameter
    public void put(ITEM item) {
        this.item = item;
    }

    // out parameter
    public ITEM item() {
        return item;
    }

    public boolean isEmpty() {
        return item == null;
    }
}

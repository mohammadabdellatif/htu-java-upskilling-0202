package jo.edu.htu.util;

public class Packager {

    public <I> void fill(I item, Box<? super I> box) {
        if (!box.isEmpty())
            throw new IllegalStateException("The box is not empty");
        box.put(item);
    }

    public <I> void fill(Box<? super I> box, Factory<? extends I> factory) {
        if (!box.isEmpty())
            throw new IllegalStateException("The box is not empty");
        I item = factory.newItem();
        box.put(item);
    }
}

package jo.edu.htu.util;

public class Packager {

    public <I> void fill(I item, Box<? super I> box) {
        if (!box.isEmpty())
            throw new IllegalStateException("The box is not empty");
        box.put(item);
    }
}

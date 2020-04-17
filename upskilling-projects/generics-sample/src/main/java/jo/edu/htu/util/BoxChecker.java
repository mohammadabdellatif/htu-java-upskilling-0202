package jo.edu.htu.util;

// I need to check all type of boxes which contains
// any type of stationery
public class BoxChecker {

    // upper bound reference
    // range of generic types, any sub-type of Stationery
    // which is unlimited
    public void check(Box<? extends Stationery> box) {
        if (box.isEmpty())
            throw new IllegalStateException("the box is empty");
        // you can always read as stationery
        // it is 100 % guaranteed
        Stationery item = box.item();
//        Those are disallowed, so you wont corrupt the box :)
//        box.put(new Pencil());
//        box.put(new Pen());
//        box.put(new Stationery());
    }
}

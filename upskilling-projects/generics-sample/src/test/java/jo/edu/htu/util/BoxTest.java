package jo.edu.htu.util;

import java.util.ArrayList;

public class BoxTest {

    public static void main(String[] args) {
        Pencil pencil = new Pencil();
        Pen pen = new Pen();
        BoxChecker checker = new BoxChecker();
        // type inferring
        Box<Pen> penBox = new Box<>();
        Box<Pencil> pencilBox = new Box<>();
        // This is forbidden, because if it is allowed
        // you could be able to corrupt the box content
        // Box<Stationery> box = penBox;

        penBox.put(pen);
        pencilBox.put(pencil);

        checker.check(penBox);

        deliverPencilToYousef(pencilBox);
        deliverPenToHakam(penBox);
    }

    private static void deliverPenToHakam(Box<? extends Pen> box) {
        System.out.println("I need to get the pen from the box");
        Pen pen = box.item();
        System.out.println("I got my pen :)");
    }

    private static void deliverPencilToYousef(Box<? extends Pencil> box) {
        System.out.println("I need to get the pencil from the box");
        Pencil pencil = box.item();
        System.out.println("I got my pencil :)");
    }
}

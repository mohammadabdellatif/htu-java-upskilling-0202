package jo.edu.htu.util;

import java.util.ArrayList;

public class BoxTest {

    public static void main(String[] args) {
        Pencil pencil = new Pencil();
        Pen pen = new Pen();

        // type inferring
        Box<Pen> penBox = new Box<>();
        Box<Pencil> pencilBox = new Box<>();

        penBox.put(pen);
        pencilBox.put(pencil);

        deliverPencilToYousef(pencilBox);
        deliverPenToHakam(penBox);
    }

    private static void deliverPenToHakam(Box<Pen> box) {
        System.out.println("I need to get the pen from the box");
        Pen pen = box.item();
        System.out.println("I got my pen :)");
    }

    private static void deliverPencilToYousef(Box<Pencil> box) {
        System.out.println("I need to get the pencil from the box");
        Pencil pencil = box.item();
        System.out.println("I got my pencil :)");
    }
}

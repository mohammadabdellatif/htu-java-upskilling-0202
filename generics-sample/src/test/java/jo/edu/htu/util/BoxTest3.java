package jo.edu.htu.util;

// Summary for wildcards:
// if the purpose is to read (? extends ###) upper bound
// if the purpose is to pass in parameters (? super ###) lower bound
public class BoxTest3 {

    public static void main(String[] args) {
        PenFiller penFiller = new PenFiller();
        Box<Pencil> pencilBox = new Box<>();
        Box<Object> objectBox = new Box();
        Box<Stationery> stationeryBox = new Box<>();
        Box<Pen> penBox = new Box();

        penFiller.fill(objectBox);
        penFiller.fill(stationeryBox);
        penFiller.fill(penBox);
        // Disallowed
        // penFiller.fill(pencilBox);

        deliverGiftToHakam(stationeryBox);
        deliverPencilToYousef(pencilBox);
    }

    private static void deliverGiftToHakam(Box<Stationery> box) {
        System.out.println("I need to get the pen from the box");
        Stationery stationery = box.item();
        System.out.println("I got my Stationery :)");
    }

    private static void deliverPencilToYousef(Box<Pencil> box) {
        System.out.println("I need to get the pencil from the box");
        Pencil pencil = box.item();
        System.out.println("I got my pencil :)");
    }
}

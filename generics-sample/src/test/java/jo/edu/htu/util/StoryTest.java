package jo.edu.htu.util;

public class StoryTest {

    public static void main(String[] args) {
        PenBox penBox = new PenBox();
        StationeryBox<Pen> stationeryBox = penBox;
        Box<Pen> penBox1 = penBox;

        PenBox yousefBox = new PenBox();
        Box<Pencil> hakamBox = new Box<>();
        Packager packager = new Packager();
        Delivery<Pen> penDelivery;
        Delivery<Pencil> pencilDelivery;

        packager.fill(new Pen(), yousefBox);
        packager.fill(new Pencil(), hakamBox);
        //packager.fill(new InkPen(), yousefBox);

        pencilDelivery = new Delivery<>("Hakam", hakamBox);
        penDelivery = new Delivery<>("Yousef", yousefBox);

        pencilDelivery.deliver();
        penDelivery.deliver();
    }
}

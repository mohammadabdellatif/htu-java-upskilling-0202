package jo.edu.htu.util;

public class StoryTest {

    public static void main(String[] args) {
        Box<Pen> penBox = new Box<>();
        Box<Pencil> pencilBox = new Box<>();
        Packager packager = new Packager();
        Delivery<Pen> penDelivery;
        Delivery<Pencil> pencilDelivery;

        packager.fill(new Pen(), penBox);
        packager.fill(new Pencil(), pencilBox);
        //packager.fill(new InkPen(), penBox);

        pencilDelivery = new Delivery<>("Hakam", pencilBox);
        penDelivery = new Delivery<>("Yousef", penBox);

        pencilDelivery.deliver();
        penDelivery.deliver();
    }
}

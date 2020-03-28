package jo.edu.htu.util;

public class Story2Test {

    public static void main(String[] args) {
        Factory<Pen> penFactory = () -> new Pen();
        Factory<Pencil> pencilFactory = () -> new Pencil();
        PenBox yousefBox = new PenBox();
        Box<Stationery> hakamBox = new Box<>();
        Packager packager = new Packager();

        packager.fill(yousefBox, penFactory);
        packager.fill(hakamBox, pencilFactory);

        Delivery<Stationery> pencilDelivery = new Delivery<>("Hakam", hakamBox);
        Delivery<Pen> penDelivery = new Delivery<>("Yousef", yousefBox);

        pencilDelivery.deliver();
        penDelivery.deliver();
    }
}

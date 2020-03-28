package jo.edu.htu.util;

public class SwitchTest {

    public static void main(String[] args) {
        Box<Object> objectBox = new Box<>();
        Box<Stationery> stationeryBox = new Box<>();
        Box<Pen> penBox1 = new Box<>();
        Box<Pen> penBox2 = new Box<>();
        Box<InkPen> inkPenBox = new Box<>();
        Box<Pencil> pencilBox = new Box<>();

        inkPenBox.put(new InkPen());
        penBox1.put(new Pen());

        Switcher switcher = new Switcher();
        switcher.movePen(penBox1, penBox2);
        switcher.movePen(penBox1, stationeryBox);
        switcher.movePen(penBox1, objectBox);

        switcher.<Pen>moveItem(penBox1, penBox2);
        // type inferring
        switcher.moveItem(penBox2, stationeryBox);

        // this wont work
//        switcher.moveItem(penBox1, pencilBox);
    }
}

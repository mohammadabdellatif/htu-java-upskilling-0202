package jo.edu.htu.util;

public class BoxTest2 {

    public static void main(String[] args) {
        BoxChecker checker = new BoxChecker();
        Box<Pen> penBox = new Box<>();
        Box<Stationery> stationeryBox = new Box<>();
        Box<Pencil> pencilBox = new Box<>();
        Box<String> strBox = new Box();

        checker.check(penBox);
        checker.check(pencilBox);
        checker.check(stationeryBox);
        // You can't pass string box to the method
        // because String is not a sub-type of Stationery
        // checker.check(strBox);
    }
}

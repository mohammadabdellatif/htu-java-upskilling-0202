package jo.edu.htu.util;

public class StationeryPrinter {

    public void print(Stationery stationery) {
        System.out.println("stationery: " + stationery.name());
    }

//    public <T extends Stationery> void print(T stationery) {
//        System.out.println("stationery: " + stationery.name());
//    }
}

package jo.edu.htu.util;

public class Delivery<I> {

    private String customerName;
    private Box<? extends I> box;

    public Delivery(String customerName, Box<? extends I> box) {
        this.customerName = customerName;
        this.box = box;
    }

    public void deliver() {
        System.out.println("deliver box to customer: " + customerName);
        I item = box.item();
        System.out.println("my job is done! :)");
    }
}

package jo.edu.htu.util;

public interface Factory<ITEM extends Stationery> {

    ITEM newItem();
}

class PenFactory implements Factory<Pen> {

    @Override
    public Pen newItem() {
        return new Pen();
    }
}

class PencilFactory implements Factory<Pencil> {

    @Override
    public Pencil newItem() {
        return new Pencil();
    }
}

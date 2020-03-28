package jo.edu.htu.util;

public interface Factory<ITEM> {

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

class SingleItemFactory<T> implements Factory<T> {

    private T item;

    SingleItemFactory(T item) {
        this.item = item;
    }

    @Override
    public T newItem() {
        return item;
    }
}
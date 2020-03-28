package jo.edu.htu.util;

public abstract class StationeryBox<S extends Stationery>
        extends Box<S> {
}

class PenBox extends StationeryBox<Pen> {

}

class PencilBox extends StationeryBox<Pencil> {

}

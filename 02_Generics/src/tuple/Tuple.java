package tuple;

public class Tuple<E, T> {
    private E item1;
    private T item2;

    public Tuple(E item1, T item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    public E getItem1() {
        return this.item1;
    }

    public T getItem2() {
        return this.item2;
    }
}

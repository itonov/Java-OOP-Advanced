package threeuple;

public class Threeuple<T, E, R> {
    private T item1;
    private E item2;
    private R item3;

    public Threeuple(T item1, E item2, R item3) {
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
    }

    public T getItem1() {
        return this.item1;
    }

    public E getItem2() {
        return this.item2;
    }

    public R getItem3() {
        return this.item3;
    }
}

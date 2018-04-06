package jarOfT;

import java.util.ArrayDeque;
import java.util.Deque;

public class Jar<T> {
    private Deque<T> container;

    public Jar() {
        this.container = new ArrayDeque<>();
    }

    public void add(T element) {
        this.container.addLast(element);
    }

    public T remove() {
        return this.container.removeLast();
    }
}

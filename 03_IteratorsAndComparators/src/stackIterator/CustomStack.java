package stackIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomStack<T extends Integer> implements Iterable<Integer> {
    private List<Integer> data;

    public CustomStack() {
        this.data = new ArrayList<>();
    }

    public void push(int[] numbers) {
        for (int num : numbers) {
            this.data.add(0, num);
        }
    }

    public int pop() {
        if (this.data.size() == 0) {
            throw new IllegalArgumentException("No elements");
        }

        return this.data.remove(0);
    }

    @Override
    public Iterator iterator() {
        return new StackIterator();
    }

    private final class StackIterator implements Iterator<Integer> {
        int index = 0;

        @Override
        public boolean hasNext() {
            return this.index < data.size();
        }

        @Override
        public Integer next() {
            return data.get(this.index++);
        }
    }
}

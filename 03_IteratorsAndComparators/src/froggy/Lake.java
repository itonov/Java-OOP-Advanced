package froggy;

import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer> {
    private List<Integer> data;

    public Lake(List<Integer> data) {
        this.data = data;
    }

    public int getSize() {
        return this.data.size();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    private final class Frog implements Iterator<Integer> {
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

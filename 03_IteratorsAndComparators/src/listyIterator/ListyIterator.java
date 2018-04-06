package listyIterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterator, Iterable {
    private List<String> data;
    private int index;

    public ListyIterator(String... data) {
        this.data = Arrays.asList(data);
        this.index = 0;
    }

    public boolean move() {
        if (this.index + 1 == this.data.size()) {
            return false;
        } else {
            this.index++;
            return true;
        }
    }

    public String print() {
        if (this.data.isEmpty()) {
            throw new IllegalStateException("Invalid Operation!");
        }

        return this.data.get(this.index);
    }

    public String printAll() {
        StringBuilder sb = new StringBuilder(this.data.get(0));

        for (int i = 1; i < this.data.size(); i++) {
            sb.append(" ").append(this.data.get(i));
        }

        return sb.toString();
    }

    @Override
    public boolean hasNext() {
        return this.index + 1< this.data.size();
    }

    @Override
    public Object next() {
        return null;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    private final class ListIterator implements Iterator {
        int index = 0;

        @Override
        public boolean hasNext() {
            return this.index < data.size();
        }

        @Override
        public Object next() {
            return data.get(this.index++);
        }
    }
}

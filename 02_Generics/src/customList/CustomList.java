package customList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomList<T extends Comparable<T>> implements Iterable {
    private List<T> data;

    public CustomList() {
        this.data = new ArrayList<>();
    }

    public List<T> getData() {
        return this.data;
    }

    void add(T element) {
        this.data.add(element);
    }

    T remove(int index) {
        return this.data.remove(index);
    }

    boolean contains(T element) {
        return this.data.contains(element);
    }

    void swap(int index1, int index2) {
        T temp = this.data.get(index1);
        this.data.set(index1, this.data.get(index2));
        this.data.set(index2, temp);

    }

    int countGreaterThan(T element) {
        int counter = 0;

        for (T currentElement : this.data) {
            if (currentElement.compareTo(element) > 0) {
                counter++;
            }
        }

        return counter;
    }

    T getMax() {
        T element = this.data.get(0);

        for (int i = 1; i < this.data.size(); i++) {
            T currentElement = this.data.get(i);
            if (element.compareTo(currentElement) < 0) {
                element = currentElement;
            }
        }

        return element;
    }

    T getMin() {
        T element = this.data.get(0);

        for (int i = 1; i < this.data.size(); i++) {
            T currentElement = this.data.get(i);
            if (element.compareTo(currentElement) > 0) {
                element = currentElement;
            }
        }

        return element;
    }

    @Override
    public Iterator iterator() {
        return this.data.iterator();
    }
}

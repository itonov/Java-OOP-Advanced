package genericBox;

import java.util.List;

public class Box<T> {
    private List<T> data;

    public Box(List<T> data) {
        this.data = data;
    }

    public String swap(List<T> list, int firstIndex, int secondIndex) {
        T tempElement = list.get(firstIndex);
        list.set(firstIndex, list.get(secondIndex));
        list.set(secondIndex, tempElement);

        StringBuilder sb = new StringBuilder();
        T firstElement = list.get(0);
        sb.append(firstElement.getClass().getName()).append(String.format(": %s", firstElement));

        for (int i = 1; i < list.size(); i++) {
            T currentElement = list.get(i);
            sb.append(System.lineSeparator()).append(currentElement.getClass().getName())
                    .append(String.format(": %s", currentElement));
        }

        return sb.toString();
    }

    public <T extends Comparable<T>> int countOfElement(List<T> list, T elementToCheck) {
        int counter = 0;

        for (T element : list) {
            if (element.compareTo(elementToCheck) > 0) {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        T firstElement = this.data.get(0);
        sb.append(firstElement.getClass().getName()).append(String.format(": %s", firstElement));

        for (int i = 1; i < this.data.size(); i++) {
            T currentElement = data.get(i);
            sb.append(System.lineSeparator()).append(currentElement.getClass().getName())
                    .append(String.format(": %s", currentElement));
        }
        return sb.toString();
    }
}

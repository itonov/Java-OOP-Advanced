package customList;

import java.util.List;

public class Sorter {

    public static <T extends Comparable<T>> void Sort(List<T> list) {
        int n = list.size();
        T temp;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {

                if (list.get(j - 1).compareTo(list.get(j)) > 0) {
                    temp = list.get(j - 1);
                    list.set(j - 1, list.get(j));
                    list.set(j, temp);
                }

            }
        }
    }
}

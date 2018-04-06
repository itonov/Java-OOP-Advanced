package extendedArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.BiFunction;

public class ExtendedArrayList<T extends Comparable> extends ArrayList<T> {

    public T min() {
        BiFunction<T, T, Boolean> function = (t, t2) -> t.compareTo(t2) > 0;
        return getMaxOrMin(function);
    }

    public T max() {
        BiFunction<T, T, Boolean> function = (t, t2) -> t.compareTo(t2) < 0;
        return getMaxOrMin(function);
    }

    private T getMaxOrMin(BiFunction<T, T, Boolean> function) {
        T maxOrMin = null;
        Iterator<T> iterator = super.iterator();
        while (iterator.hasNext()) {
            T nextElement = iterator.next();
            if (maxOrMin == null || function.apply(maxOrMin, nextElement)) {
                maxOrMin = nextElement;
            }
        }

        return maxOrMin;
    }

    public static void main(String[] args) {
        ExtendedArrayList<Integer> list = new ExtendedArrayList<>();
        list.add(100);
        list.add(1001);
        list.add(-1001);
        System.out.println(list.max());
        System.out.println(list.min());
    }
}

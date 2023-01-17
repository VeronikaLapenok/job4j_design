package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return compareMaxMin(value, comparator);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return compareMaxMin(value, comparator.reversed());
    }

    public <T> T compareMaxMin(List<T> value, Comparator<T> comparator) {
        if (value.isEmpty()) {
            throw new IllegalArgumentException();
        }

        T max = value.get(0);
        for (T element : value) {
            max = comparator.compare(max, element) > 0 ? max : element;
        }
        return max;
    }
}

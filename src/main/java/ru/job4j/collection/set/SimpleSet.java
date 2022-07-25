package ru.job4j.collection.set;

import ru.job4j.collection.list.SimpleArrayList;

import java.util.Iterator;
import java.util.Objects;

/**
 * Set data structure implementation based on ArrayList
 *
 * @author Veranika Lapianok
 */
public class SimpleSet<T> implements Set<T> {
    private SimpleArrayList<T> set = new SimpleArrayList<>();

    /**
     * Adds element to the set
     * @param value of the added element
     * @return result of the operation (boolean)
     */
    @Override
    public boolean add(T value) {
        boolean result = false;
        if (!contains(value)) {
            set.add(value);
            result = true;
        }
        return result;
    }

    /**
     * Checks if set already contains such an element
     * @param value of checked element
     * @return result of the operation (boolean)
     */
    @Override
    public boolean contains(T value) {
        boolean result = false;
        for (T element : set) {
            if (Objects.equals(element, value)) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}

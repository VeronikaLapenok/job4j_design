package ru.job4j.collection.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ConcurrentModificationException;
import java.util.Objects;
import java.util.NoSuchElementException;

/**
 * Creates a list implementation based on a dynamic
 * array, analogous to ArrayList
 *
 * @author Veranika Lapianok
 */
public class SimpleArrayList<T> implements List<T> {
    private T[] container;
    private int size;
    private int modCount;

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    /**
     * Increased container's size
     */
    private void increaseSize() {
        if (container.length == 0) {
            container = Arrays.copyOf(container, 2);
        }
        container = Arrays.copyOf(container, container.length * 2 + 1);
    }

    /**
     * Adds a new element. Container must be dynamic
     * If the array is full, double its size.
     *
     * @param value - value of a new element
     */
    @Override
    public void add(T value) {
        if (container.length == size) {
            increaseSize();
        }
        container[size] = value;
        size++;
        modCount++;
    }

    /**
     * Sets a new value at given index
     *
     * @param index - given index
     * @param newValue - new value
     * @return previous value
     */
    @Override
    public T set(int index, T newValue) {
        T result = get(index);
        container[index] = newValue;
        return result;
    }

    /**
     * Removes value at given index
     *
     * @param index - given index
     * @return removed value
     */
    @Override
    public T remove(int index) {
        T result = get(index);
        System.arraycopy(container, index + 1, container, index,
                container.length - index - 1);
        container[container.length - 1] = null;
        size--;
        modCount++;
        return result;
    }

    /**
     * Gets value at given index
     * @param index - given index
     * @return value
     */
    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return container[index];
    }

    /**
     * Gets size of array
     *
     * @return size of array
     */
    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        int expectedModCount = modCount;
                return new Iterator<T>() {
                    private int index = 0;
            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return index < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[index++];
            }
        };
    }
}

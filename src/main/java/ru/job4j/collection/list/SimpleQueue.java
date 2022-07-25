package ru.job4j.collection.list;

import java.util.NoSuchElementException;

/**
 * Queue data structure implementation using two stacks
 *
 * @author Veronika Lapenok
 */
public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    /**
     * Deletes element
     * @return value of the deleted element
     */
    public T poll() {
        while (!in.isEmpty()) {
            out.push(in.pop());
        }
        if (out.isEmpty()) {
            throw new NoSuchElementException();
        }
        T value = out.pop();

        while (!out.isEmpty()) {
            in.push(out.pop());
        }

        return value;
    }

    /**
     * Adds element
     * @param value - value of element
     */
    public void push(T value) {
        in.push(value);
    }
}

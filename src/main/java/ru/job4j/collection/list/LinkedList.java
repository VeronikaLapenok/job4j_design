package ru.job4j.collection.list;

public interface LinkedList<E> extends Iterable<E> {
    void add(E value);

    E get(int index);
}

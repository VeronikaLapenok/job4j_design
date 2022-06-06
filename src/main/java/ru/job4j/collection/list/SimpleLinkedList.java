package ru.job4j.collection.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements LinkedList<E> {
    private Node<E> firstNode;
    private Node<E> lastNode;
    private int size = 0;
    private int modCount = 0;

    private static class Node<E> {
        private E currentElement;
        private Node<E> next;

        Node(E currentElement) {
            this.currentElement = currentElement;
            this.next = null;
        }
    }

    /**
     * Adds a new element to the end of the linked list
     * @param value - value of an element to add (generic type)
     */
    @Override
    public void add(E value) {
        Node<E> newNode = new Node<>(value);
        Node<E> currentNode = lastNode;
        lastNode = newNode;
        if (currentNode == null) {
            firstNode = newNode;
        } else {
            currentNode.next = newNode;
        }
        size++;
        modCount++;
    }

    /**
     * Gets element using index
     * @param index - index of the element (int )
     * @return element
     */
    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> currentNode = firstNode;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.currentElement;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;
            private final int expectedModCount = modCount;
            private Node<E> currentNode = firstNode;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return index < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E next = currentNode.currentElement;
                currentNode = currentNode.next;
                index++;
                return next;
            }
        };
    }
}

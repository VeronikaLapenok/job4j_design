package ru.job4j.collection.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Creates container based on LinkedList
 *
 * @author Veranika Lapianok
 */
public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> tail;

    /**
     * Checks if a linkedList is empty
     * @return true/false
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Adds an element to the linkedList
     * @param value - value of an element to add (generic type)
     */
    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    /**
     * Adds the first element(head) to the linkedList
     * @param value - value of an element to add (generic type)
     */
    public void addFirst(T value) {
        head = new Node<>(value, head);
    }

    /**
     * Deletes the first element(head) from the linkedList
     * @return value of the deleted element
     */
    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> tmpNode = head;
        T tmpValue = head.value;
        head = head.next;
        tmpNode.next = null;
        tmpNode.value = null;
        return tmpValue;
    }

    /**
     * Reverts the linkedList
     * @return true/false
     */
    public boolean revert() {
        boolean result = false;

        if (!isEmpty() && head.next != null) {
            tail = head;
            Node<T> current = head.next;
            head.next = null;

            while (current != null) {
               Node<T> next = current.next;
               current.next = head;
               head = current;
               current = next;
            }
            result = true;
        }
        return result;
    }

    /**
     * Creates iterator for the linkedList
     * @return object Iterator
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}

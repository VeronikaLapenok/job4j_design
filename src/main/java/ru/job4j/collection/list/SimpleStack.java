package ru.job4j.collection.list;

/**
 * Stack data structure implementation based on a LinkedList
 *
 * @author Veronika Lapenok
 */
public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<>();

    /**
     * Deletes element from stack
     * @return value of the deleted element
     */
    public T pop() {
        return linked.deleteFirst();
    }

    /**
     * Adds element to stack
     * @param value
     */
    public void push(T value) {
        linked.addFirst(value);
    }

    /**
     * Checks if stack is empty
     * @return result of the operation (boolean)
     */
    public boolean isEmpty() {
        return linked.isEmpty();
    }
}

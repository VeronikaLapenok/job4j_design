package ru.job4j.collection.tree;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

/**
 * Tree data structure implementation
 *
 * @author Veronika Lapenok
 */
public class SimpleTree<E> implements Tree<E> {
    private final Node<E> root;

    public SimpleTree(final E root) {
        this.root = new Node<>(root);
    }

    /**
     * Finds a node by value parent and adds a child node
     * to parent node
     *
     * @param parent - parent value
     * @param child - child value
     * @return result of the operation (boolean)
     */
    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        Optional<Node<E>> parentOpt = findBy(parent);
        if (parentOpt.isPresent() && findBy(child).isEmpty()) {
            parentOpt.get().getChildren().add(new Node<>(child));
            result = true;
        }
        return result;
    }

    /**
     * Finds node by value
     * @param value - value for searching
     * @return result - found node (Optional<Node<E>>)
     */
    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> result = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.getValue().equals(value)) {
                result = Optional.of(el);
                break;
            }
            data.addAll(el.getChildren());
        }
        return result;
    }
}

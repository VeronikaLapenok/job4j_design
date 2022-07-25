package ru.job4j.collection.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * HashMap data structure implementation
 *
 * @author Veronika Lapenok
 */
public class SimpleMap<K, V> implements Map<K, V> {
    private static final float LOAD_FACTOR = 0.75f;
    private int capacity = 8;
    private int count = 0;
    private int modCount = 0;
    private MapEntry<K, V>[] table = new MapEntry[capacity];

    /**
     * Adds a key-value pair to a map container
     * @param key - added unique key
     * @param value - added value
     * @return result of the operation (boolean)
     */
    @Override
    public boolean put(K key, V value) {
        boolean result = false;

        if ((float) count / capacity >= LOAD_FACTOR) {
            expand();
        }

        int index = key == null ? 0 : indexFor(hash(key.hashCode()));
        if (table[index] == null) {
            table[index] = new MapEntry<>(key, value);
            count++;
            modCount++;
            result = true;
        }
        return result;
    }

    private int hash(int hashCode) {
        return hashCode ^ hashCode >>> 16;
    }

    private int indexFor(int hash) {
        return hash & (capacity - 1);
    }

    private void expand() {
        capacity *= 2;
        MapEntry<K, V>[] expandedTable = new MapEntry[capacity];
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                int hashcode = (table[i].key == null) ? 0 : table[i].key.hashCode();
                int index = indexFor(hash(hashcode));
                if (expandedTable[index] == null) {
                    expandedTable[index] = table[i];
                }
            }
        }
        table = expandedTable;
    }

    /**
     * Gets value by key
     * @param key - value of key
     * @return value
     */
    @Override
    public V get(K key) {
        V result = null;
        int index = (key == null) ? 0 : hash(key.hashCode());
        if (table[index] != null && Objects.equals(table[index].key, key)) {
            result = table[index].value;
        }
        return result;
    }

    /**
     * Removes a key-value pair by key
     * @param key - value of key
     * @return result of the operation (boolean)
     */
    @Override
    public boolean remove(K key) {
        boolean result = false;
        int index = (key == null) ? 0 : indexFor(hash(key.hashCode()));
        if (table[index] != null && Objects.equals(table[index].key, key)) {
            table[index] = null;
            count--;
            modCount++;
            result = true;
        }
        return result;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            private int expectedModCount = modCount;
            private int index = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (index < table.length && table[index] == null) {
                    index++;
                }
                return index < table.length;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[index++].key;
            }
        };
    }

    private static class MapEntry<K, V> {
        private K key;
        private V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}

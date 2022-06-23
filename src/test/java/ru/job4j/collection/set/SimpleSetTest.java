package ru.job4j.collection.set;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.collection.list.SimpleArrayList;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SimpleSetTest {
    @Test
    public void whenAddNonNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.contains(1));
        assertFalse(set.add(1));
    }

    @Test
    public void whenAddNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(null));
        assertTrue(set.contains(null));
        assertFalse(set.add(null));
    }

    @Test
    public void whenContainsThenTrue() {
        Set<Integer> set = new SimpleSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        assertTrue(set.contains(2));
    }

    @Test
    public void whenNotContainsThenFalse() {
        Set<Integer> set = new SimpleSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        assertFalse(set.contains(5));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetIteratorFromEmptySetThenNextThrowException() {
        Set<Integer> set = new SimpleSet<>();
        set.iterator().next();
    }

    @Test
    public void whenCheckIterator() {
        Set<Integer> set = new SimpleSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        Iterator<Integer> iterator = set.iterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(Integer.valueOf(1), iterator.next());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(Integer.valueOf(2), iterator.next());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(Integer.valueOf(3), iterator.next());
        Assert.assertFalse(iterator.hasNext());
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenAddAfterGetIteratorThenMustBeException() {
        Set<Integer> set = new SimpleSet<>();
        Iterator<Integer> iterator = set.iterator();
        set.add(4);
        iterator.next();
    }
}
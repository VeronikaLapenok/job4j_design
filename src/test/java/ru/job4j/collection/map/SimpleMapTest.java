package ru.job4j.collection.map;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleMapTest {
    @Test
    public void whenPutThanTrue() {
        Map<Integer, String> testMap = new SimpleMap<>();
        assertTrue(testMap.put(1, "val1"));
    }

    @Test
    public void whenPutTwoNullThanFalse() {
        Map<Integer, String> testMap = new SimpleMap<>();
        testMap.put(null, "val1");
        assertThat(testMap.get(null), is("val1"));
        assertFalse(testMap.put(null, "val2"));
    }

    @Test
    public void whenPutMoreThanExpand() {
        Map<Integer, String> testMap = new SimpleMap<>();
        assertTrue(testMap.put(null, "val1"));
        assertTrue(testMap.put(2, "val2"));
        assertTrue(testMap.put(3, "val3"));
        assertTrue(testMap.put(4, "val4"));
        assertTrue(testMap.put(5, "val5"));
        assertTrue(testMap.put(6, "val6"));
        assertTrue(testMap.put(7, "val7"));
        assertTrue(testMap.put(8, "val8"));
        assertTrue(testMap.put(9, "val9"));
        assertTrue(testMap.put(10, "val10"));
    }

    @Test
    public void whenPutAndGet() {
        Map<Integer, String> testMap = new SimpleMap<>();
        testMap.put(1, "Dog");
        testMap.put(2, "Cat");
        testMap.put(3, "Cow");
        testMap.put(4, "Horse");
        assertThat(testMap.get(2), is("Cat"));
    }

    @Test
    public void whenRemoveThanTrue() {
        Map<Integer, String> testMap = new SimpleMap<>();
        testMap.put(1, "val1");
        assertTrue(testMap.remove(1));
    }

    @Test
    public void whenRemoveNullThanTrue() {
        Map<Integer, String> testMap = new SimpleMap<>();
        testMap.put(null, "val1");
        testMap.put(1, "val1");
        assertTrue(testMap.remove(null));
    }

    @Test
    public void whenRemoveAndGetThanNull() {
        Map<Integer, String> testMap = new SimpleMap<>();
        testMap.put(1, "val1");
        testMap.put(2, "val2");
        testMap.remove(2);
        assertNull(testMap.get(2));
    }
}

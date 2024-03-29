package ru.job4j.collection.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ListUtilsTest {
    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(input, is(Arrays.asList(1, 2, 3)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);
        assertThat(input, is(Arrays.asList(0, 1, 2, 3)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddAfterWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2));
        ListUtils.addBefore(input, 3, 3);
    }

    @Test
    public void whenRemoveIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(2, 1, 2, 3, 2));
        Predicate<Integer> filter = x -> x == 2;
        ListUtils.removeIf(input, filter);
        assertThat(input, is(Arrays.asList(1, 3)));
    }

    @Test
    public void whenReplaceIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Predicate<Integer> filter = x -> x % 2 == 0;
        ListUtils.replaceIf(input, filter, 0);
        assertThat(input, is(Arrays.asList(1, 0, 3, 0, 5, 0)));
    }

    @Test
    public void whenRemoveAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6));
        ListUtils.removeAll(input, Arrays.asList(0, 1, 2));
        assertThat(input, is(Arrays.asList(3, 4, 5, 6)));
    }
}
package ru.job4j.iterator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ArrayItTest {
    @Test
    void whenMultiCallHasNextThenTrue() {
        ArrayIt it = new ArrayIt(new int[] {1, 2, 3});
        boolean result = it.hasNext();
        assertThat(result).isTrue();
        assertThat(it.hasNext()).isTrue();
    }

    @Test
    void whenReadSequence() {
        ArrayIt it = new ArrayIt(new int[] {1, 2, 3});
        assertThat(it.next()).isEqualTo(1);
        assertThat(it.next()).isEqualTo(2);
        assertThat(it.next()).isEqualTo(3);
    }
}
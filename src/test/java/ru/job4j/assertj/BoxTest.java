package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatThis();
        assertThat(name).isEqualTo("Sphere")
                .isNotEmpty()
                .isNotBlank()
                .contains("ere")
                .startsWith("S");
    }

    @Test
    void isExist() {
        Box box = new Box(4, 12);
        boolean result = box.isExist();
        assertThat(result).isTrue()
                .isEqualTo(true)
                .isNotEqualTo(false);
    }

    @Test
    void whenNumberOfVertices5() {
        Box box = new Box(8, 20);
        int result = box.getNumberOfVertices();
        assertThat(result).isEqualTo(8)
                .isNotZero()
                .isPositive()
                .isLessThan(10)
                .isEven();

    }

    @Test
    void checkDoubleAreaCube() {
        Box box = new Box(8, 6);
        double result = box.getArea();
        assertThat(result).isEqualTo(216d, withPrecision(0.006d))
                .isCloseTo(216.1d, withPrecision(0.1d))
                .isGreaterThan(215d)
                .isLessThan(217d);
    }
}

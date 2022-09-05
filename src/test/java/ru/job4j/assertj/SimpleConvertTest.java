package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("one", "two", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("two")
                .contains("one", Index.atIndex(0))
                .containsAnyOf("zero", "two", "six")
                .doesNotContain("one", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("one", "one", "two", "three", "four", "five");
        assertThat(list).isNotEmpty()
                .hasSize(6)
                .containsExactly("one", "one", "two", "three", "four", "five")
                .containsOnly("one", "two", "three", "four", "five")
                .contains("five", "one")
                .doesNotContainNull()
                .doesNotContain("zero")
                .isNotNull()
                .startsWith("one")
                .endsWith("five")
                .first().isEqualTo("one");
        assertThat(list).last().isNotNull()
                .isEqualTo("five");
        assertThat(list).element(3).isNotNull()
                .isEqualTo("three");
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("1", "2", "3", "4", "5");
        assertThat(set).hasSize(5)
                .contains("3", "5")
                .containsExactlyInAnyOrder("4", "1", "2", "5", "3")
                .doesNotHaveDuplicates()
                .doesNotContainNull()
                .hasSizeLessThanOrEqualTo(8)
                .hasSizeBetween(1, 10);
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("one", "two", "three", "four", "five");
        assertThat(map).hasSize(5)
                .containsKeys("two", "three")
                .containsOnlyKeys("one", "two", "three", "four", "five")
                .containsValues(0, 2, 4)
                .doesNotContainKey("zero")
                .doesNotContainValue(8)
                .containsEntry("one", 0);
    }
}

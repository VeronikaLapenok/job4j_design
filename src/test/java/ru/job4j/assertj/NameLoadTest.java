package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NameLoadTest {
    private final NameLoad nameLoad = new NameLoad();

    @Test
    void checkEmpty() {
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void ifNamesArrayIsEmpty() {
        assertThatThrownBy(nameLoad::parse)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Names array is empty");
    }

    @Test
    void ifNameDoesNotContainEqualSign() {
        assertThatThrownBy(() -> nameLoad.parse("name-Ivan"))
                .hasMessageContaining("does not contain the symbol")
                .hasMessageContaining("Ivan");
    }

    @Test
    void ifNameDoesNotContainKey() {
        assertThatThrownBy(() -> nameLoad.parse("=Ivan"))
                .hasMessageContaining("not contain a key")
                .hasMessageContaining("=Ivan");
    }

    @Test
    void ifNameDoesNotContainValue() {
        assertThatThrownBy(() -> nameLoad.parse("name="))
                .hasMessageContaining("this name: name= does not contain a value");
    }
}

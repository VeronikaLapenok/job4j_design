package ru.job4j.io;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class ConfigTest {
    @Test
    public void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Veronika Lapenok"));
    }

    @Test
    public void whenPairWithComment() {
        String path = "./data/pair_with_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("city"), is("Vilnius"));
    }

    @Test
    public void whenPairWithCommentAndBlankLine() {
        String path = "./data/pair_with_comment_and_blank_line.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("e-mail"), is("veronika.lapenok.yr@gmail.com"));
    }

    @Test
    public void whenPairWithoutKeyException() {
        String path = "./data/pair_without_key.properties";
        Config config = new Config(path);
        Throwable exception = catchThrowable(config::load);
        assertThat(exception).isInstanceOf(IllegalArgumentException.class);
        assertEquals(exception.getMessage(), "Illegal pattern key-value: \"=Veronika Lapenok\"");
    }

    @Test
    public void whenPairWithoutValueException() {
        String path = "./data/pair_without_value.properties";
        Config config = new Config(path);
        Throwable exception = catchThrowable(config::load);
        assertThat(exception).isInstanceOf(IllegalArgumentException.class);
        assertEquals(exception.getMessage(), "Illegal pattern key-value: \"file=\"");
    }

    @Test
    public void whenPairWithoutEqualSignException() {
        String path = "./data/pair_without_equal_sign.properties";
        Config config = new Config(path);
        Throwable exception = catchThrowable(config::load);
        assertThat(exception).isInstanceOf(IllegalArgumentException.class);
        assertEquals(exception.getMessage(), "Illegal pattern key-value: \"file:config\"");
    }
}

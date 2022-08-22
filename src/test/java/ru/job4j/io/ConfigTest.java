package ru.job4j.io;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

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

    @Test(expected = IllegalArgumentException.class)
    public void whenPairWithoutKeyException() {
        String path = "./data/pair_without_key.properties";
        Config config = new Config(path);
        config.load();
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPairWithoutValueException() {
        String path = "./data/pair_without_value.properties";
        Config config = new Config(path);
        config.load();
    }
}

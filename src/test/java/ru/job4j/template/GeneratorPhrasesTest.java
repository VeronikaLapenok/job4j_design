package ru.job4j.template;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

@Disabled("Тесты отключены. Удалить аннотацию после реализации всех методов по заданию.")
public class GeneratorPhrasesTest {
    @Test
    public void whenProduceWorksCorrect() {
        Generator generator = new GeneratorPhrases();
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> args = Map.of("name", "Petr Arsentev", "subject", "you");
        String result = "I am a Petr Arsentev, Who are you? ";
        assertThat(result).isEqualTo(generator.produce(template, args));
    }

    @Test
    public void whenProduceWorksIncorrect() {
        Generator generator = new GeneratorPhrases();
        String template = "I am a ${surname}, Who are ${subject}? ";
        Map<String, String> args = Map.of("name", "Petr Arsentev", "subject", "you");
        assertThatThrownBy(() -> generator.produce(template, args))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenManyKeysInMapThenException() {
        Generator generator = new GeneratorPhrases();
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> args = Map.of("name", "Petr", "surname", "Arsentev", "subjet", "you");
        assertThatThrownBy(() -> generator.produce(template, args))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

package io.github.gabbloquet.tddtraining.Bonjour;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Objects;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BonjourTest {

    private final HourSupplier hourSupplier = mock(HourSupplier.class);

    @Test
    void should_clean_firstname() {
        Bonjour bonjour = getBonjour(null);

        assertThat(bonjour.greet("  Gabin ")).isEqualTo("Bonjour Gabin");
    }

    @Test
    void should_uppercase_the_first_letter() {
        Bonjour bonjour = getBonjour(null);

        assertThat(bonjour.greet("hervé")).isEqualTo("Bonjour Hervé");
    }

    @ParameterizedTest
    @ValueSource(ints = {6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17})
    void should_greet_with_firstname(int hour) {
        Bonjour bonjour = getBonjour(hour);

        assertThat(bonjour.greet("Gabin")).isEqualTo("Bonjour Gabin");
    }

    @ParameterizedTest
    @ValueSource(ints = {18, 19, 20, 21, 22})
    void should_say_bonsoir_if_hour_between_18_and_22(int hour) {
        Bonjour bonjour = getBonjour(hour);

        assertThat(bonjour.greet("  hervé ")).isEqualTo("Bonsoir Hervé");
    }

    @ParameterizedTest
    @ValueSource(ints = {23, 0, 1, 2, 3, 4, 5})
    void should_say_bonne_nuit_if_hour_between_23_and_5(int hour) {
        Bonjour bonjour = getBonjour(hour);

        assertThat(bonjour.greet("  hervé ")).isEqualTo("Bonne nuit Hervé");
    }

    private Bonjour getBonjour(Integer hour) {
        if (Objects.isNull(hour)) {
            when(hourSupplier.getHour()).thenReturn(6);
        } else {
            when(hourSupplier.getHour()).thenReturn(hour);
        }
        return new Bonjour(hourSupplier);
    }
}

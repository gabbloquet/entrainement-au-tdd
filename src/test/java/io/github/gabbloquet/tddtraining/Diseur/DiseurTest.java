package io.github.gabbloquet.tddtraining.Diseur;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DiseurTest {

    private final Diseur diseur = new Diseur();

    @ParameterizedTest
    @CsvSource({
        "1, 11",
        "11, 21",
        "21, 1211",
        "1211, 111221",
        "111221, 312211",
        "312211, 13112221"
    })
    void should_return_expected_value_for_given_input(String input, String expected) {
        assertThat(diseur.next(input)).isEqualTo(expected);
    }
}
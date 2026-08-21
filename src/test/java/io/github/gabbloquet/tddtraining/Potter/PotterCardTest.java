package io.github.gabbloquet.tddtraining.Potter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PotterCardTest {

    @Test
    void zero_if_card_is_empty() {
        PotterCard card = new PotterCard();
        assertThat(card.getAmount()).isZero();
    }

    @ParameterizedTest
    @ValueSource(strings = {"À l’école des sorciers", "La Chambre des secrets"})
    void a_book_alone_price_is_8(String book) {
        PotterCard card = new PotterCard();

        card.addBook(book);

        assertThat(card.getAmount()).isEqualTo(8);
    }

    @Test
    void three_same_books_price_is_24() {
        PotterCard card = new PotterCard();

        card.addBook("À l’école des sorciers");
        card.addBook("À l’école des sorciers");
        card.addBook("À l’école des sorciers");

        assertThat(card.getAmount()).isEqualTo(24);
    }

    @Test
    void two_different_books_discount_of_5_percent() {
        PotterCard card = new PotterCard();

        card.addBook("À l’école des sorciers");
        card.addBook("La Chambre des secrets");

        assertThat(card.getAmount()).isEqualTo(15.2);
    }

    @Test
    void three_different_books_discount_of_10_percent() {
        PotterCard card = new PotterCard();

        card.addBook("À l’école des sorciers");
        card.addBook("La Chambre des secrets");
        card.addBook("Le Prisonnier d'Azkaban");

        assertThat(card.getAmount()).isEqualTo(21.6);
    }

    @Test
    void three_different_books_discount_of_20_percent() {
        PotterCard card = new PotterCard();

        card.addBook("À l’école des sorciers");
        card.addBook("La Chambre des secrets");
        card.addBook("Le Prisonnier d'Azkaban");
        card.addBook("La Coupe de feu");
        card.addBook("L'Ordre du phénix");

        assertThat(card.getAmount()).isEqualTo(32);
    }

    @Test
    void two_same_books_and_one_different__only_one_discount() {
        PotterCard card = new PotterCard();

        card.addBook("À l’école des sorciers");
        card.addBook("À l’école des sorciers");
        card.addBook("La Chambre des secrets");

        assertThat(card.getAmount()).isEqualTo(15.2 + 8);
    }

    @Test
    void two_same_books_and_two_different__two_little_discounts() {
        PotterCard card = new PotterCard();

        card.addBook("À l’école des sorciers");
        card.addBook("À l’école des sorciers");
        card.addBook("La Chambre des secrets");
        card.addBook("La Chambre des secrets");

        assertThat(card.getAmount()).isEqualTo(15.2 + 15.2);
    }

    @Test
    void three_same_books_and_two_different__only_two_discounts() {
        PotterCard card = new PotterCard();

        card.addBook("À l’école des sorciers");
        card.addBook("À l’école des sorciers");
        card.addBook("À l’école des sorciers");
        card.addBook("La Chambre des secrets");
        card.addBook("La Chambre des secrets");

        assertThat(card.getAmount()).isEqualTo(15.2 + 15.2 + 8);
    }
}
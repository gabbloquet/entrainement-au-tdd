package io.github.gabbloquet.tddtraining.Potter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PotterCardTest {

    @Test
    void zero_if_card_is_empty() {
        PotterCard card = new PotterCard();
        assertEquals(0, card.getAmount());
    }

    @ParameterizedTest
    @ValueSource(strings = {"À l’école des sorciers", "La Chambre des secrets"})
    void a_book_alone_price_is_8(String book) {
        PotterCard card = new PotterCard();

        card.addBook(book);

        assertEquals(8, card.getAmount());
    }

    @Test
    void three_same_books_price_is_24() {
        PotterCard card = new PotterCard();

        card.addBook("À l’école des sorciers");
        card.addBook("À l’école des sorciers");
        card.addBook("À l’école des sorciers");

        assertEquals(24, card.getAmount());
    }

    @Test
    void two_different_books_discount_of_5_percent() {
        PotterCard card = new PotterCard();

        card.addBook("À l’école des sorciers");
        card.addBook("La Chambre des secrets");

        assertEquals(15.2, card.getAmount());
    }

    @Test
    void three_different_books_discount_of_10_percent() {
        PotterCard card = new PotterCard();

        card.addBook("À l’école des sorciers");
        card.addBook("La Chambre des secrets");
        card.addBook("Le Prisonnier d'Azkaban");

        assertEquals(21.6, card.getAmount());
    }

    @Test
    void three_different_books_discount_of_20_percent() {
        PotterCard card = new PotterCard();

        card.addBook("À l’école des sorciers");
        card.addBook("La Chambre des secrets");
        card.addBook("Le Prisonnier d'Azkaban");
        card.addBook("La Coupe de feu");
        card.addBook("L'Ordre du phénix");

        assertEquals(32, card.getAmount());
    }

    @Test
    void two_same_books_and_one_different__only_one_discount() {
        PotterCard card = new PotterCard();

        card.addBook("À l’école des sorciers");
        card.addBook("À l’école des sorciers");
        card.addBook("La Chambre des secrets");

        assertEquals(15.2 + 8, card.getAmount());
    }

    @Test
    void two_same_books_and_two_different__two_little_discounts() {
        PotterCard card = new PotterCard();

        card.addBook("À l’école des sorciers");
        card.addBook("À l’école des sorciers");
        card.addBook("La Chambre des secrets");
        card.addBook("La Chambre des secrets");

        assertEquals(15.2 + 15.2, card.getAmount());
    }

    @Test
    void three_same_books_and_two_different__only_two_discounts() {
        PotterCard card = new PotterCard();

        card.addBook("À l’école des sorciers");
        card.addBook("À l’école des sorciers");
        card.addBook("À l’école des sorciers");
        card.addBook("La Chambre des secrets");
        card.addBook("La Chambre des secrets");

        assertEquals(15.2 + 15.2 + 8, card.getAmount());
    }
}
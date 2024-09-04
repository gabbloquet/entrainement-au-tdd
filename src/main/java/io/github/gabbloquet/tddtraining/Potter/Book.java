package io.github.gabbloquet.tddtraining.Potter;

public record Book(String title) {

    public static Book from(String title) {
        return new Book(title);
    }
}

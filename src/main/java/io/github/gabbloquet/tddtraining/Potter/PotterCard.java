package io.github.gabbloquet.tddtraining.Potter;

import java.util.ArrayList;
import java.util.List;

public class PotterCard {

    private static final int BOOK_PRICE = 8;
    private static final Double DISCOUNT_PER_BOOKS = 0.05;

    private final List<List<Book>> batches = new ArrayList<>() {{
        add(new ArrayList<>() {
        });
    }};

    public void addBook(String title) {
        int batchesNumber = 0;
        while (batchContainsTheBook(title, batchesNumber) && thereIsAnotherBatch(batchesNumber)) {
            batchesNumber++;
        }

        if(batchContainsTheBook(title, batchesNumber)) {
            createANewBatchWithThisBook(title);
        } else {
            this.batches.get(batchesNumber).add(Book.from(title));
        };
    }

    private void createANewBatchWithThisBook(String title) {
        this.batches.add(new ArrayList<>(List.of(Book.from(title))));
    }

    private boolean thereIsAnotherBatch(int batchesNumber) {
        return batches.size() > batchesNumber + 1;
    }

    private boolean batchContainsTheBook(String title, int batchesNumber) {
        return this.batches.get(batchesNumber).contains(Book.from(title));
    }

    public double getAmount() {
        return batches.stream()
            .map(this::getAmountOfABatch)
            .reduce(0.0, Double::sum);
    }

    private double getAmountOfABatch(List<Book> books) {
        int size = books.size();
        return size * BOOK_PRICE * (1 - (size - 1) * DISCOUNT_PER_BOOKS);
    }
}

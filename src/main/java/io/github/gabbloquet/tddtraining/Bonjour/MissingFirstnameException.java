package io.github.gabbloquet.tddtraining.Bonjour;

public class MissingFirstnameException extends RuntimeException {
    public MissingFirstnameException() {
        super("A firstname is required to greet someone.");
    }
}

package io.github.gabbloquet.tddtraining.Fraction;

public record Fraction(int numerator, int denominator) {

    @Override
    public String toString() {
        return String.format("%s/%s", numerator, denominator);
    }
}

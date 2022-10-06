package io.github.gabbloquet.tddtraining.Fraction;

public class NonIntegralSimplification extends RuntimeException {
    public NonIntegralSimplification(String fraction) {
        super(String.format("Il n'est pas possible de simplifier la fraction %s vers un nombre entier.", fraction));
    }
}

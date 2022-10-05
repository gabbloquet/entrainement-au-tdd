package io.github.gabbloquet.tddtraining.Fraction;

public class FractionCalculator {

    public Fraction add(Fraction firstFraction, Fraction secondFraction) {

        if(firstFraction.denominator() == secondFraction.denominator()){
            int numerator = firstFraction.numerator() + secondFraction.numerator();
            return new Fraction(numerator, firstFraction.denominator());
        }

        int multiplicator = firstFraction.denominator();
        firstFraction = multiplicate(firstFraction, secondFraction.denominator());
        secondFraction = multiplicate(secondFraction, multiplicator);

        return add(firstFraction, secondFraction);
    }

    private Fraction multiplicate(Fraction fraction, int multiplicator) {
        return new Fraction(
                fraction.numerator() * multiplicator,
                fraction.denominator() * multiplicator
        );
    }

    public Fraction subtract(Fraction firstFraction, Fraction secondFraction) {
        return null;
    }
}

package io.github.gabbloquet.tddtraining.Fraction;

public class FractionCalculator {

    public Fraction add(Fraction firstFraction, Fraction secondFraction) {

        if(hasSameDenominateur(firstFraction, secondFraction)){
            int numerator = firstFraction.numerator() + secondFraction.numerator();
            return new Fraction(numerator, firstFraction.denominator());
        }

        int multiplicator = firstFraction.denominator();
        firstFraction = multiplicate(firstFraction, secondFraction.denominator());
        secondFraction = multiplicate(secondFraction, multiplicator);

        return add(firstFraction, secondFraction);
    }

    public Fraction subtract(Fraction firstFraction, Fraction secondFraction) {
        if(hasSameDenominateur(firstFraction, secondFraction)){
            int numerator = firstFraction.numerator() - secondFraction.numerator();
            return new Fraction(numerator, firstFraction.denominator());
        }

        int multiplicator = firstFraction.denominator();
        firstFraction = multiplicate(firstFraction, secondFraction.denominator());
        secondFraction = multiplicate(secondFraction, multiplicator);

        return subtract(firstFraction, secondFraction);
    }

    public Fraction multiply(Fraction firstFraction, Fraction secondFraction) {
        int numerateur = firstFraction.numerator() * secondFraction.numerator();
        int denominateur = firstFraction.denominator() * secondFraction.denominator();
        return new Fraction( numerateur, denominateur);
    }

    public int divide(Fraction firstFraction, Fraction secondFraction) {
        return firstFraction.numerator() / secondFraction.numerator();
    }

    private Fraction multiplicate(Fraction fraction, int multiplicator) {
        return new Fraction(
                fraction.numerator() * multiplicator,
                fraction.denominator() * multiplicator
        );
    }

    private static boolean hasSameDenominateur(Fraction firstFraction, Fraction secondFraction) {
        return firstFraction.denominator() == secondFraction.denominator();
    }
}

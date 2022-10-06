package io.github.gabbloquet.tddtraining.Fraction;

public class FractionCalculator {

    public Fraction add(Fraction firstFraction, Fraction secondFraction) {

        if(hasSameDenominateur(firstFraction, secondFraction)){
            int numerator = firstFraction.numerator() + secondFraction.numerator();
            return new Fraction(numerator, firstFraction.denominator());
        }

        int denominator = firstFraction.denominator();
        firstFraction = putDenominator(firstFraction, secondFraction.denominator());
        secondFraction = putDenominator(secondFraction, denominator);

        return add(firstFraction, secondFraction);
    }

    public Fraction subtract(Fraction firstFraction, Fraction secondFraction) {

        if(hasSameDenominateur(firstFraction, secondFraction)){
            int numerator = firstFraction.numerator() - secondFraction.numerator();
            return new Fraction(numerator, firstFraction.denominator());
        }

        int multiplicator = firstFraction.denominator();
        firstFraction = putDenominator(firstFraction, secondFraction.denominator());
        secondFraction = putDenominator(secondFraction, multiplicator);

        return subtract(firstFraction, secondFraction);
    }

    public Fraction multiply(Fraction firstFraction, Fraction secondFraction) {
        int numerateur = firstFraction.numerator() * secondFraction.numerator();
        int denominateur = firstFraction.denominator() * secondFraction.denominator();
        return new Fraction( numerateur, denominateur);
    }

    public Fraction divide(Fraction firstFraction, Fraction secondFraction) {
        Fraction secondFractionOpposite = new Fraction(secondFraction.denominator(), secondFraction.numerator());
        return multiply(firstFraction, secondFractionOpposite);
    }

    public int simplify(Fraction fraction) {
        return fraction.numerator() / fraction.denominator();
    }

    private Fraction putDenominator(Fraction fraction, int multiplicator) {
        return new Fraction(
                fraction.numerator() * multiplicator,
                fraction.denominator() * multiplicator
        );
    }

    private static boolean hasSameDenominateur(Fraction firstFraction, Fraction secondFraction) {
        return firstFraction.denominator() == secondFraction.denominator();
    }
}

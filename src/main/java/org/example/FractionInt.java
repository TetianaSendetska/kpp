package org.example;

public class FractionInt implements Fraction{
    private int numerator;
    private int denominator;
    public int getNumerator() {
        return numerator;
    }
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }
    public int getDenominator() {
        return denominator;
    }
    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public FractionInt(){
        numerator = 0;
        denominator = 1;
    }
    public FractionInt(int nominator, int denominator) {
        if (denominator == 0) {
            throw new RuntimeException("Знаменник не може дорівнювати 0!");
        }
        this.numerator = nominator;
        this.denominator = denominator;
    }

    public String toString() {
        return numerator + "/" + denominator;
    }

}

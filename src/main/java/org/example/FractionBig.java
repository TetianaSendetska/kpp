package org.example;

import java.math.BigInteger;

public class FractionBig implements Fraction{

    private BigInteger numerator;
    private BigInteger denominator;

    public BigInteger getDenominator() {
        return denominator;
    }
    public void setDenominator(BigInteger denominator) {
        this.denominator = denominator;
    }
    public BigInteger getNumerator() {
        return numerator;
    }
    public void setNumerator(BigInteger numerator) {
        this.numerator = numerator;
    }
    public FractionBig(){
        numerator = BigInteger.valueOf(0);
        denominator = BigInteger.valueOf(1);
    }
    public FractionBig(int Nominator, int Denominator) {
        if (Denominator == 0) {
            throw new RuntimeException("Знаменник не може дорівнювати 0!");
        }
        this.numerator = BigInteger.valueOf(Nominator);
        this.denominator = BigInteger.valueOf(Denominator);
    }
    public FractionBig(BigInteger Nominator, BigInteger Denominator){
        if (Denominator.equals(BigInteger.ZERO)) {
            throw new RuntimeException("Знаменник не може дорівнювати 0!");
        }
        this.numerator = Nominator;
        this.denominator = Denominator;
    }

    public String toString() {
        return numerator + "/" + denominator;
    }

}


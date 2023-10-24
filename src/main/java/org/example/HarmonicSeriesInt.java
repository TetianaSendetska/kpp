package org.example;

public class HarmonicSeriesInt implements HarmonicSeries {
    public Fraction HarmonicSeries(int count) {
        FractionInt result = new FractionInt(0, 1);
        for(int i = 1; i <= count; ++i) {
            FractionInt fraction;
            fraction = new FractionInt(1, i);
            result = FractionMath.Add(result,fraction);
            int gcd = GCD.gcd(result.getNumerator(), result.getDenominator());
            result.setNumerator(result.getNumerator() / gcd);
            result.setDenominator(result.getDenominator() / gcd);
        }
        return result;
    }
}

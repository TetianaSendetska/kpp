package org.example;

import java.math.BigInteger;

public class HarmonicSeriesBig implements HarmonicSeries {
    public Fraction HarmonicSeries(int count) {
        FractionBig result = new FractionBig(0, 1);
        for(int i = 1; i <= count; ++i) {
            FractionBig fraction;
            fraction = new FractionBig(1, i);
            FractionBig tempResult = FractionMath.Add(result, fraction);
            BigInteger gcd = GCD.gcd(tempResult.getNumerator(), tempResult.getDenominator());
            tempResult.setNumerator(tempResult.getNumerator().divide(gcd));
            tempResult.setDenominator(tempResult.getDenominator().divide(gcd));
            result = tempResult;
        }
        return result;
    }
}

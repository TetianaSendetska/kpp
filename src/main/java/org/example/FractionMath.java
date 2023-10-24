package org.example;

import java.math.BigInteger;

public class FractionMath {

    public static FractionInt Add(FractionInt first, FractionInt second)
    {
        int numerator = first.getNumerator() * second.getDenominator() + second.getNumerator() * first.getDenominator();
        int denominator = first.getDenominator() * second.getDenominator();

        FractionInt sum;
        sum = new FractionInt(numerator, denominator);

        return sum;
    }
    public static FractionBig Add(FractionBig first, FractionBig second)
    {
        BigInteger numerator = first.getNumerator().multiply(second.getDenominator())
                .add(second.getNumerator().multiply(first.getDenominator()));
        BigInteger denominator = first.getDenominator().multiply(second.getDenominator());

        FractionBig sum;
        sum = new FractionBig(numerator, denominator);

        return sum;
    }
}

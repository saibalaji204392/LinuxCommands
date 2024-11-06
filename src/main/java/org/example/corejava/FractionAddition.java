package org.example.corejava;

public class FractionAddition {

    public static void main(String[] args) {
        int[] frac1 = {1, 3};
        int[] frac2 = {3, 9};
        int[] result1 = addFractions(frac1, frac2);
        System.out.println("Numerator: " + result1[0] + ", Denominator: " + result1[1]);

        int[] frac3 = {1, 2};
        int[] frac4 = {3, 2};
        int[] result2 = addFractions(frac3, frac4);
        System.out.println("Numerator: " + result2[0] + ", Denominator: " + result2[1]);
    }

    public static int[] addFractions(int[] frac1, int[] frac2) {
        int numerator1 = frac1[0];
        int denominator1 = frac1[1];
        int numerator2 = frac2[0];
        int denominator2 = frac2[1];

        int commonDenominator = denominator1 * denominator2;
        int newNumerator = (numerator1 * denominator2) + (numerator2 * denominator1);

        return simplifyFraction(newNumerator, commonDenominator);
    }

    private static int[] simplifyFraction(int numerator, int denominator) {
        int gcd = gcd(numerator, denominator);
        return new int[]{numerator / gcd, denominator / gcd};
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }
}


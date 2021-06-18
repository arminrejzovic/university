package com.company;

public class FractionTest {
    public static void main (String[] args){
        Fraction fraction1 = new Fraction(3,8);
        Fraction fraction2 = new Fraction();
        fraction2.setNumerator(4);
        fraction2.setDenominator(5);

        if (fraction1.equals(fraction2)){
            System.out.println("Fractions 1 and 2 are equal");
        }
        else {
            System.out.println("Fractions 1 and 2 are not equal");
        }

        System.out.println("Fraction1: "+ fraction1.toString());

        Fraction fraction3 = new Fraction();
        fraction3.setFraction();

        if (fraction1.equals(fraction3)){
            System.out.println("Fractions 1 and 2 are equal");
        }
        else {
            System.out.println("Fractions 1 and 2 are not equal");
        }

    }
}

package com.company;

import java.util.Objects;
import java.util.Scanner;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction() {
        numerator=0;
        denominator=1;
    }

    public void setFraction(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input numerator: ");
        int num = scanner.nextInt();
        setNumerator(num);
        System.out.println("Input denominator: ");
        int den = scanner.nextInt();
        setDenominator(den);
    }

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
        if (denominator!=0)
            this.denominator = denominator;
        else{
            System.out.println("Error: Denominator cannot be zero!");
            System.exit(0);
        }
    }

    private void printFraction(){
        System.out.println(this.numerator+"/"+this.denominator);
    }


    public boolean equals(Fraction otherFraction) {
        if (otherFraction == null) return false;
       else if (numerator == otherFraction.numerator && denominator == otherFraction.denominator){
            return true;
        }
       else if (((float)numerator/denominator)==((float) otherFraction.numerator/otherFraction.denominator)){
           return true;
        }
       else return false;

    }

    public String toString() {
        return numerator+"/"+denominator;
    }
}

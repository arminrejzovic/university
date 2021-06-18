package com.company;

public class Example {
    public static int countPositive (int[] x) {
        int count=0;
        for (int i=0; i<=x.length; i++) {
            if (x[i] > 0) {
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int[] ints = {3,-1,0,-2};
        System.out.println(countPositive(ints));
    }
}

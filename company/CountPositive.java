package com.company;
// Introduction to Software Testing
// Authors: Paul Ammann & Jeff Offutt
// Chapter 1, page 13
// Can be run from command line
// See CountPositveTest.java for JUnit tests

public class CountPositive
{
    /**
     * Counts positive elements in array
     *
     * @param x array to search
     * @return number of positive elements in x
     * @throws NullPointerException if x is null
     */
    public static int countPositive (int[] x)
    {
        int count = 0;

        for (int i=0; i < x.length; i++)
        {
            if (x[i] >= 0)
            {
                System.out.println("Executed");
                count++;
            }
        }
        return count;
    }
    // test:  x=[-4, 2, 0, 2]
    //        Expected = 2

    public static void main (String []argv)
    {  // Driver method for countPositive
        // Read an array from standard input, call countPositive()
        int[] arr = {};
        System.out.println(countPositive(arr));
    }
}

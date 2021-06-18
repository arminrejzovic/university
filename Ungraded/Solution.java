package Ungraded;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    // Complete the sockMerchant function below.
    static int sockMerchant(int[] ar) {
        Map<Integer,Integer> numbers = new HashMap<>();
        int pairs=0;
        int totalOccurrences=0;

        for (int i : ar){
            if (!numbers.containsKey(i)){
                numbers.put(i,1);
            }
            else {
                numbers.put(i,numbers.get(i)+1);
            }
        }

        for (Object number: numbers.keySet()){
            System.out.println(number+" value: "+ numbers.get(number));
            if ((Integer)(numbers.get(number))%2==0){
                totalOccurrences+=numbers.get(number);
            }
            else {
                totalOccurrences+=(numbers.get(number)-1);
            }
        }

        System.out.println(totalOccurrences);
        pairs = totalOccurrences/2;

        return pairs;
    }

    static int countingValleys(String s) {
        int level=0;
        int valleys=0;
        boolean valleyStarted = false;
        for (int i=0; i<s.length();i++){
            if (s.charAt(i)=='U'){
                ++level;
            }
            else {
                --level;
            }

            if (level<0 && !valleyStarted){
                valleyStarted = true;
            }
            if (valleyStarted && level==0){
                valleys++;
                valleyStarted=false;
            }
        }
        return valleys;
    }

    static long repeatedString(String s, long n) {
        long initialCount=0;
        long occ=0;
        if (!s.contains("a")) return 0;
        if (s.equals("a")) return n;

        long repeats = n/(s.length());
        long leftover = n-(repeats*s.length());

        for (char c: s.toCharArray()){
            if (c=='a') initialCount++;
        }

        occ+=(initialCount*repeats);

        if (leftover>0){
            for (int i=0;i<leftover;i++){
                if (s.charAt(i)=='a') occ++;
            }
        }

        return occ;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println(repeatedString("aba",10));

    }
}

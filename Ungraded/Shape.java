package Ungraded;

import java.util.Scanner;

public class Shape {

    static int round(double num){
        if (num<0){
            num-=0.5;
        }
        else{
            num+=0.5;
        }
        return (int) num;
    }

    public static void main(String[] args) {
        char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number of rows: ");
        int rows = scanner.nextInt();
        if (rows>alphabet.length){
            System.out.println("The alphabet contains only "+ alphabet.length + " characters");
            System.exit(0);
        }

        for (int i=rows;i>0;i--){
            for (int j=2*rows;j>=0;j--){
                if (Math.abs(j-i)>i){
                    System.out.print(" ");
                }
                else if (Math.abs(j-i)==0){
                    continue;
                }
                else if (j-i==-1){
                    continue;
                }
                else{
                    System.out.print(alphabet[Math.abs(j-i)-1]+" ");
                }
            }
            System.out.println();
        }

        System.out.println(round(3.3));
        System.out.println(round(4.7));
        System.out.println(round(5.2));
        System.out.println(round(6.9));
        System.out.println(round(-7.3));
        System.out.println(round(-8.9));
        System.out.println(round(-9.7));


    }
}

package com.company;

import java.util.Scanner;

public class Glupost {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Unesi iznos transakcije: ");
        double iznos = 10.0;

        while (iznos<0){
            System.out.println("IZNOS: "+iznos);
            iznos-=iznos*0.17;
        }

        int krug=1;

    }
}

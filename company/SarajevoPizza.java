package com.company;

import java.util.Objects;
import java.util.Scanner;

public class SarajevoPizza {
    private int id;
    private int sold;

    private static int totalSold=0;

    public SarajevoPizza() {
        id=0;
        sold=0;
    }

    public SarajevoPizza(int id, int sold) {
        this.id = id;
        setSold(sold);
    }


    public void setSarajevoPizza(){
        System.out.println("Input Stand ID:\n");
        Scanner scanner = new Scanner(System.in);
        this.setId(scanner.nextInt());
        System.out.println("Input number of pizzas sold by stand: \n");
        this.setSold(scanner.nextInt());
    }


    public void justSold(){
        this.sold++;
        totalSold++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        if (sold>=0){
            this.sold = sold;
            totalSold+=sold;
        }
        else {
            System.out.println("Error: Number of sold pizzas cannot be negative");
            System.exit(0);
        }
    }

    public static int getTotalSold() {
        return totalSold;
    }

    public boolean equals(SarajevoPizza otherSarajevoPizza) {
        if (otherSarajevoPizza == null)
            return false;
        else {
            return  otherSarajevoPizza.id==this.id && otherSarajevoPizza.sold==this.sold;
        }
    }

    @Override
    public String toString() {
        return "SarajevoPizza stand" + id +" sold " + sold + " pizzas";
    }

    public static void main(String[] args) {

        SarajevoPizza sp1 = new SarajevoPizza(1,10);
        SarajevoPizza sp2 = new SarajevoPizza(2,14);
        SarajevoPizza sp3 = new SarajevoPizza(3,9);

        System.out.println("Total pizzas sold by three stands: " + getTotalSold());
        System.out.println(sp1);

        if (sp2.equals(sp3)){
            System.out.println("Stand 2 and stand 3 are the same");
        }
        else {
            System.out.println("Stand 2 and stand 3 are different");
        }

        SarajevoPizza sp4 = new SarajevoPizza();
        sp4.setSarajevoPizza();

        System.out.println("Total pizzas sold by four stands: " + getTotalSold());
    }

}

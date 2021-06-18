package com.company;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person);
        person.setName("Gregory House");
        person.setAge(50);
        System.out.println(person);

        Date date = new Date("January",14,2003);
        System.out.println(date);

        Date test = new Date();
        test.readInput();
        System.out.println(test);
    }
}

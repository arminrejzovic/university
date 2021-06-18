package com.company;

import java.util.Scanner;

public class Date {
    private String month;
    private int day;
    private int year;

    public Date(String month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public Date(Date other) {
        this.month = other.month;
        this.day = other.day;
        this.year = other.year;
    }

    public Date() {
        month = "January";
        day = 1;
        year = 1000;
    }

    public void setDate(String monthString, int day, int year) {
        if (dateOK(monthString, day, year))
        {
            this.month = monthString;
            this.day = day;
            this.year = year;
        }
        else
        {
            System.out.println("Fatal Error");
            System.exit(0);
        }
    }

    private boolean dateOK(String monthString, int dayInt, int yearInt) {
        return ( monthOK(monthString) &&
                (dayInt >= 1) && (dayInt <= 31) &&
                (yearInt >= 1000) && (yearInt <= 9999) );
    }


    private boolean monthOK(String month) {
        return (month.equals("January") || month.equals("February") ||
                month.equals("March") || month.equals("April") ||
                month.equals("May") || month.equals("June") ||
                month.equals("July") || month.equals("August") ||
                month.equals("September") || month.equals("October") ||
                month.equals("November") || month.equals("December") );
    }

    public void setYear(int year) {
        if ( (year < 1000) || (year > 9999) )
        {
            System.out.println("Fatal Error");
            System.exit(0);
        }
        else
            this.year = year;
    }

    public void setDay(int day) {
        if ((day <= 0) || (day > 31))
        {
            System.out.println("Fatal Error");
            System.exit(0);
        }
        else
            this.day = day;
    }

    public void setMonth(String month) {
        if (monthOK(month)) {
            this.month = month;
        }
        else{
            System.out.println("Fatal Error");
            System.exit(0);
        }
    }

    public int getDay( ) {
        return day;
    }

    public int getYear( ) {
        return year;
    }

    public String getMonth() {
        return month;
    }


    public void readInput( ) {
        boolean tryAgain = true;
        Scanner keyboard = new Scanner(System.in);
        while (tryAgain)
        {
            System.out.println("Enter month, day, and year.");
            System.out.println("Do not use a comma.");
            String monthInput = keyboard.next( );
            int dayInput = keyboard.nextInt( );
            int yearInput = keyboard.nextInt( );
            if (dateOK(monthInput, dayInput, yearInput) )
            {
                setDate(monthInput, dayInput, yearInput);
                tryAgain = false;
            }
            else
                System.out.println("Illegal date. Reenter input.");
        }
    }

    public String toString( ) {
        return (month + " " + day + ", " + year);
    }


    public boolean equals(Date otherDate) {
        if (otherDate == null)
            return false;
        else
            return ( (month.equals(otherDate.month)) &&
                    (day == otherDate.day) && (year == otherDate.year) );
    }
}



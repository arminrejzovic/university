package SE221;

public class LeapYear {

    /**
     * Determine whether year is a leap year or not
     * @param year the year to be evaluated, requires year != 0, years BC to be represented as negative integers
     * @return <CODE>true</CODE> if year is a leap year and <CODE>false</CODE> if it's not
     */
     static boolean isLeapYear(int year){
        if (year==0){
            System.out.println("Error: year cannot be zero");
            System.exit(0);
            //The year zero doesn't exist! 1AD comes after 1BC
        }
        if (year%4>0){
            return false;
        }
        else if (year%100>0){
            return true;
        }
        else if (year%400>0){
            return false;
        }
        else return true;
    }



    public static void main(String[] args) {
        int[] years = {1444,1600,1200,2016,1,1918,1936,10,-16};
        int days_in_leap_year = 366;
        int days_in_non_leap_year = 365;
        for (int year : years) {
            if (isLeapYear(year)) {
                System.out.println("The year " + year + " is a leap year! It has "+days_in_leap_year+" days");
            } else {
                System.out.println("The year " + year + " is not a leap year! It has "+days_in_non_leap_year+" days");
            }

        }
    }

}


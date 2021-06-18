package SE221;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Assignment {
    public static void main(String[] args) {
        //Four methods regarding Map: (put,get,size,containsKey)
        Map<String, Double> employees = new HashMap<>();
        employees.put("John",35.0);
        employees.put("Bob",40.0);
        employees.put("Sean",30.5);
        employees.put("Ron",18.5);

        System.out.println("John's salary is: "+ employees.get("John"));
        System.out.println("We have "+employees.size()+" employees");

        if (employees.containsKey("Adrian")){
            System.out.println("Adrian works in this company");
        }
        else{
            System.out.println("Adrian doesn't work here");
        }


        //Four methods regarding List: (add,get,clear,isEmpty)
        ArrayList<String> candidates = new ArrayList<>();
        candidates.add("Matt");
        candidates.add("Eric");
        candidates.add("James");

        System.out.println("The third candidate is "+candidates.get(2));

        candidates.clear();

        if (candidates.isEmpty()){
            System.out.println("We have no available candidates");
        }


        //Four methods regarding String: ( charAt, equals, length, contains

        String eng = "abcdefghijklmnopqrstuvwxyz";
        String bos = "abcčćddžđefghijklljmnnjoprsštuvzž";
        System.out.println("The 10th letter in the english alphabet is "+eng.charAt(9));

        if (eng.equals(bos)){
            System.out.println("The english and bosnian alphabets are identical");
        }
        else {
            System.out.println("The english and bosnian alphabets are different");
        }

        if (eng.length()>bos.length()){
            System.out.println("The english alphabet is longer than the bosnian alphabet");
        }
        else {
            System.out.println("The bosnian alphabet is longer than the english alphabet");
        }

        if (bos.contains("x")){
            System.out.println("The bosnian alphabet contains the letter x");
        }
        else {
            System.out.println("There is no x in the bosnian alphabet");
        }
    }

}

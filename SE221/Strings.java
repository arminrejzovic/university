package SE221;

/*
Armin Rejzović
190302077
 */

public class Strings {

    public static void main(String[] args) {
        long concatenation = classic();
        long builder = builder();
        System.out.println("Using StringBuilder is "+ (int)concatenation/builder + " times faster than using concatenation");
    }

    static long classic(){
        String a="a";
        long startTime = System.nanoTime();
        for (int i=0;i<10000;i++){
            a+="a";
        }
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("Execution time in nanoseconds  : " + timeElapsed);
        return timeElapsed;
    }

    static long builder(){
        StringBuilder a= new StringBuilder("a");
        long startTime = System.nanoTime();
        a.append("a".repeat(10000));
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("Execution time in nanoseconds  : " + timeElapsed);
        return timeElapsed;
    }




}

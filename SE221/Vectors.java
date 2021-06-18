package SE221;

/*
Armin Rejzović
190302077
*/

import java.util.Random;
import java.util.Vector;

public class Vectors {
    public static void main(String[] args) {
        Vector<Integer> v = new Vector<>();
        Random random = new Random();

        for (int i=0; i<10;i++){
            v.add(random.nextInt());
        }

        for (Integer i : v){
            if (i%2==0){
                v.remove(i);
            }
        }

        System.out.println(v.size());





    }
}

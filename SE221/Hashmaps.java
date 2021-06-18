package SE221;

/*
Armin Rejzović
190302077
 */

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Hashmaps {

    public static void main(String[] args) throws IOException {
        Map<String, Integer> words = new HashMap<>();

        File file = new File("C:\\Users\\armin\\Desktop\\clanak.txt");

        BufferedReader reader = new BufferedReader(new FileReader(file));
        //Using Scanner didn't work for some reason, so I used BufferedReader instead

        String line;
        while ((line = reader.readLine()) != null){
            String[] rijeci =  line.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
            //Removes all non-letters, sets it to lowercase and then splits it into words
            for (String rijec : rijeci){
                if (!words.containsKey(rijec)) {
                    words.put(rijec, 1);
                } else {
                    words.put(rijec, (Integer) words.get(rijec) + 1);
                }
            }
        }

        for (Object word : words.keySet()){
            System.out.println(word + " " + (Integer) words.get(word));
        }

    }
}

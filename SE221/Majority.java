package SE221;

import java.util.ArrayList;
import java.util.Arrays;

public class Majority {

    /**
     * Determines the majority element in an array, reorganizes array to make all occurrences of majority elements first
     * after which come the other elements in their original order
     * @param arr array of integers, requires that array has a majority element
     * @return integer that is the majority element in given array
     */
    static int majority(int[] arr){
        int count=0;
        int max_count=0;
        int max_index=0;
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr.length;j++){
                if(arr[i]==arr[j]){
                    count++;
                }
            }
            if (count>max_count){
                max_count=count;
                max_index=i;
            }
            count=0;
        }
        if (max_count>=(arr.length/2)+1){
            reorganizeArray(arr,max_index,max_count);
            return arr[max_index];
        }
        else {
            throw new IllegalArgumentException("Method requires array to have a majority element");
        }

    }

    /**
     * Method that reorganizes given array, such that majority elements come first,
     * the rest are stored in their original order
     * @param arr array with a majority element
     * @param max_index index at which an occurrence of the majority element is stored
     * @param count the number of times the majority element occurs in the array
     */
    static void reorganizeArray(int[] arr, int max_index, int count){
        int max_element = arr[max_index];
        ArrayList<Integer> new_list = new ArrayList<>();

        for (int num : arr){
            if (num==max_element){
                new_list.add(num);
            }
        }

        for (int num : arr){
            if (num!=max_element){
                new_list.add(num);
            }
        }

        for (int i=0;i<arr.length;i++){
            arr[i] = new_list.get(i);
        }
    }

    /**
     * Determines the majority element in an array
     * @param arr array of integers, requires that array has a majority element
     * @return integer that is the majority element in given array
     */
    static int majority_member(int[] arr){
        Arrays.sort(arr);
        return arr[arr.length / 2];
        //Since a majority element takes up more than half the array, in a sorted array,
        // an occurrence of it will always be in the middle point

    }

    public static void main(String[] args) {
        int[] arr = {0,4,3,5,5,5,5,5,5,1};
        System.out.println(majority(arr));
        for (int num : arr){
            System.out.print(num+" ");
        }
        /*int[] array = {0,4,3,5,5,5,5,5,5,1};
        System.out.println(majority_member(array));*/
    }

}

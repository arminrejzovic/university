package SE221;

/*
Armin Rejzović
190302077
 */

public class Assertions {
    public static void main(String[] args) {
        int[] arr={1,3,5};
        sortArray(arr);
        for (int i:arr){
            System.out.println(i);
        }
    }

    static void sortArray(int[] arr){
        assert !isSorted(arr);
        for(int i=0; i < arr.length; i++){
            for(int j=1; j < (arr.length-i); j++){
                if(arr[j-1] > arr[j]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    static boolean isSorted(int[] arr){
        for (int i=0;i<arr.length-1;i++){
            if (arr[i]>arr[i+1]){
                return false;
            }
        }
        return true;
    }
}

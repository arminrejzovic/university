package SE221;

public class Pair {

    static int pairUp(int[] arr1, int[] arr2){
        for (int i=0;i< arr1.length;i++){
            if (2*arr1[i]!=arr2[i]){
                return 0;
            }
        }
        return 1;
    }

    static int pairUpThree(int[] arr1, int[] arr2){
        if (arr1.length!=arr2.length){
            return -1;
        }
        for (int i=0;i< arr1.length;i++){
            if (2*arr1[i]!=arr2[i]){
                return 0;
            }
        }
        return 1;
    }
    static int pairUpTwo(int[] arr1, int[] arr2){
        if (!isSorted(arr1)||(!isSorted(arr2))){
            return arr1.length;
        }
        if (arr1.length!=arr2.length){
            return -1;
        }
        for (int i=0;i< arr1.length;i++){
            if (2*arr1[i]!=arr2[i]){
                return 0;
            }
        }
        return 1;
    }

    /**
     * Determines whether array is sorted in ascending order
     * @param arr array of integers
     * @return <CODE>true</CODE> if array is sorted, <CODE>false</CODE> if it isn't
     */
    static boolean isSorted(int[] arr){
        for (int i=0;i<arr.length-1;i++){
            if (arr[i]>arr[i+1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3};
        int[] arr2 = {2,4,6};
        int[] arr3 = {3,5,7,9};

        System.out.println(pairUp(arr1,arr2));
        System.out.println(pairUp(arr1,arr3));
        System.out.println(pairUpThree(arr1,arr3));

        System.out.println(isSorted(arr3));
    }

}

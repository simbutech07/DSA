package dsa.arraysandstrings;

import java.util.Arrays;

public class productExceptSelf {

    public static void main() {

        int[] input = {1,5,7,10,3};

        int n = input.length;

        int[] preArray = new int[n];
        int[] subArray = new int[n];
        int[] result = new int[n];

        // Construct the prefProduct array
        preArray[0] = 1;
        for (int i = 1; i < n ; i++) {
            preArray[i] = input[i-1] * preArray[i-1];
        }

        // Construct the suffProduct array
        subArray[n-1] = 1;
        for (int j = n-2; j >= 0 ; j--) {
            subArray[j] = input[j+1] * subArray[j+1];
        }

        // Construct the result array using
        // prefProduct[] and suffProduct[]
        for (int k = 0; k < n ; k++) {
            result[k] = preArray[k] * subArray[k];
        }

        System.out.println("result : "+ Arrays.toString(result));

    }
}

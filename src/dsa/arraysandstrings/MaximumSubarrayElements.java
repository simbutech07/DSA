package dsa.arraysandstrings;

import java.util.Arrays;

public class MaximumSubarrayElements {

    public static void main() {
        int[] input = {4,-1,5,10,1,3,-5,2};

        // Initialize variables with the first element of the array
        int currentSum = input[0];
        int maxSum = input[0];

        int start = 0;
        int end = 0;
        int tempStart = 0; // Tracks the starting index of the current subarray window

        for (int i = 1; i < input.length; i++) {

            if(input[i] > currentSum+input[i]){
                currentSum = input[i];
                tempStart = i; // Reset start index to the current element
            }else{
                currentSum += input[i];
            }

            if(currentSum > maxSum){
                maxSum = currentSum;
                start = tempStart; // Lock in the official start index
                end = i; // Lock in the official end index
            }
            
        }

        // Extract and print the actual subarray
        int[] subArray = Arrays.copyOfRange(input,start,end+1);

        System.out.println("maxSum : "+maxSum);
        System.out.println("subArray : "+Arrays.toString(subArray));


    }
}

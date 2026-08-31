package dsa.arraysandstrings;

//kadane's algorithm
public class MaximumSubarraySum {


    public static void main() {

        int[] input = {4,-1,5,10,1,3,-5,2};

        // Initialize variables with the first element of the array
        int currentSum = input[0];
        int maxSum = input[0];

        // Traverse the array starting from the second element
        for (int i = 1; i < input.length; i++) {

            // Decide whether to add the current element to the existing subarray
            // or start a new subarray from the current element
            currentSum = Math.max(input[i],currentSum+input[i]);

            // Track the maximum sum found so far
            maxSum = Math.max(maxSum,currentSum);
        }
        System.out.println("Maximum subarray sum value : "+maxSum);
    }

}

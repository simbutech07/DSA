package dsa.arraysandstrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static void main(String[] args) {

        int[] input = {2,5,3,2,8,-1,-1,5,-4,-3,7};
        int target = 0;
        List<List<Integer>> output = getFourSum(input,target);
        System.out.println(output);

    }

    private static List<List<Integer>> getFourSum(int[] input, int target) {
        List<List<Integer>> result = new ArrayList<>();

        // 1. Sort the array to easily handle duplicates and use two pointers
        Arrays.sort(input);

        int n = input.length;

        for (int i = 0; i < n-3; i++) {

            //optimization
            //if the array is sorted
            //if target is zero
            //If the current number is positive - it's impossible to sum up to zero with the remaining elements
            if(target == 0 && input[i] > 0){
                break;
            }

            //Skip duplicate values for the first element to avoid identical fours
            if(i>0 && input[i] == input[i-1]){
                continue;
            }

            for (int j = i+1; j < n-2; j++) {

                //Skip duplicate values for the second element to avoid identical fours
                if(j > (i+1) && input[j] == input[j-1]){
                    continue;
                }

                //two pointers
                int left = j+1;
                int right = n-1;

                while (left<right){
                    int sum = input[i]+input[j]+input[left]+input[right];

                    if(sum == target){
                        //Found a valid fours
                        result.add(Arrays.asList(input[i],input[j],input[left],input[right]));

                        //Move pointers inward and skip duplicates for the remaining positions
                        while (left<right && input[left] == input[left+1]) left++;
                        while (left<right && input[right] == input[right-1]) right--;

                        //move element for next iteration
                        left++;
                        right--;

                    } else if (sum < target) {
                        left++;
                    } else{
                        right--;
                    }
                }

            }
        }
        return result;
    }
}

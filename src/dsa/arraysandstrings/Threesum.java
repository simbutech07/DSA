package dsa.arraysandstrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Threesum {
    public static void main(String[] args) {

        int[] input = {2,5,3,2,8,-1,-1,5,-4,-3,7};
        int target = 0;
        List<List<Integer>> output = getThreeSum(input,target);
        System.out.println(output);

    }

    private static List<List<Integer>> getThreeSum(int[] input, int target) {

        List<List<Integer>> result = new ArrayList<>();

        // 1. Sort the array to easily handle duplicates and use two pointers
        Arrays.sort(input);

        for (int i = 0; i < input.length - 2; i++) {

            //optimization
            //if the array is sorted
            //if target is zero
            //If the current number is positive - it's impossible to sum up to zero with the remaining elements
            if(target == 0 && input[i] > 0){
                break;
            }

            //Skip duplicate values for the first element to avoid identical triplets
            if(i>0 && input[i] == input[i-1]){
                continue;
            }

            int left = i+1;
            int right = input.length-1;

            while(left<right){

                int sum = input[i]+input[left]+input[right];
                if(sum == target){

                    //Found a valid triplet
                    result.add(Arrays.asList(input[i],input[left],input[right]));

                    //Move pointers inward and skip duplicates for the remaining positions
                    while (left<right && input[left] == input[left+1]) left++;
                    while (left<right && input[right] == input[right-1]) right--;

                    //move element for next iteration
                    left++;
                    right--;

                }else if(sum < target){
                    //Sum is too low, move left pointer to increase the total sum
                    left++;
                }else{
                    //Sum is too high, move right pointer to decrease the total sum
                    right--;
                }

            }

        }
        return result;
    }
}

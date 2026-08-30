package dsa.arraysandstrings;

import java.util.HashMap;

public class TwoSum {
    public static void main() {
        int[] input = {1,6,4,8,10,3,7};
        int target = 16;

        int[] output = getIndices(input,target);
        System.out.println("two indices are "+output[0]+" : "+output[1]);
    }

    public static int[] getIndices(int[] input, int target){
        HashMap<Integer,Integer> numMap = new HashMap<>();

        for (int i = 0; i < input.length; i++) {
            int complement = target - input[i];
            if(numMap.containsKey(complement)){
                return new int[]{numMap.get(complement),i};
            }
            numMap.put(input[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

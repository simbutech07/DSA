package dsa.arraysandstrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static void main() {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        List<int[]> mergedList = new ArrayList<>();

        //Sort intervals by start time
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));

        //Iterate through intervals and merge
        for(int[] interval:intervals){
            int mergeListLastIndex = mergedList.size()-1;
            // If merged list is empty or no overlap, add the interval
            if(mergedList.isEmpty() || mergedList.get(mergeListLastIndex)[1] < interval[0]){
                mergedList.add(interval);
            }else{
                // Overlap detected, merge intervals
                mergedList.get(mergeListLastIndex)[1] =
                        Math.max(mergedList.get(mergeListLastIndex)[1],interval[1]);
            }
        }

        // Print merged intervals
        mergedList.forEach(x -> System.out.println(Arrays.toString(x)));

    }

}

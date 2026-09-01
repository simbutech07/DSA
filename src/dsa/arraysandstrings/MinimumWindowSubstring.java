package dsa.arraysandstrings;

import java.util.HashMap;
import java.util.Map;


public class MinimumWindowSubstring {

    public static void main() {

        String s = "aebdecbcba";
        String t = "abc";

        //Frequency map for characters in t
        Map<Character,Integer> targetMap = new HashMap<>();
        for (char c:t.toCharArray()) {
            targetMap.put(c,targetMap.getOrDefault(c,0)+1);
        }

        int required = targetMap.size(); //no of unique char in t
        int formed = 0; //no of uniq char matched in current window
        Map<Character,Integer> windowCounts = new HashMap<>();

        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;

        while (right < s.length()){
            char c = s.charAt(right);
            windowCounts.put(c,windowCounts.getOrDefault(c,0)+1);

            // If current char matches the required frequency
            if (targetMap.containsKey(c) && windowCounts.get(c).intValue() == targetMap.get(c).intValue()){
                formed++;
            }

            while(left<=right && formed == required){
                if(right-left+1 < minLen){
                    minLen = right-left+1;
                    minLeft = left;
                }

                char leftChar = s.charAt(left);
                windowCounts.put(leftChar,windowCounts.get(leftChar)-1);
                if (targetMap.containsKey(leftChar) && windowCounts.get(leftChar) < targetMap.get(leftChar)) {
                    formed--;
                }
                left++;
            }
            right++;
        }
        System.out.println(minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen));

    }
}

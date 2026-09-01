package dsa.arraysandstrings;

import java.util.HashMap;

public class LongestUniqueSubstring {

    public static void main() {

        String input = "geekforgeeks";

        // Creating a set to store the last positions of occurrence
        HashMap<Character,Integer> seen = new HashMap<>();
        // starting the initial point of window to index 0
        int start = 0;
        int maxLen = 0;
        String longest = "";

        for (int end = 0; end < input.length(); end++) {
            char val = input.charAt(end);
            // Checking if we have already seen the element or not
            if(seen.containsKey(val) && seen.get(val) >= start){
                // If we have seen the number, move the start pointer
                // to position after the last occurrence
                start = seen.get(val)+1;
            }
            // Updating the last seen value of the character
            seen.put(val,end);
            if(end-start+1 > maxLen){
                maxLen = end-start+1;

                longest = input.substring(start,end+1);
            }
        }

        System.out.println("maxLen : "+maxLen);
        System.out.println("Longest value : "+longest);


    }
}

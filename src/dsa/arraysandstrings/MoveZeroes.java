package dsa.arraysandstrings;

import java.util.Arrays;

public class MoveZeroes {

    public static void main() {
        int[] input = {0,2,5,7,9,0,2,0,5,0,0};

        System.out.println("input : "+ Arrays.toString(input));

        int count = 0;

        for (int i = 0; i < input.length; i++) {
            //Move non-zero elements from oth index
            if(input[i] !=0){
                input[count++] = input[i];
            }
        }

        while (count< input.length){
            //Add zero following of non-zero elements till end
            input[count++] = 0;
        }

        System.out.println("output : "+ Arrays.toString(input));
    }
}

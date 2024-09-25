package aToZStriverSheetJava._001_Basics._02_Collections;

import java.util.Arrays;

public class ArraysClass {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 4, 3, 5, 6, 7, 8, 9, 10};
        // Sorting
        Arrays.sort(numbers); // quick Sort

        for(int i: numbers){
            System.out.print(i + " ");
        }System.out.println();

        // Binary Search
        int index = Arrays.binarySearch(numbers, 4); // can only be applied on sorted.
        System.out.println("INDEX = " + index);

        // fill - for DP problems
        Arrays.fill(numbers, 0);

        for(int i: numbers){
            System.out.print(i + " ");
        }System.out.println();
    }
}

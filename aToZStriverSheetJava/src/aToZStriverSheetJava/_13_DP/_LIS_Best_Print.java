package aToZStriverSheetJava._13_DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//link - https://www.geeksforgeeks.org/problems/printing-longest-increasing-subsequence/0

public class _LIS_Best_Print {

    public ArrayList<Integer> longestIncreasingSubsequence(int n, int nums[]) {
        // Array to store the length of the LIS ending at each index
        int[] lisLengths = new int[n];
        // Array to store the previous index of the LIS for backtracking
        int[] previousIndex = new int[n];

        // Initialize LIS lengths to 1 (each element is a subsequence of length 1)
        Arrays.fill(lisLengths, 1);
        int maxLength = 1;
        int endIndex = 0; // Index of the last element in the longest increasing subsequence

        // Build the LIS using dynamic programming
        for (int i = 0; i < n; i++) {
            previousIndex[i] = i; // Initially point to itself
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && lisLengths[j] + 1 > lisLengths[i]) {
                    lisLengths[i] = lisLengths[j] + 1;
                    previousIndex[i] = j; // Update the previous index for LIS
                }
            }
            // Update the maximum length and its end index
            if (lisLengths[i] > maxLength) {
                maxLength = lisLengths[i];
                endIndex = i;
            }
        }

        // Reconstruct the longest increasing subsequence
        ArrayList<Integer> result = new ArrayList<>();
        int currentIndex = endIndex;
        while (previousIndex[currentIndex] != currentIndex) {
            result.add(nums[currentIndex]);
            currentIndex = previousIndex[currentIndex];
        }
        result.add(nums[currentIndex]); // Add the first element of the LIS

        // Reverse the result to get the correct order
        Collections.reverse(result);

        return result;
    }

}

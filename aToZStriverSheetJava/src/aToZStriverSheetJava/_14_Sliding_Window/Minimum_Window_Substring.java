package aToZStriverSheetJava._14_Sliding_Window;

import java.util.*;

//link - https://leetcode.com/problems/minimum-window-substring/

public class Minimum_Window_Substring {

    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Frequency map for characters in `t`
        HashMap<Character, Integer> tFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }

        // Sliding window variables
        HashMap<Character, Integer> windowFreq = new HashMap<>();
        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        int minStart = 0;
        int required = tFreq.size(); // Number of unique characters in `t` to match
        int formed = 0; // Number of characters in the current window matching `t`

        while (right < s.length()) {
            // Add character at `right` to the window
            char c = s.charAt(right);
            windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);

            // Check if this character satisfies the requirement in `t`
            if (tFreq.containsKey(c)
                    && windowFreq.get(c).intValue() == tFreq.get(c).intValue()) {
                formed++;
            }

            // Try to contract the window
            while (left <= right && formed == required) {
                // Update the minimum window
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minStart = left;
                }

                // Remove character at `left` from the window
                char removedChar = s.charAt(left);
                windowFreq.put(removedChar, windowFreq.get(removedChar) - 1);
                if (tFreq.containsKey(removedChar)
                        && windowFreq.get(removedChar).intValue() < tFreq.get(removedChar).intValue()) {
                    formed--;
                }
                left++;
            }

            // Expand the window
            right++;
        }

        // Return the minimum window substring
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);

    }
}

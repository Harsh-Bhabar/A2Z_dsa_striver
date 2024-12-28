package aToZStriverSheetJava._14_Sliding_Window;

import java.util.HashSet;

//link - https://leetcode.com/problems/longest-substring-without-repeating-characters/

public class No_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.isEmpty()){
            return 0;
        }

        int i = 0;
        int n = s.length();
        int ans = Integer.MIN_VALUE;
        HashSet<Character> seen = new HashSet<>();

        for(int j=0; j<n; j++){
            while(seen.contains(s.charAt(j))){
                seen.remove(s.charAt(i));
                i++;
            }
            seen.add(s.charAt(j));
            ans = Math.max(ans, j-i+1);
        }

        return ans;
    }
}

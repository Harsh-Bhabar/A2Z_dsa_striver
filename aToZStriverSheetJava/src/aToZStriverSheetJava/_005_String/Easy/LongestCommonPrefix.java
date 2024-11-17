package aToZStriverSheetJava._005_String.Easy;

//link - https://leetcode.com/problems/longest-common-prefix/

public class LongestCommonPrefix {
    public boolean isCommonTillMid(String[] strs, int mid){
        String s = strs[0];

        for(int i=0; i<mid; i++){
            for(int j=1; j<strs.length; j++){
                if(strs[j].charAt(i) != s.charAt(i)){
                    return false;
                }
            }
        }
        return true;
    }

    public String longestCommonPrefix(String[] strs) {
        int minLen = Integer.MAX_VALUE;
        for(String s: strs){
            minLen = Math.min(minLen, s.length());
        }

        if(minLen == 0){
            return "";
        }

        int l = 0;
        int r = minLen;

        while(l <= r){
            int mid = l + (r-l)/2;
            if(isCommonTillMid(strs, mid)){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }

        return strs[0].substring(0, r);
    }
}

package aToZStriverSheetJava._005_String.Medium;

//link - https://leetcode.com/problems/sum-of-beauty-of-all-substrings/

public class SumOfBeautyOfAllSubstrings {
    public int beautySum(String s){
        int total = 0;

        for(int i=0; i<s.length(); i++){
            int maxLen = 0;
            int minLen ;
            int[] freq = new int[26];

            for(int j=i; j<s.length(); j++){
                char ch = s.charAt(j);
                freq[ch-'a']++;
                maxLen = Math.max(maxLen, freq[ch-'a']);

                minLen = Integer.MAX_VALUE;
                for(int cnt: freq){
                    if(cnt > 0){
                        minLen = Math.min(minLen, cnt);
                    }
                }

                total += (maxLen - minLen);
            }
        }

        return total;
    }
}

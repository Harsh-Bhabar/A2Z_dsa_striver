package aToZStriverSheetJava._005_String;

//link - https://leetcode.com/problems/longest-palindromic-substring/

public class Longest_Palindromic_Substring {
    public int[] spread(String s, int n, int l, int r){
        while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        return new int[]{l+1, r-l-1};
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        if(n == 1){
            return s;
        }

        int start = 0;
        int len = 0;

        for(int i=0; i<n; i++){
            int[] odd = spread(s, n, i, i);
            int[] even = spread(s, n, i, i+1);

            if(odd[1] > len){
                len = odd[1];
                start = odd[0];
            }
            if(even[1] > len){
                len = even[1];
                start = even[0];
            }
        }

        return s.substring(start, start+len);
    }
}

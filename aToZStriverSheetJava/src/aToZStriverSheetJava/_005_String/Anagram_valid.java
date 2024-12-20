package aToZStriverSheetJava._005_String;

//link - https://leetcode.com/problems/valid-anagram/

public class Anagram_valid {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        int[] freq = new int[26];

        for(int i=0; i<s.length(); i++){
            char sCh = s.charAt(i);
            char tCh = t.charAt(i);
            freq[sCh - 'a']++;
            freq[tCh - 'a']--;
        }

        for(int i=0; i<26; i++){
            if(freq[i] != 0){
                return false;
            }
        }

        return true;
    }
}

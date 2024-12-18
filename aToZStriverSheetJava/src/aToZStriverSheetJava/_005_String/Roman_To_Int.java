package aToZStriverSheetJava._005_String;

import java.util.HashMap;

//link - https://leetcode.com/problems/roman-to-integer/

public class Roman_To_Int {
    public int romanToInt(String s) {

        HashMap<Character, Integer> charMap = new HashMap<>();
        charMap.put('I', 1);
        charMap.put('V', 5);
        charMap.put('X', 10);
        charMap.put('L', 50);
        charMap.put('C', 100);
        charMap.put('D', 500);
        charMap.put('M', 1000);

        int n = s.length();
        int ans = 0;
        for(int i=0; i<n; i++){
            int currNum = charMap.get(s.charAt(i));
            if(i < n-1 && currNum < charMap.get(s.charAt(i+1))){
                ans -= currNum;
            }else{
                ans += currNum;
            }
        }

        return ans;
    }
}

package aToZStriverSheetJava._005_String.Easy;

//https://leetcode.com/problems/largest-odd-number-in-string/

public class LargestOddNumber {
    public String largestOddNumber(String num) {
        int ind = num.length()-1;

        while(ind >= 0){
            char ch = num.charAt(ind);
            if(ch % 2 == 1){
                return num.substring(0, ind+1);
            }
            ind--;
        }

        return "";
    }
}

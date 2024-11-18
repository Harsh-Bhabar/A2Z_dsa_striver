package aToZStriverSheetJava._005_String.Easy;

//link - https://leetcode.com/problems/rotate-string/description/

public class RotateString {
    public boolean rotateString(String s, String goal) {
        // brute

        String shift = s;

        for(int i=0; i<s.length(); i++){
            shift = shift.substring(1) + shift.charAt(0);
            if(shift.equals(goal)){
                return true;
            }
        }

        return false;
    }

    public boolean rotateString_2(String s, String goal) {
        // optimal - goal must be substring of s+s

        if(s.length() != goal.length()){
            return false;
        }

        String ss = s + s;
        return ss.contains(goal);
    }
}

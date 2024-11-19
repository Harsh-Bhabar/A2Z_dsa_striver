package aToZStriverSheetJava._005_String.Medium;

//link - https://leetcode.com/problems/string-to-integer-atoi/

public class Atoi {
    class Solution {
        public int myAtoi(String s) {
            int i = 0;
            int result = 0;
            boolean neg = false;

            while (i < s.length() && s.charAt(i) == ' ') {
                i++;
            }

            if (i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
                neg = (s.charAt(i) == '-');
                i++;
            }

            while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                int digit = s.charAt(i) - '0';

                if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                    return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }

                result = result * 10 + digit;
                i++;
            }

            return neg ? -result : result;
        }
    }

}

package aToZStriverSheetJava._005_String;

//link - https://leetcode.com/problems/isomorphic-strings/

public class Isomorphic_Strings {
    public boolean isIsomorphic(String s, String t) {
        int[] stMap = new int[256];
        int[] tsMap = new int[256];

        for(int i=0; i<s.length(); i++){
            char sCh = s.charAt(i);
            char tCh = t.charAt(i);

            if(stMap[sCh] == 0 && tsMap[tCh] == 0){
                stMap[sCh] = tCh;
                tsMap[tCh] = sCh;
            }else{
                if(stMap[sCh] != tCh || tsMap[tCh] != sCh){
                    return false;
                }
            }
        }

        return true;
    }
}

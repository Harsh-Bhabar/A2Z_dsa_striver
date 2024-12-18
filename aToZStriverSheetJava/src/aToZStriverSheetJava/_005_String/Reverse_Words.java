package aToZStriverSheetJava._005_String;

public class Reverse_Words {
    // trim function of Java
    public String reverseWords_1(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder result = new StringBuilder();

        for(int i=words.length-1; i>=0; i--){
            result.append(words[i]);
            if(i > 0){
                result.append(" ");
            }
        }
        return result.toString();
    }
    // better
    public String reverseWords_2(String s) {
        StringBuilder result = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        int ind = s.length()-1;

        while(ind >= 0){
            char ch = s.charAt(ind);
            if(ch != ' '){
                temp.append(ch);
            }else{
                if(temp.length() > 0){
                    if(result.length() > 0){
                        result.append(" ");
                    }
                    result.append(temp.reverse());
                    temp.setLength(0);
                }
            }
            ind--;
        }

        if(temp.length() > 0){
            if(result.length() > 0){
                result.append(" ");
            }
            result.append(temp.reverse());
        }

        return result.toString();
    }

}

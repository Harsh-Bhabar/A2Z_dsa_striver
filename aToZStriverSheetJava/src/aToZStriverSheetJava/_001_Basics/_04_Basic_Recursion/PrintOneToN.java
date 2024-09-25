package aToZStriverSheetJava._001_Basics._04_Basic_Recursion;

public class PrintOneToN {

    public static void printUptoN(int n){
        if (n == 0){
            return;
        } else{
          printUptoN(n-1);
          System.out.println(n);
        }
    }

    public static void main(String[] args){
        printUptoN(6);
    }
}

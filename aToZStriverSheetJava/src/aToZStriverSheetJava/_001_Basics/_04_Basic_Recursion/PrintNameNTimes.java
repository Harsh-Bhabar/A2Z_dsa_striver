package aToZStriverSheetJava._001_Basics._04_Basic_Recursion;

public class PrintNameNTimes {

    public static void printName(String name, int n){
        if( n == 0){
            return ;
        }else{
            System.out.println(name);
            printName(name, n-1);
        }
    }

    public static void main(String[] args){
        printName("Harsh-LOL", 5);
    }
}

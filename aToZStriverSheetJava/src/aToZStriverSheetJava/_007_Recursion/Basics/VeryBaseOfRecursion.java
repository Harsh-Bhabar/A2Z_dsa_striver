package aToZStriverSheetJava._007_Recursion.Basics;

public class VeryBaseOfRecursion {

    public static void printName(String s, int n){
        if(n == 0){
            return ;
        }

        System.out.println(s);
        printName(s, n-1);
    }

    public static void print1toN(int n){
        if(n <= 0){
            return ;
        }
        print1toN(n-1);
        System.out.println(n);
    }

    public static void printNto1(int n){
        if(n <= 0){
            return;
        }
        System.out.println(n);
        printNto1(n-1);
    }

    public static void main(String[] args){
        printName("Harsh", 5);
        print1toN(5);
        printNto1(6);
        return ;
    }
}

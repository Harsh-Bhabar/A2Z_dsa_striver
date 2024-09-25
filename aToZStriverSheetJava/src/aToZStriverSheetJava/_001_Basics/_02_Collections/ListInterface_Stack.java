package aToZStriverSheetJava._001_Basics._02_Collections;

import java.util.Stack;

public class ListInterface_Stack {
    public static void main(String[] args){
        // ------ stack
        Stack<String> animals = new Stack<>();
        // push
        animals.push("God");
        animals.push("Dog");
        animals.push("Cat");
        System.out.println(animals);
        // peek
        System.out.println(animals.peek());
        // pop
        animals.pop();
        System.out.println(animals);
    }
}

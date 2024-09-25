package aToZStriverSheetJava._001_Basics._02_Collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListInterface_ArrayList {

    public static void printList(final List<String> list){
        // to string
//        System.out.println(list);

        // for loop
//        for(int i=0; i<list.size(); i++){
//            System.out.print(list.get(i) + " ");
//        }
//        System.out.println();

        // for-each
//        for (String name: list){
//            System.out.print(name + " ");
//        }
//        System.out.println();

        // Iterator
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        // --------- ArrayList
        System.out.println("ArrayList");

        // add
        List<String> studentNames = new ArrayList<>(); // we can use LinkedList too
        studentNames.add("Harsh");
        studentNames.add("Ayush");
        studentNames.add("Mrinal");
        studentNames.add("Nikhil");
        printList(studentNames);
        // add at
        studentNames.add(1, "Saket");
        printList(studentNames);
        // add All
        List<String> newList = new ArrayList<>();
        newList.add("Harsh-1");
        newList.add("Harsh-2");
        studentNames.addAll(newList);
        printList(studentNames);
        // get
        System.out.println(studentNames.get(1));
        // remove at
        studentNames.remove(5);
        printList(studentNames) ;
        // remove value
        studentNames.remove(String.valueOf("Harsh"));
        printList(studentNames);
        // clear
        newList.clear();
        // set
        studentNames.set(4, "Harsh");
        printList(studentNames);
        // contains
        System.out.println(studentNames.contains("Harsh"));
        System.out.println(studentNames.contains("Harsh-2"));


    }
}

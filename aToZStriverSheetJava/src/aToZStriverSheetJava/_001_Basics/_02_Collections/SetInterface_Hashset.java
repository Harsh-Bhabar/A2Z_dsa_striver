package aToZStriverSheetJava._001_Basics._02_Collections;

import java.util.HashSet;
import java.util.Set;

public class SetInterface_Hashset {
    public static void main(String[] args){

        Set<Integer> set = new HashSet<>(); // random order O(1)
//        Set<Integer> set = new LinkedHashSet<>(); // elements will be in order
//        Set<Integer> set = new TreeSet<>(); // order will be sorted O(logN)
        // ADD
        set.add(43);
        set.add(3);
        set.add(52);
        set.add(76);
        set.add(76);

        System.out.println(set);

        // REMOVE
        set.remove(76);

        // contains
        System.out.println(set.contains(52));

        // isEmpty
        System.out.println(set.isEmpty());

        // size
        System.out.println(set.size());

        // clear
        set.clear();
        System.out.println(set);
    }
}

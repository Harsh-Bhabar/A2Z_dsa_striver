package aToZStriverSheetJava._001._02_Collections;

import javax.print.attribute.IntegerSyntax;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapInterface {
    public static void main(String[] args){
//        Map<String, Integer> numbers = new HashMap<>();  // O(1)
        Map<String, Integer> numbers = new TreeMap<>(); // store in correct order of Key // O(n)

        // PUT
        numbers.put("one".toUpperCase(), 1);
        numbers.put("two".toUpperCase(), 2);
        numbers.put("three".toUpperCase(), 3);
        System.out.println(numbers);

        // PUT IF ABSENT
        numbers.putIfAbsent("four".toUpperCase(), 4);
        System.out.println(numbers);

        // CONTAINS
        System.out.println(numbers.containsKey("one".toUpperCase()));
        System.out.println(numbers.containsValue(1));

        // EntrySet -  Iterate

        for(Map.Entry<String, Integer> e: numbers.entrySet()){
            System.out.println(e.getKey() + " : " + e.getValue());
        }

        // KeySet
        for(String key: numbers.keySet()){
            System.out.println(key + " : " + numbers.get(key));
        }

        // remove
        numbers.remove("ONE");
        System.out.println(numbers);

        // isEmpty
        System.out.print(numbers.isEmpty());


    }
}

package aToZStriverSheetJava._001._02_Collections;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class CollectionsClass {
    public static void main(String[] args){
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(32);
        nums.add(4);
        nums.add(2);
        nums.add(7);
        nums.add(17);
        nums.add(17);
        // MIN
        System.out.println("MIN = " + Collections.min(nums));
        // MAX
        System.out.println("MAX = " +  Collections.max(nums));
        // Frequency
        System.out.println("FREQ of 17= " + Collections.frequency(nums, 17));
        // Sort
        Collections.sort(nums, Comparator.reverseOrder());
        System.out.println(nums);

        // Sort Objects - Comparable - one class can only have one
        List<Student> students = new ArrayList<>();
        Student s1 = new Student("Harsh", 1);
        Student s2 = new Student("Ayush", 2);
        Student s3 = new Student("Mrinal", 3);
        students.add(s1);
        students.add(s3);
        students.add(s2);

        System.out.println(s1.compareTo(s2)); // gives -1

        // sort by either roll no. or name
        Collections.sort(students);
        System.out.println(students);

        // Comparator - sort by any
        Collections.sort(students, new Comparator<Student>(){
            @Override
            public int compare(Student s1, Student s2){
                return s1.name.compareTo(s2.name);
            }
        });

        System.out.println(students);

        // lambda function
        Collections.sort(students, (o1, o2) -> o1.name.compareTo(o2.name));
        System.out.println(students);

    }
}

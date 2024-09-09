package aToZStriverSheetJava._001._02_Collections;

import java.util.HashSet;
import java.util.Set;

public class SetInterface_Hashset_hashcode_and_equals {
    public static void main(String[] args){
        Set<Student> students = new HashSet<>();
        Student student1 = new Student("Harsh", 2);
        Student student2 = new Student("Aysuh", 1);
        Student student3 = new Student("Mrinal", 3);
    }
}

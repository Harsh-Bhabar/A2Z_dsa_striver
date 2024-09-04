package aToZStriverSheetJava._001._01;

import java.util.Scanner;

public class IfElseAndSwitch {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int age;
		System.out.println("Enter Age - ");
		age = s.nextInt();
		
		if(age < 18) {
			System.out.println("Not Perfect");
		}else if(age == 18) {
			System.out.println("Perfect");
		}else {
			System.out.println("Considerable");
		}
		
		s.close();
	}
}

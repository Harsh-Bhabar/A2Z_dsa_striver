package aToZStriverSheetJava;

import java.util.Scanner;

public class InputOutput {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int age;
		float weight;
		String petName;
		String fullName;
		
		// input int - nextInt()
		System.out.println("Enter age - ");
		age = scanner.nextInt();
		
		// input float - nextFloat()
		System.out.println("Enter weight - ");
		weight = scanner.nextFloat();
		scanner.nextLine();
		
		// input String - next() and nextLine()
		System.out.println("Enter pet name - ");
		petName = scanner.next();
		scanner.nextLine();
		
		System.out.println("Enter Full name - ");
		fullName = scanner.nextLine();
		
		scanner.close();
	}
}

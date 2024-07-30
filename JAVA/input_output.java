package JAVA;

import java.util.Scanner;

public class input_output {

	public static void printNumber(long a){
		System.out.println("Number is: " + a);
	}

	public static void printString(String name){
		System.out.println("Name is: " + name);
	}

	public static void takeInput() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter a number: ");
		long a = scanner.nextLong();
		scanner.nextLine();
		printNumber(a);

		System.out.println("Enter a name: ");
		String name = scanner.nextLine();
		printString(name);

		scanner.close();
	}
	
	public static void main(String[] args) {
		takeInput();
	}
	
}
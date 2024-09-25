package aToZStriverSheetJava._001_Basics._01;

public class Loops {
	public static void main(String args[]) {
		for(int i=0; i<5; i++) {
			for(int j=0; j<=i; j++) {
				System.out.print("*");		
			}
			System.out.println("");
		}
		
		System.out.println();
		
		for(int i=5; i>0; i--) {
			for(int j=i; j>0; j--) {
				System.out.print("#");
			}
			System.out.println();
		}

		System.out.println();
		
		int i=0;
		while(i < 5) {
			int j=0;
			while(j <= i) {
				System.out.print("$");
				j++;	
			}
			System.out.println();
			i++;
		}
		
	}
}

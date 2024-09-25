package aToZStriverSheetJava._001_Basics._01;

public class StarPattern {
	
	public static void pattern1(final int n) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}	
	
	public static void pattern2(final int n) {
		for(int i=n; i>0; i--) {
			for(int j=0; j<i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void pattern3(final int n) {
		for (int i = 1; i <= n; i++) {
	        // Print spaces
	        for (int j = i; j < n; j++) {
	            System.out.print(" ");
	        }
	        // Print stars
	        for (int k = 1; k <= (2 * i - 1); k++) {
	            System.out.print("*");
	        }
	        // Move to the next line
	        System.out.println();
	    }
	}
	
	public static void main(String args[]) {
		// Pattern - 1
		pattern1(5);
		System.out.println();
		// Pattern - 2
		pattern2(5);
		System.out.println();
		// Pattern - 3
		pattern3(5);
		
	}
}

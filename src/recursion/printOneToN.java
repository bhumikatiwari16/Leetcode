package recursion;

public class printOneToN {

	public static void main(String[] args) {
		
		displayOneToN(5);
	}
	
	public static void displayOneToN (int n) {
		
		// Base Condition
		if (n == 1) {
			System.out.println(1);
			return;	
		}
		
		// To print in descending order
		// System.out.println(n);
		
		displayOneToN (n-1);
		
		// To print in ascending order
		System.out.println(n);
		
	}

}

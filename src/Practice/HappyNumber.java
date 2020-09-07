package Practice;

import java.util.ArrayList;
import java.util.List;

public class HappyNumber {
	
	static List<Integer> l = new ArrayList<Integer>();

	public static void main(String[] args) {
		
		System.out.println(isHappy(20));

	}
	
	 public static boolean isHappy(int n) {
	
		 if(n != 1 && l.contains(n)) {
			 	return false;
		 	} 
		 else if (n == 1){
			 
			 return true;
		 }
		 else {
			 	l.add(n);
			 	n = calculate(n);
			 	return isHappy(n);
		 	}
		
		
		 
	}
	 
	 public static int calculate(int n) {
		 
		 int sum = 0;
		 
		 while (n != 0) {
			 
			 int d = n % 10;
			 int ds = d * d;
			 sum += ds;
			 n = n / 10;
			 
		 }
		 
		 return sum;
	 }
	 

}

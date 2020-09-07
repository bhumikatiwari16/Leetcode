package leetcode.strings;

public class AddStrings {

	public static void main(String[] args) {
		
		String num1 = "200", num2 = "99150";
		
		System.out.println(addStrings(num1,num2));
		
	}
	
	 public static String addStrings(String num1, String num2) {
	        
		 int digSum = 0, carry = 0; 
		 
		 StringBuilder sb = new StringBuilder();
		 
		 int i = num1.length();
		 
		 int j = num2.length();

		
		  while(i > 0 && j > 0)  {
		 
		 		digSum = ((Character.getNumericValue(num1.charAt(i-1)) + Character.getNumericValue(num2.charAt(j-1)) + carry)) % 10;
		 		
		 		carry = ((Character.getNumericValue(num1.charAt(i-1)) + Character.getNumericValue(num2.charAt(j-1)) + carry)) / 10;
		 		
		 		sb.insert(0,digSum);
		 		
		 		i--;
		 		
		 		j--;

		 }
		  
		  while (i > 0) {
			  
			  digSum = ((Character.getNumericValue(num1.charAt(i-1))) + carry) % 10;
			  
			  carry = ((Character.getNumericValue(num1.charAt(i-1))) + carry) / 10;
			  
			  sb.insert(0,digSum);
			  
			  i--;
			  
		  }
		  
		  while (j > 0) {
			  
			  digSum = ((Character.getNumericValue(num2.charAt(j-1))) + carry) % 10;
			  
			  carry = ((Character.getNumericValue(num2.charAt(j-1))) + carry) / 10;
			  
			  sb.insert(0,digSum);
			  
			  j--;
			  
		  }
		  
		  if (carry != 0) {
			  
			  sb.insert(0,carry);
		  
		  }
		  
		  
		 
		 return sb.toString();

	 }
}

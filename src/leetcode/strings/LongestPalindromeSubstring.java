package leetcode.strings;

public class LongestPalindromeSubstring {

	public static void main(String[] args) {
		
		String s  = "ba";
		System.out.println(longestPalindrome(s));
	}
	
	 public static String longestPalindrome(String s) {
	        
		 String res = null;
		 int max = Integer.MIN_VALUE;
		 
		 if (s == "" || s.length() == 0) {
			 return "";
		 }  
		 
		 if (s.length() == 1) {
			 return s;
		 }
		 
		 for(int i = 0; i < s.length(); i++) {
			 
			 StringBuilder sb = new StringBuilder();
			 sb.append(s.charAt(i));
			 
			 for(int j = i + 1 ; j < s.length(); j++) {
			
				 String temp;
				 
				 sb.append(s.charAt(j));
				 
				/*
				 * if(j == s.length()-1) { temp = s.substring(i, j+1); } else { temp =
				 * s.substring(i, j); }
				 */
				 
				 temp = sb.toString();
			 
				 if(checkPalindrome(temp)) {
				 
					 if (temp.length() >= max) {
						 max = temp.length() ;
						 res = temp;
					 }
				 }
			 }
		 }
		 
		 if (max == Integer.MIN_VALUE) {
			return s.charAt(0) + "" ; 
		 }
		 return res;
		 
	    }
	 
	 public static boolean checkPalindrome(String wrk) {
		 
		 int l = wrk.length();
		 
		 for(int i = 0; i < l/2 ; i++) {
			 
			 if (wrk.charAt(i) != wrk.charAt(l-i-1)) {
				 return false;
			 } 
		 }
		 
		 return true;
	 }

}

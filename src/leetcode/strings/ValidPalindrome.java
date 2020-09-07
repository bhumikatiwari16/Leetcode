package leetcode.strings;

public class ValidPalindrome {

public static void main(String args[]) {

	//isPalindrome( "A man, a plan, a canal: Panama");
	System.out.println(isPalindrome("A man, a plan, a canal: Panama"));

	System.out.println(isPalindrome("race a car"));
	
	System.out.println(isPalindrome(""));
	
	System.out.println(isPalindrome("0P"));
	
	System.out.println(isPalindrome("."));
}
	
public static boolean isPalindrome(String s) {
	
	boolean res = false;
	
	
	
	String str = s.replaceAll("\\s", "").toLowerCase();
	
	
	
	System.out.println(str);
	
	str = str.replaceAll("[^a-z0-9]","");
	
	if (str.isEmpty()) {
		return true;
	}
	
	System.out.println(str);
	
	int len = str.length();
	
	 if (len == 1) {
         return true;
     }
	 
	for (int i = 0; i < (len/2); i++) {
		
		if (str.charAt(i) == str.charAt(len - i - 1)) {
			res = true;
		} else {
			return false;
		}
	}
	
	return res;

    
}

}

package basic.problems;

public class PalindromeNumber {

	public static void main(String[] args) {
		
		System.out.println(isPalindrome(121));
	}
	
public static boolean isPalindrome(int x) {
        
	if (x < 0) {
		return false;
	}
	
	if (x == 0) {
		return true;
	}
	
	int num = x;
	int rem = 0, revNum = 0;
	
	while(num > 0) {
		
		rem = num % 10;
		revNum = (revNum * 10) + num;
		num = num / 10;
		
	}
	
	if (revNum == x) {
		return true;
	} 
	
	return false;
	
    

}

}

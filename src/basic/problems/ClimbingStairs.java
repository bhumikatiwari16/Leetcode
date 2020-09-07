package basic.problems;

public class ClimbingStairs {

	public static void main(String[] args) {
		
		System.out.println(climbStairs(2));

	}

	public static int climbStairs(int n) {
        
		  if (n == 1 || n == 2) {
	            return n;
	        }
		  
        int a =1, b = 2;
        int c = 0;
        
        for(int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        
        return c;
        
    }

}

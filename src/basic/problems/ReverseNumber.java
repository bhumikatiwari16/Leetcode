package basic.problems;
public class ReverseNumber {

	public static void main(String[] args) {
		
		System.out.println(reverse(1534236469));
		

		
	}
	
    public static int reverse(int x) {
        
    	int num;
    	int dig;
    
    	int res = 0;
    	int newRes = 0;
    	
    	num = x;
    
    	
    	while (num != 0) {
    		
    		dig = num % 10;
    		newRes = dig + (res * 10);
    		
    		 if (((newRes - dig) / 10) != res)
    	        { return 0; }
    		 
    		 
    		 res = newRes;
    		 num = num / 10;
    		
    		
    	}
    	
    	return res;
    	    	
    }

}

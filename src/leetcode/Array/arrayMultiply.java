package leetcode.Array;

public class arrayMultiply {

	public static void main(String[] args) {
		
		
		int[] i = {5,2,3,4};
		
		int l = 0;
		
		int[] o = productExceptSelf (i);
		
		while(l < o.length) {
			System.out.println(o[l]);
			l++;
		}

	}
	
    public static int[] productExceptSelf(int[] nums) {
        
    	int m = 0;
    	int prod = 1;
    	
    	int[] op = new int[nums.length];
    	
    	while (m < nums.length) {
    		
    		int pre = m - 1;
    		int post = m + 1;
    		
    		for(int a = 0; a <= pre; a++) {
    			prod = prod * nums[a];
    		}
    		
    		for(int b = post; b < nums.length; b++) {
    			prod = prod * nums[b];
    		}
    		
    		op[m] = prod;
    		prod = 1;
    		m++;
    		
    	}
    	
    	return op;
    	 
    }

}

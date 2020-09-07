package dynamicProgramming;

public class fencePaint {

	public static void main(String[] args) {
		
		System.out.println(numWays(3,2));
		
	}
	
	 public static int numWays(int n, int k) {
	       
		 if (n == 0) {
			 return 0;
		 } else if (n == 1) {
			 return k;
		 }
		 
		 int same = k * 1;
		 int diff = k * (k-1);
		 
		 for (int j = 3; j <= n; j++) {
			 
			 int oldSame = same;
			 same = diff * 1;
			 diff = (diff * (k-1)) + (oldSame * (k-1));
			 
		 }
		 
		 return same+diff;
	        
	    }

}

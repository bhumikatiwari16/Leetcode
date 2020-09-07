package interview;

import java.util.ArrayList;
import java.util.List;

public class Snowflake1 {

	public static void main(String[] args) {
		
		List<Integer> space = new ArrayList<Integer>();
		
	
		space.add(1);
		space.add(2);
		space.add(3);
		space.add(1);
		space.add(2);
		int x = 5;
		
		System.out.println(segment(x, space));

	}
	
	public static int segment(int x, List<Integer> space) {
	  
		int n = space.size();
		
		if (n < x) {
			return -1;
		}
		
		int oneRes = 0;
		
		if (x == 1) {
			for (int i = 0; i < space.size(); i++) {
				 oneRes = Math.max(space.get(i), oneRes);
			}
			return oneRes;
		}
		
		int nXEqual = Integer.MAX_VALUE;
		if (n == x) {
			for (int i = 0; i < space.size(); i++) {
				 nXEqual = Math.min(space.get(i), nXEqual);
			}
			return nXEqual;
		
		}
		
		
		int minWinSpace = Integer.MAX_VALUE; 
		int res = Integer.MIN_VALUE;
		
		 System.out.println(n);
		 System.out.println(x);
		 
        for (int i = 0; i <= n - x; i++) { 
        	  
            minWinSpace = space.get(i); 
  
            System.out.println("inside first for");
            for (int j = 1; j < x; j++) { 
            	 System.out.println("inside second for");
                if (space.get(i+j) < minWinSpace) {
                    minWinSpace = space.get(i+j); 
                	res = Math.max(res,minWinSpace );
                	 System.out.println("inside if");
                }
            } 
            
            
        } 
        
        return res;
  

	}

}

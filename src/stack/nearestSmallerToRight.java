package stack;

import java.util.Stack;

/*
 * 
 * https://www.youtube.com/watch?v=nc1AYFyvOR4&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=6&t=0s
 * 
 */

public class nearestSmallerToRight {

	public static void main(String[] args) {
		
		int[] arr = {2,1,5,6,2,3};
		
		int[] res = findNearestSmallerToRight(arr);
		
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}

	}
	
	public static int[] findNearestSmallerToRight(int[] arr) {
		
		int[] nsr = new int[arr.length];
		Stack<Integer> s= new Stack<Integer>();
		
		for (int i = arr.length-1; i >= 0; i--) {
			
			while(!s.isEmpty() && arr[s.peek()] > arr[i]) {
				s.pop();
			}
			
			if (s.isEmpty())  {
				nsr[i] = 0;
			} 
			
			else {
				nsr[i] = s.peek();
			}
			s.push(i);
		}
		
		return nsr;
	}
	

}

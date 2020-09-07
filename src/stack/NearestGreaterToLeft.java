package stack;

import java.util.Stack;

/*
 * https://www.youtube.com/watch?v=T5s96ynzArg&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=3
 * 
 * https://www.geeksforgeeks.org/closest-greater-or-same-value-on-left-side-for-every-element-in-array/
 * 
 * Given an array of integers, find the closest (not considering distance, but value) greater or same value on left of every element. If an element has no greater or same value on the left side, print -1.

Examples:

Input : arr[] = {10, 5, 11, 6, 20, 12}
Output : -1, 10, -1, 10, -1, 20
First element has nothing on left side, so answer for first is -1.
Second element 5 has 10 on left, so the answer is 10.
Third element 11 has nothing greater or the same, so the answer is -1.
Fourth element 6 has 10 as value wise closes, so the answer is 10
Similarly we get values for fifth and sixth elements.

 * 
 */

public class NearestGreaterToLeft {

	public static void main(String[] args) {
		
		int[] arr = {10, 5, 11, 6, 20, 12};
		
		int[] res = findNearestGreaterToLeft(arr);

		for (int i = 0; i < res.length; i++) {

			System.out.println(res[i]);

		}

	}
	
	
	/*
	 * create a stack and add array elements to it one by one.
	 * input array element compared with top of stack element
	 * if input array element < top of stack element: add top of stack element to result array
	 * else
	 * pop elements from stack till either the stack is empty or top of stack element is greater than 
	 * input array element
	 * 
	 * Add input array element to stack.
	 */
	public static int[] findNearestGreaterToLeft(int[] arr) {
		
		int[] res = new int[arr.length];
		
		Stack<Integer> s= new Stack<Integer>();
		
		for(int i = 0; i < arr.length; i++) {
			
			while(!s.isEmpty() && s.peek() < arr[i]) {
				s.pop();
			}
			
			if (s.isEmpty()) {

				res[i] = -1;

			} 
			
			else {

				res[i] = s.peek();

			}
				
			s.push(arr[i]);
			
		}
		
		return res;
		
	}

}

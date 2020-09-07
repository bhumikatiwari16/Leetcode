package stack;

import java.util.Stack;

/*
 * https://www.youtube.com/watch?v=J2X70jj_I1o
 * 
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 * 
 * Given n non-negative integers representing the histogram's bar height 
 * where the width of each bar is 1, 
 * find the area of largest rectangle in the histogram.
 * 
 * Example:

	Input: [2,1,5,6,2,3]
	Output: 10
 * 
 */

public class maxAreaHistogram {

	public static void main(String[] args) {
		
		int[] arr = {1,1};
		
		int[] nsl = nearestSmallerToLeft(arr);
		int[] nsr = nearestSmallerToRight(arr);
		
		int[] res = new int[arr.length];
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < nsl.length; i++) {
			res[i] = nsr[i] - nsl[i] - 1;
			if (arr[i] * res[i] > max) {
				max = arr[i] * res[i];
			}
		}
		
		System.out.println(max);
	
	}
	
	public static int[] nearestSmallerToRight(int[] arr) {
		
		int[] nsr = new int[arr.length];
		Stack<Integer> s= new Stack<Integer>();
		
		for (int i = arr.length-1; i >= 0; i--) {
			
			while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
				s.pop();
			}
			
			if (s.isEmpty())  {
				nsr[i] = arr.length;
			} 
			
			else {
				nsr[i] = s.peek();
			}
			s.push(i);
		}
		
		return nsr;
	}
	
	public static int[] nearestSmallerToLeft(int[] arr) {
		
		int[] nsl = new int[arr.length];
		Stack<Integer> s = new Stack<Integer>();
		
		for (int i = 0; i < arr.length; i++) {
			
			while(!s.isEmpty() && arr[s.peek()] > arr[i]) {
				s.pop();
			}
			
			if (s.isEmpty()) {
				nsl[i] = -1;
			} 
			
			else {
				nsl[i] = s.peek();
			}
				
			s.push(i);
	
		}
		
		return nsl;	
	}

	
	
}

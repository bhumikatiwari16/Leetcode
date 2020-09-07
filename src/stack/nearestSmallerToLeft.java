package stack;

import java.util.Stack;

/*
 * https://www.youtube.com/watch?v=85LWui3FlVk
 * 
 * https://www.geeksforgeeks.org/find-the-nearest-smaller-numbers-on-left-side-in-an-array/
 * 
 * 
 * Given an array of integers, find the nearest smaller number for every element such that the smaller element is on left side.
Examples:

Input:  arr[] = {1, 6, 4, 10, 2, 5}
Output:         {_, 1, 1,  4, 1, 2}
First element ('1') has no element on left side. For 6, 
there is only one smaller element on left side '1'. 
For 10, there are three smaller elements on left side (1,
6 and 4), nearest among the three elements is 4.

Input: arr[] = {1, 3, 0, 2, 5}
Output:        {_, 1, _, 0, 2}

 */

public class nearestSmallerToLeft {

	public static void main(String[] args) {
		
		int[] arr = {2,1,5,6,2,3};
		
		int[] res = findNearestSmallerToLeft(arr);
		
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}
	
	public static int[] findNearestSmallerToLeft(int[] arr) {
		
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

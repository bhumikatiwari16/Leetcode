package stack;

import java.util.Stack;

/*
 * https://www.youtube.com/watch?v=NXOOYYwpbg4&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=2
 * 
 * https://www.geeksforgeeks.org/next-greater-element/
 * 
 * Given an array, print the Next Greater Element (NGE) for every element. 
 * The Next greater Element for an element x is the first greater element on the right side of x in array. 
 * Elements for which no greater element exist, consider next greater element as -1.

Examples:

For any array, rightmost element always has next greater element as -1.
For an array which is sorted in decreasing order, all elements have next greater element as -1.
For the input array [4, 5, 2, 25}, the next greater elements for each element are as follows.
Element       NGE
   4      -->   5
   5      -->   25
   2      -->   25
   25     -->   -1
For the input array [13, 7, 6, 12}, the next greater elements for each element are as follows.

  Element        NGE
   13      -->    -1
   7       -->     12
   6       -->     12
   12      -->     -1
 * 
 * 
 * 
 */

public class nearestGreaterToRight {

	public static void main(String[] args) {

		int[] arr = { 1,3,2,4 };

		int[] res = findNearestGreaterToRight(arr);

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
	
	public static int[] findNearestGreaterToRight(int[] arr) {

		Stack<Integer> s = new Stack<Integer>();

		int[] res = new int[arr.length];

		int e = 0;

		for (int i = arr.length - 1; i >= 0; i--) {

			while (!s.isEmpty() && s.peek() < arr[i]) {

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

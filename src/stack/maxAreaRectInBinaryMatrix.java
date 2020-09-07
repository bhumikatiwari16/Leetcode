package stack;

import java.util.Stack;

public class maxAreaRectInBinaryMatrix {

	public static void main(String[] args) {
		
		int[][] arr = {
						{1,0,1,0,0},
						{1,0,1,1,1},
						{1,1,1,1,1},
						{1,0,0,1,0}
					};
		
		System.out.println(findMaxAreaRect(arr));
		

	}
	
	public static int[] nearestSmallerLeft(int[] arr) {
		
		Stack<Integer> s = new Stack<Integer>();
		
		int[] nsl = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			
			while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
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
	
	public static int[] nearestSmallerRight(int[] arr) {
		
		Stack<Integer> s = new Stack<Integer>();
		int[] nsr = new int[arr.length];
		
		for(int i = arr.length-1; i >= 0; i--) {
			while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
				s.pop();
			}
			
			if (s.isEmpty()) {
				nsr[i] = arr.length;
			}
			
			else {
				nsr[i] = s.peek();
			}
			
			s.push(i);
		}
		
		return nsr;
	}
	
	public static int histogramArea(int[] arr)  {
		
		int[] nsl = nearestSmallerLeft(arr);
		int[] nsr = nearestSmallerRight(arr);
		int[] res = new int[arr.length];
	
		int max = 0;
		
		for(int i = 0; i < nsl.length; i++) {
			
			res[i] = nsr[i] - nsl[i] - 1;
			max = Math.max(res[i] * arr[i], max);
			
		}
		
		return max;
		
	}
	
	public static int findMaxAreaRect(int[][] arr) {
		
		int maxArea = 0;
		
		int[] prev = new int[arr[0].length];
		
		for (int i = 0; i < arr.length; i++) {
			
			int[] row = createArray(arr, prev, i);
			maxArea = Math.max(maxArea, histogramArea(row));
			prev = row;
		}
		
		return maxArea;
	}
	
	public static int[] createArray(int[][] arr,int[] prev, int i) {
		
		int[] result = new int[arr[0].length];
		
		for (int j = 0; j < arr[0].length; j++) {
			
			if (arr[i][j] == 0) {
				result[j] = 0;
			}
			else {
			result[j] = arr[i][j] + prev[j];	
			}
			
		}
		
		return result;
	}
	
	

}

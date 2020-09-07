package BinarySearch;

/*
 * 
 * https://www.geeksforgeeks.org/floor-in-a-sorted-array/
 * 
 * Given a sorted array and a value x, 
 * the floor of x is the largest element in array smaller than or equal to x. 
 * Write efficient functions to find floor of x.

Examples:

Input : arr[] = {1, 2, 8, 10, 10, 12, 19}, x = 5
Output : 2
2 is the largest element in 
arr[] smaller than 5.

Input : arr[] = {1, 2, 8, 10, 10, 12, 19}, x = 20
Output : 19
19 is the largest element in
arr[] smaller than 20.

Input : arr[] = {1, 2, 8, 10, 10, 12, 19}, x = 0
Output : -1
Since floor doesn't exist,
output is -1.
 * 
 * 
 */

public class floorInSortedArray {

	public static void main(String[] args) {
		
		int[] arr = {0,1,3,8,10};
		int target = 11;
	
		System.out.println(findFloor(arr,target));
	
	}
	
	
	public static int findFloor(int[] arr, int target) {
		
		int start = 0;
		int end = arr.length-1;
		int mid = 0;
		int res = -1;
		
		while (start < end) {
			
			 mid = start + (end-start)/2;
			
			 if (target == arr[mid]) {
				 return arr[mid];
			 }
			 
			 //search in left part of mid
			 else if (target < arr[mid]) {
				 end = mid -1 ;
			 }
			 //search in right part of mid
			 //update values of arr[mid] which are less than target
			 //because it is potential answer to the problem
			 else {
				 res = arr[mid];
				 start = mid +1 ;
			 }	
		}
		
		// while loop ends when start == end happens
		// check if arr[end] > target, then last updated value of res is the answer
		// else if arr[end] < target, then arr[end] is the answer
		
		if (arr[end] > target) {
			return res;
		} else {
			return arr[end];
		}
	
	}

}

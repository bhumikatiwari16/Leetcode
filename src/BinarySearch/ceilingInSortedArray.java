package BinarySearch;

/*
 * 
 * https://www.geeksforgeeks.org/ceiling-in-a-sorted-array/
 * 
 * Given a sorted array and a value x, the ceiling of x is the smallest element in array greater than or equal to x, and the floor is the greatest element smaller than or equal to x. Assume than the array is sorted in non-decreasing order. Write efficient functions to find floor and ceiling of x.

Examples :
	
For example, let the input array be {1, 2, 8, 10, 10, 12, 19}
For x = 0:    floor doesn't exist in array,  ceil  = 1
For x = 1:    floor  = 1,  ceil  = 1
For x = 5:    floor  = 2,  ceil  = 8
For x = 20:   floor  = 19,  ceil doesn't exist in array 
 * 
 */

public class ceilingInSortedArray {

	public static void main(String[] args) {
		
		int[] arr = {1,3,8,10};
		int target = 11;
	
		System.out.println(findCeiling(arr,target));

	}
	
	
	public static int findCeiling(int[] arr, int target) {
		
		int start = 0;
		int end = arr.length-1;
		int mid = 0;
		int res = -1;
		
		while (start < end) {
			
			mid = start + (end-start)/2;
			
			if (arr[mid] == target) {
				return arr[mid];
			} 
			
			else if (arr[mid] < target) {
				start = mid + 1;
			} 
			
			else {
				res = arr[mid];
				end = mid - 1;
			}
		}
		
		if (arr[end] >= target) {
			return arr[end];
		} else {
			return res;
		}
	}

}

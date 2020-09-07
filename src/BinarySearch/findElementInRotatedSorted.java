package BinarySearch;
/*
 * 
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * 
Suppose an array sorted in ascending order is rotated at some pivot 
unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, 
otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
 * 
 * 
 */

public class findElementInRotatedSorted {

	public static void main(String[] args) {
		
		int[] arr = {1};
		int target = 0;
		
		System.out.println(findTargetElement(arr, target));

	}
	
	public static int findTargetElement(int[] arr, int target) {
		
		if(arr.length == 0) {
			return -1;
		}
		
		int min = findMinElement(arr, 0, arr.length-1);
		
		//System.out.println(min);
		//System.out.println(arr[min]);
		
		if (target == arr[min]) {
			return min;
		 }
		
		if (target > arr[min] && target <= arr[arr.length-1]) {
			return binarySearch(arr, target, min+1, arr.length-1);
		} 
		
		else {
			return binarySearch(arr, target, 0, min-1);
		}
		
	}
	 
	public static int findMinElement (int[] arr, int start, int end) {
		
		int mid = (start + end)/2;
		
		if (arr[start] <= arr[end]) {
			return start;
		}
		
		else if ((mid == 0 && arr[mid+1] > arr[mid]) || (mid == arr.length-1 && arr[mid-1] > arr[mid]) ||
				(arr[mid+1] > arr[mid]) && arr[mid-1] > arr[mid] ) {
			return mid;
		}
		
		else if (arr[start] > arr[mid]) {
			return findMinElement(arr, start, mid-1);
		}
		
		else {
			return findMinElement(arr, mid+1, arr.length-1);
		}
	}
	
	public static int binarySearch(int[] arr, int target, int start, int end) {
		
		int mid = (start + end)/2;
		
		if(start > end) {
			return -1;
		}
		
		if (arr[mid] == target) {
			return mid;
		}
		
		if (target < arr[mid]) {
			return binarySearch(arr, target, start, mid-1);
		} 
		
		else {
			return binarySearch(arr, target, mid+1, end);
		}
	}

}

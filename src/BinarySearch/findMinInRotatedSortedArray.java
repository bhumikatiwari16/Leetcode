package BinarySearch;

/*
 * 

https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:

Input: [3,4,5,1,2] 
Output: 1
Example 2:

Input: [4,5,6,7,0,1,2]
Output: 0


 * 
 */

public class findMinInRotatedSortedArray {

	public static void main(String[] args) {
		
		int[] arr = {3,1};
		System.out.println(findMinElemIndex(arr));

	}
	
	public static int findMinElemIndex (int[] arr) {
		
		int res = findMinElemIndexHelper(arr, 0, arr.length-1);
			
		return res;
		
	} 
	
	public static int findMinElemIndexHelper(int[] arr, int start, int end) {

		int mid = (start + end) / 2;
		
		// check if array is already sorted
		
		if (arr[start] < arr[end]) {
			return start;
		}
	
		// check if current mid element is the minimum element:
		// cond.1: if mid == 0, compare mid with right element 
		// cond.2: if mid == last element, compare mid with second last element
		// cond.3: compare mid with left and right neighbors - mid will be lesser than both to become minimum
	
		if ((mid == 0 && arr[mid+1] > arr[mid]) || (mid == arr.length-1 && arr[mid-1] > arr[mid]) 
				|| (arr[mid+1] > arr[mid] && arr[mid] < arr[mid-1])) {
			return mid;
		}
		
		// min will always lie in unsorted part
		// find unsorted part of the array 
		
		else if (arr[start] > arr[mid]) {
			return findMinElemIndexHelper(arr, start, mid-1);
		}
		
		//(arr[mid] > arr[arr.length-1])
		
		else {
			return findMinElemIndexHelper(arr, mid+1, arr.length-1);
		}
		 
		
		
	}

}

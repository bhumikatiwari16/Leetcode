package BinarySearch;

/*
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
 * 
 */


public class firstLastOccurrenceofElement {

	public static void main(String[] args) {
		
		int[] arr = {2,10,10,10,10,10,10,10,10,10,10,18,20};
		int target = 10;
		
		
		int[] resArr = findfirstLastOccurrence(arr, target);
		System.out.println(resArr[0] + "   " + resArr[1]);

	}
	
	public static int[] findfirstLastOccurrence(int[] arr, int target) {
		
		if (arr.length == 0) {
			return new int[]{-1,-1};
		}
		
		if (arr.length == 1 && target == 1) {
			return new int[]{arr.length-1,arr.length-1};
		} 
		
		if (arr.length == 1 && target != 1){
			return new int[]{-1,-1};
		}
		
		int found = binarySearch(arr, target, 0, arr.length-1);
		
		int found1 = found; 
		int found2 = found;
		
		System.out.println(found);
		
		int loop1 = binarySearch(arr, target, 0, found1-1);
		
		while (loop1 != -1 && loop1 < found1) {
			found1= loop1;
			loop1 = binarySearch(arr, target, 0, found1-1);
		}
		
		int loop2 = binarySearch(arr, target, found2+1, arr.length-1);
		
		while (loop2 != -1 && loop2 > found2) {
			found2 = loop2;
			loop2 = binarySearch(arr, target, found2+1, arr.length-1);
		}
		
		int[] resArr = {found1, found2};
		
		return resArr;
		
	}
	
	public static int binarySearch(int[] arr, int target, int start, int end) {
		
		int mid = (start + end)/2;
		
		if (start > end) {
			return -1;
		}
		
		if (arr[mid] == target) {
			return mid;
		}
		
		if (arr[mid] > target) {
			return binarySearch(arr, target, start, mid-1);
		} else {
			return binarySearch(arr, target, mid+1, end);
		}
		
		
	}
	
}

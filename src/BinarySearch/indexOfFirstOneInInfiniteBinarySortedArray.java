package BinarySearch;
/*
 * 
 * https://www.geeksforgeeks.org/find-index-first-1-infinite-sorted-array-0s-1s/
 * 

Given an infinite sorted array consisting 0s and 1s. The problem is to find the index of first ‘1’ in that array. As the array is infinite, therefore it is guaranteed that number ‘1’ will be present in the array.

Examples:

Input : arr[] = {0, 0, 1, 1, 1, 1} 
Output : 2

Input : arr[] = {1, 1, 1, 1,, 1, 1}
Output : 0

 * 
 * 
 * 
 */

public class indexOfFirstOneInInfiniteBinarySortedArray {

	public static void main(String[] args) {
		
		int[] arr = {0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1};
		
		System.out.println(findFirstOne(arr));
		
	}
	
	public static int findFirstOne(int[] arr) {
		
		int start = 0;
		int end = 1;
		
		while (arr[end] != 1) {
			
			start = end;
			end = end * 2;
			
		}
		
		return binarySearch(arr, start, end);
			
	}
	
		
	public static int binarySearch(int[] arr, int start, int end) {
		
		int mid = 0;
		int res = -1;
		
		while (start < end) {
		
			mid = start + (end - start)/2;
			
			if (arr[mid] == 1) {
				
				res = mid;
				end = mid-1;
			} 
			
			else {
				
				start = mid + 1;
				
			}
			
		}
		
		if (arr[start] == 1)
			return start;
		
		return res;
			
	}

}

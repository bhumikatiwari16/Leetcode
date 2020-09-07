package BinarySearch;

/*
 * https://www.geeksforgeeks.org/count-number-of-occurrences-or-frequency-in-a-sorted-array/
 * 
Given a sorted array arr[] and a number x, 
write a function that counts the occurrences of x in arr[]. 
Expected time complexity is O(Log n)
Examples:

Input: arr[] = {1, 1, 2, 2, 2, 2, 3,},   x = 2
Output: 4 // x (or 2) occurs 4 times in arr[]

Input: arr[] = {1, 1, 2, 2, 2, 2, 3,},   x = 3
Output: 1 

Input: arr[] = {1, 1, 2, 2, 2, 2, 3,},   x = 1
Output: 2 

Input: arr[] = {1, 1, 2, 2, 2, 2, 3,},   x = 4
Output: -1 // 4 doesn't occur in arr[] 
 * 
 */


public class countOfElementInSortedArray {

	public static void main(String[] args) {
		
		int[] arr = {2,10,10,10,10,10,10,10,10,10,10,18,20};
		int target = 10;
		
		
		int[] resArr = findfirstLastOccurrence(arr, target);
		System.out.println(resArr[1]-resArr[0]+1);

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

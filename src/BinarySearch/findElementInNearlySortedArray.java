package BinarySearch;

/*
 * https://www.geeksforgeeks.org/search-almost-sorted-array/
 * 
 * Given an array which is sorted, 
 * but after sorting some elements are moved to either of the adjacent positions, 
 * i.e., arr[i] may be present at arr[i+1] or arr[i-1]. 
 * Write an efficient function to search an element in this array. 
 * Basically the element arr[i] can only be swapped with either arr[i+1] or arr[i-1].
 *  For example consider the array {2, 3, 10, 4, 40}, 
 *  4 is moved to next position and 10 is moved to previous position.
 * 
 */
public class findElementInNearlySortedArray {

	public static void main(String[] args) {
		
		//int[] arr = {1,3,10,4,40};
		//int target = 4;
		
		//int[] arr= {10,3,40,20,50,80,70};
		//int target = 40;
		
		int[] arr= {3,2,4,10,40};
		int target = 1;
		
		System.out.println(findElement(arr, target, 0, arr.length-1));

	}
	
	/*
	 * Like binary search, find mid
	 * check for target on mid, mid+1, mid-1
	 * if target < arr(mid-1), then search towards left of (mid-1), so start to mid-2
	 * if target > arr(mid+1), then search towards right of (mid+1), so mid+2 to end
	 */
	public static int findElement(int[] arr, int target, int start, int end) {
		
		if (start > end) {
			return -1;
		}
		
		int mid = (start+end)/2;
		
		if (target == arr[mid]) {
			return mid;
		} 
		
		else if (mid+1 <= end && target == arr[mid+1]) {
			return mid+1;
		}
		
		else if (mid-1 >= start && target == arr[mid-1]) {
			return mid-1;
		}
		
		else if (target > arr[mid]) {
			return findElement(arr, target, mid+2, end);
		} else {
			return findElement(arr, target, start, mid-2);
		}
		
	}

}

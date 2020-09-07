package BinarySearch;

/*
 * https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
 * 
 * Suppose you have a sorted array of infinite numbers, 
 * how would you search an element in the array?

Source: Amazon Interview Experience.
Since array is sorted, the first thing clicks into mind is binary search, 
but the problem here is that we don’t know size of array.
If the array is infinite, that means we don’t have proper bounds to apply binary search. 
So in order to find position of key, first we find bounds and then apply 
binary search algorithm.
 * 
 */

public class elementInInfiniteArray {

	public static void main(String[] args) {

		int arr[] = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170}; 
		int target = 2;

		System.out.println(searchElementInInfiniteArray(arr, target));

	}

	public static int searchElementInInfiniteArray(int[] arr, int target) {

		int start = 0;
		int end = 1;
		//int mid = 0;

		while (arr[end] < target) {
			
			start = end;
			end = end * 2;

		}
		
		return binarySearch(arr, target, start, end);

	}

	

	public static int binarySearch(int[] arr, int target, int start, int end) {

		int mid = 0;

		while (start < end) {

			mid = start + (end-start)/2;

			if (arr[mid] == target) {

				return mid;

			}

			else if (arr[mid] < target) {

				start = mid + 1;

			}  

			else {

				end =  mid - 1;

			}

		}
		
		if (start == end && arr[start] == target) {
			return start;
		}
		
		return -1;
		
	} 
}

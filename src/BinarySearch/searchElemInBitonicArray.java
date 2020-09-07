package BinarySearch;

/*
 * 
 * https://www.youtube.com/watch?v=IjaP8qt1IYI&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=19
 * 
 * https://www.geeksforgeeks.org/find-element-bitonic-array/
 * 
 * Given a bitonic sequence of n distinct elements, write a program to find a given element x in the bitonic sequence in O(log n) time. A Bitonic Sequence is a sequence of numbers which is first strictly increasing then after a point strictly decreasing.

Examples:

Input :  arr[] = {-3, 9, 8, 20, 17, 5, 1};
         key = 20
Output : Found at index 3

Input :  arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
         key = 30
Output : Not Found 
 * 
 */


public class searchElemInBitonicArray {

	public static void main(String[] args) {

		int[] arr = {2,3,4};
		int target = 4;
		
		boolean foundFlag = false;
		
		int ascRes = 0, desRes = 0;

		int maxIndex= searchElem(arr, target);
		
		if (arr[maxIndex] == target) {
			
			System.out.println(maxIndex);
			foundFlag = true;
		}

		else if (maxIndex == 0) {
		
			desRes = binarySearch(arr, target, maxIndex + 1, arr.length - 1, false);
			
		} 
		
		else if (maxIndex == arr.length-1) {
			
			ascRes = binarySearch(arr, target, 0, maxIndex-1, true);
			
		}
		
		else {
			
			ascRes = binarySearch(arr, target, 0, maxIndex-1, true);
			desRes = binarySearch(arr, target, maxIndex + 1, arr.length - 1, false);
				
		}

		if (foundFlag != true) {
			
			int result = ascRes == -1 ? desRes : ascRes;

			System.out.println(result);
			
		}


	}

	public static int searchElem(int[] arr, int target) {

		int start = 0;
		int end = arr.length - 1;
		int mid = 0;
		int res = 0;

		while (start <= end) {

			mid = start + (end - start) / 2;

			if (mid == 0 && arr[mid + 1] < arr[mid]) {
				return mid;
			}

			else if (mid == arr.length - 1 && arr[mid - 1] < arr[mid]) {
				return mid;
			}

			else if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
				return mid;
			}

			else if (arr[mid] > arr[mid - 1]) {
				res = mid;
				start = mid + 1;
			}
           else {
				
				res = arr[mid-1];
				end = mid ;
			}

		}
		
		//System.out.println(res);

		return res;
	}

	public static int binarySearch(int[] arr, int target, int start, int end, boolean isAscending) {

		int mid = 0;

		while (start <= end) {

			mid = start + (end - start) / 2;

			if (arr[mid] == target) {
				return mid;
			}
			if (isAscending) {

				if (target > arr[mid])
					start = mid + 1;
				else
					end = mid - 1;
			}

			else {

				if (target > arr[mid])
					end = mid - 1;
				else
					start = mid + 1;

			}

		}

		if (arr[mid] == target)
			return mid;
		else
			return -1;
	}

}

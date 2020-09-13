package BinarySearch;

public class binarySearchOnReverseSortedArray {

	public static void main(String[] args) {
	
		int[] arr = {8,7,6,5,4,3,2,1};
		int searchTarget = 1;
	
		System.out.println(binarySearchReverse(arr, searchTarget, 0, arr.length-1));
	}

	private static int binarySearchReverse(int[] arr, int searchTarget, int start, int end) {
		
		if (start > end) {
			return -1;
		}
		
		int mid = start + (end-start)/2;
		
		if (arr[mid] == searchTarget) {
			return mid;
		}
		
		if (arr[mid] > searchTarget) {
			return binarySearchReverse(arr, searchTarget, mid+1, end);
		}

		if (arr[mid] < searchTarget) {
			return binarySearchReverse(arr, searchTarget, start, mid-1);
		}
		
		return -1;
	}
	
}



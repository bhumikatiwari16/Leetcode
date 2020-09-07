package BinarySearch;

public class descendingSortedArray {

	public static void main(String[] args) {
		
		int[] arr = {8,7,6,5,4,3,2,1};
		int searchTarget = 9;
	
		System.out.println(findElementInDescendingSortedArray(arr, searchTarget, 0, arr.length-1));

	}
	
	public static int findElementInDescendingSortedArray(int[] arr, int searchTarget, int start, int end) {
		
		int mid = (start + end)/2;
		
		if (start > end) {
			return -1;
		}
		
		if (arr[mid] == searchTarget) {
			return mid;
		}
		
		if (arr[mid] > searchTarget) {
			return findElementInDescendingSortedArray(arr, searchTarget, mid+1, end);
		} 
		
		else {
			return findElementInDescendingSortedArray(arr, searchTarget, start, mid-1);
		}
		
	}

}

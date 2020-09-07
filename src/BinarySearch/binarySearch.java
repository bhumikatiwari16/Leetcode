package BinarySearch;

public class binarySearch {

	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5,6,7,8};
		int searchTarget = 9;
	
		System.out.println(binarySearchImplement(arr, searchTarget, 0, arr.length-1));

	}
	
	public static int binarySearchImplement(int[] arr, int searchTarget, int start, int end) {
		
		int mid = (start + end)/2;
		
		if (start > end) {
			return -1;
		}
		
		if (arr[mid] == searchTarget) {
			return mid;
		} 
		
		if (arr[mid] > searchTarget) {
			return binarySearchImplement(arr, searchTarget, start, mid-1);
		} 
		
		else  {
			return binarySearchImplement(arr, searchTarget, mid+1, end);
		}
		
	}

}

package BinarySearch;

public class minimumDiffElemInSortedArray {

	public static void main(String[] args) {
		
		int[] arr = {4,8,10};
		int key = 3;
		
		System.out.println(findMinDiffElem(arr, key));

	}

	public static int findMinDiffElem(int[] arr, int key) {
		
		int start = 0;
		int end = arr.length - 1;
		int mid = 0;
		int diff1 = 0;
		int diff2 = 0;
		
		while (start <= end) {
			
			mid = start + (end-start)/2;
			
			if (arr[mid] ==  key) {
				return arr[mid];
			}
			 
			else if (arr[mid] < key) {
				diff1 = mid;
				start = mid + 1;
			}
			
			else {
				diff2 = mid;
				end = mid - 1;
			}
		}
		
		int d1 = Math.abs(arr[diff1] - key);
		int d2 = Math.abs(arr[diff2] - key);
		
		if (d1 == d2) {
			return Math.min(arr[diff1], arr[diff2]);
		}
		
		else if (d1 < d2) {
			return arr[diff1];
		}
		
		return arr[diff2];
		
		
		
	}
	
}


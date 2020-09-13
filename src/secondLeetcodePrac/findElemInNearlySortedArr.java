package secondLeetcodePrac;

public class findElemInNearlySortedArr {

	public static void main(String[] args) {
		int[] arr= {3,2,4,10,40};
		int target = 41;
		
		System.out.println(findElement(arr, target, 0, arr.length-1));

	}

	private static int findElement(int[] arr, int target, int start, int end) {
		
		if (start > end) {
			return -1;
		}
		
		int mid = start + (end-start)/2;
		
		if (mid == 0) {
			
			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid+1] == target) {
				return mid+1;
			} 
		
		} 
		
		if (mid == arr.length-1) {
			
			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid-1] == target) {
				return mid-1;
			} 
		
		}
		
		if (mid > 0 && mid < arr.length-1) {
			
			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid-1] == target) {
				return mid-1;
			} else if (arr[mid+1] == target) {
				return mid+1;
			} 
		
		}
		
		if (target < arr[mid]) {
			return findElement(arr, target, start, mid-2);
		}
		
		if (target > arr[mid]) {
			return findElement(arr, target, mid+2, end);
		}
		
		return -1;
	}

}

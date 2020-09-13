package secondLeetcodePrac;

public class NumberOfOccurrencesInSortedArr {

	static int ceil = -1, floor = -1;
	
	public static void main(String[] args) {
		
		int[] arr = {2,2, 2, 2, 2, 3, 3};
		int x = 2;
		
		System.out.println(findCount(arr, x));

	}

	private static int findCount(int[] arr, int x) {
		
		findFloor(arr, x, 0, arr.length-1);
		findCeil(arr, x, 0, arr.length-1);
		
		System.out.println(ceil +  "  " + floor);

		return ceil - floor + 1;
		
	}

	private static void findCeil(int[] arr, int x, int start, int end) {
		
		if (start > end) {
			return;
		}
		
		int mid = start + (end-start)/2;
		
		if (arr[mid] == x) {
			ceil = mid;
			findCeil(arr, x, mid+1, end);
		}
		
		if (arr[mid] < x) {   
			findCeil(arr, x, mid+1, end);
		} 
		
		if (arr[mid] > x) {
			
			findCeil(arr, x, start, mid-1);
		} 
		
	}

	private static void findFloor(int[] arr, int x, int start, int end) {
		
		if (start > end) {
			return;
		}
		
		int mid = start + (end-start)/2;
		
		if (arr[mid] == x) {
			floor = mid;
			findFloor(arr, x, start, mid-1);
		}
		
		if (arr[mid] < x) { 
			
			findFloor(arr, x, mid+1, end);
		} 
		
		if (arr[mid] > x) {
			findFloor(arr, x, start, mid-1);
		}
		
	}
	
	

}

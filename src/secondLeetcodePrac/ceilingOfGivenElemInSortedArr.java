package secondLeetcodePrac;

public class ceilingOfGivenElemInSortedArr {

	static int ceil = -1;
	
	public static void main(String[] args) {
		
		int[] arr = {0,1,3,8,10};
		int target = 11;
		
		int start = 0;
		int end =  arr.length-1;
		
		findCeiling(arr, target, start, end);
		
		System.out.println(ceil);

	}

	private static void findCeiling(int[] arr, int target, int start, int end) {
		
		if (start > end) {
			return;
		}
		
		int mid = start+ (end-start)/2;
		
		if (arr[mid] == target) {
			ceil = arr[mid];
		}
		
		if (arr[mid] > target) {
			ceil = arr[mid];
			findCeiling(arr, target, start, mid-1);
		}
		
		if (arr[mid] < target) {
			findCeiling(arr, target, mid+1, end);
		}
		
	}

}

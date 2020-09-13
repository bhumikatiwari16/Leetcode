package secondLeetcodePrac;

public class FindElemInReverseSortedArray {

	public static void main(String[] args) {
		
		int[] arr = {10, 8, 5, 3, 1};
		int target = 7;
		
		System.out.println(findElem(arr, target, 0, arr.length-1));

	}

	private static int findElem(int[] arr, int target, int start, int end) {
		
		if (start > end) {
			return -1;
		}
		
		int mid = start + (end-start)/2;
		
		if (arr[mid] == target) {
			return mid;
		}
		
		if (arr[mid] > target) {
			return findElem(arr, target, mid+1, end);
		}
		
		if (arr[mid] < target) {
			return findElem(arr, target, start, mid-1);
		}
		
		return -1;
		
	}

}

package secondLeetcodePrac;

public class floorOfGivenElemInSortedArr {

	static int floor = -1;
	
	public static void main(String[] args) {
		
		int[] arr = {0,1,3,8,10};
		int target = 11;
		
		int start = 0;
		int end =  arr.length-1;
	
		findFloor(arr,target, start, end);
		
		System.out.println(floor);
		
	}

	private static void findFloor(int[] arr, int target, int start, int end) {
		
		if (start > end) {
			return;
		}
		
		int mid = start + (end-start)/2;
		
		if (arr[mid] == target) {
			floor = arr[mid];
		}
		
		else if (arr[mid] > target) {
			findFloor(arr, target, start, mid-1);
		}
		
		else if (arr[mid] < target) {
			floor =  arr[mid];
			findFloor(arr, target, mid+1, end);
		}
		
	}

}

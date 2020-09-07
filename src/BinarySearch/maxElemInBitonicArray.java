package BinarySearch;

/*
 * 
 * https://www.youtube.com/watch?v=BrrZL1RDMwc&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=18
 * 
*
 * 
 */

public class maxElemInBitonicArray {

	public static void main(String[] args) {
		
		int[] arr = {2,3,4};
		
		System.out.println(findMaxElem(arr));

	}
	
	public static int findMaxElem(int[] arr) {
		
		int start = 0;
		int end = arr.length - 1;
		int mid = 0;
		int res = 0;
		
		while (start <= end) {
			
			mid = start +  (end - start)/2;
			
			if (mid == 0 && arr[mid] > arr[mid + 1]) {
				return arr[mid];
			}
			
			else if (mid == arr.length - 1 && arr[mid] > arr[mid-1]) {
				return arr[mid];
			}
			
			else if (arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) {
				return arr[mid];
			}
			
			else if (arr[mid] > arr[mid-1]) {
				
				res = arr[mid];
				start = mid+1;
				
			}
			
			else {
				
				res = arr[mid-1];
				end = mid ;
			}
		
		}
		
		return res;
		
	}

}

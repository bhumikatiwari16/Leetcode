package sliding_window;

/*
 * https://www.geeksforgeeks.org/find-maximum-minimum-sum-subarray-size-k/?ref=lbp
 * 
 * Given an array of integers and a number k, find maximum sum of a subarray of size k.

Examples :

Input  : arr[] = {100, 200, 300, 400}
         k = 2
Output : 700

Input  : arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20}
         k = 4 
Output : 39
We get maximum sum by adding subarray {4, 2, 10, 23}
of size 4.

Input  : arr[] = {2, 3}
         k = 3
Output : Invalid
There is no subarray of size 3 as size of whole
array is 2
 * 
 */

class maximumSumOfSubarrayOfSizeK {

	public static void main(String[] args) {
		
		int[] arr = {2, 3};
        int k = 3;

        if (k > arr.length) {
        	System.out.println("Invalid");
        }
        else {
        	System.out.println(findMaxSum(arr, k));
        }
        
	}
	
	public static int findMaxSum(int[] arr, int k) {
		
		int maxSum = Integer.MIN_VALUE;
		int curSum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			
			curSum += arr[i];
			
			if (i >= k-1) {
				maxSum = Math.max(maxSum, curSum);
				curSum = curSum - arr[i - (k-1)];
			}
			
		}
		
		return maxSum;
	}

}

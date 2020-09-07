package dp;

/*
 * MINIMUM SUBSET SUM DIFFERENCE
 * Partition a set into two subsets such that the difference of subset sums is minimum
 * 
 * https://www.youtube.com/watch?v=-GtpxG6l_Mc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=10
 * https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/
 * 
 * Given a set of integers, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum.

	If there is a set S with n elements, 
	if we assume Subset1 has m elements, 
	Subset2 must have n-m elements and 
	the value of abs(sum(Subset1) – sum(Subset2)) should be minimum.
 * 
 */

public class minimumSubsetSumDiff {

	public static void main(String[] args) {
		
		int[] a1 = {1,2,7,1,5};
		System.out.println(minSubsetSumDiff(a1));
		
		int[] a2 = {1,2,3,9};
		System.out.println(minSubsetSumDiff(a2));
		
		int[] a3 = {1, 3, 100, 4};
		System.out.println(minSubsetSumDiff(a3));

	}
	
	public static int minSubsetSumDiff(int[] arr) {
		
		int range = 0;
		int found = 0;
		int mid = 0;
		
		// Calculate sum of all array elements in range variable.
		
		for(int i = 0; i < arr.length; i++) {
			range += arr[i];
		}
		
		// Check using subsetSum problem logic that what all sum values are possible using given array
		// because 0 to range: all values on no.line cannot be the sum with elements in the given array
		// Last row of subsetSum 2d array is the result of sum values possible with all elements of given array
		
		boolean[] possibleSumValues = subsetSum(arr, range);
		System.out.println(possibleSumValues.length);
		
		//mid point of possibleSumValues array gives the mid point of 0-range.
		//for diff of subset S1 and S2 to be minimum, 
		//sum of elements of S1 should be nearest to mid point of 0-range.
		
		if (possibleSumValues.length % 2 != 0) {
			mid = possibleSumValues.length/2;
		} else {
			mid = (possibleSumValues.length/2) + 1;
		}
		System.out.println("m" + mid);
		
		// nearest value of sum of elements of S1 to mid point of 0-range is sum of S1 elements.
		// sum of s2 elements = range-sum of S1 elements
		
		for (int i = mid; i >= 0; i--) {
			if (possibleSumValues[i] == true) {
				found = i;
				break;
			}
		}
		System.out.println("r" + range);
		System.out.println("f" + found);
		
		//sum of S1 elements DIFF sum of S2 elements is answer.
		int result = Math.abs(found - (range - found));
		return result;
	}
	
	public static boolean[] subsetSum(int[] arr, int sum) {
		
		boolean[][] dp = new boolean[arr.length + 1][sum + 1];
		
		for (int i = 0; i < arr.length + 1; i++) {
			for (int j = 0; j < sum + 1; j++) {
				
				if (i == 0 && j!= 0) {
					dp[i][j] = false;
				} 
				
				else if (j == 0) {
					dp[i][j] = true;
				} 
				
				else if (arr[i-1] <= j) {
					boolean a = dp[i-1][j-arr[i-1]];
					boolean b = dp[i-1][j];
					dp[i][j] = a || b;
				}
				
				else {
					dp[i][j] = dp[i-1][j];
				}
				
			}
		}
		
		boolean[] possibleSumValues = dp[arr.length]; 
		return possibleSumValues;
		
	}
	

}

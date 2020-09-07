package dp;

import java.util.Arrays;

public class countSubsetWithGivenSum {

	/*
	 * COUNT OF SUBSETS WITH SUM EQUAL TO X
	 * 
	 * https://www.youtube.com/watch?v=ot_XBHyqpFc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=11
	 * https://www.geeksforgeeks.org/count-of-subsets-with-sum-equal-to-x/
	 * 
	* Given a set of positive numbers, 
	* find the total number of subsets whose sum is equal to a given number ‘S’.
	*  ***************************
	*   Input: {1, 1, 2, 3}, S=4
		Output: 3
		The given set has '3' subsets whose sum is '4': {1, 1, 2}, {1, 3}, {1, 3}
		Note that we have two similar sets {1, 3}, because we have two '1' in our input.
	*  ***************************
	*   Input: {1, 2, 7, 1, 5}, S=9
		Output: 3
		The given set has '3' subsets whose sum is '9': {2, 7}, {1, 7, 1}, {1, 2, 1, 5}
	*/
	
	public static void main(String[] args) {
		
		int[] arr = {1,0,0,0,0,0,0,0,0};
		int target = 1;
		int length = arr.length;
		
		int[][] dp = new int[length+1][target+1];
		for (int[] a:dp) {
			Arrays.fill(a, -1);
		}
	
		
		System.out.println(countSubsetRecursive(arr, target, length));
		System.out.println(countSubsetMemoization(dp, arr, target, length));
		System.out.println(countSubsetBottomUp(arr, target, length));

	}
	
	public static int countSubsetRecursive(int[] arr, int target, int length) {
		
		if (target == 0) {
			return 1;
		} 
		else if (length == 0) {
			return 0;
		} 
		else if (arr[length-1] <= target) {
			int a = countSubsetRecursive(arr, target-arr[length-1], length-1);
			int b = countSubsetRecursive(arr, target, length-1);
			int res = a + b;
			return res;
		}
		else  {
			return countSubsetRecursive(arr, target, length-1);
		}
	}
	
	public static int countSubsetMemoization(int[][] dp, int[] arr, int target, int length) {
		
		if (length == 0 && target != 0) {
			dp[length][target] = 0;
		}
		else if (target == 0) {
			dp[length][target] = 1;
		}
		else if (dp[length][target] != -1) {
			System.out.println("inside memo");
		}
		else if (arr[length-1] <= target) {
			int a = countSubsetMemoization(dp, arr, target-arr[length-1], length-1);
			int b = countSubsetMemoization(dp, arr, target, length-1);
			dp[length][target] = a + b;
		} 
		else {
			dp[length][target] = countSubsetMemoization(dp, arr, target, length-1);
		}
		
		return dp[length][target];
	}
	
public static int countSubsetBottomUp(int[] arr, int target, int length) {
	
	int[][] bottomUp = new int[length+1][target+1];
	
	for (int i = 0; i < length+1; i++) {
	
		for (int j = 0; j < target+1; j++) {
		
			if (i == 0 && j != 0) {
				bottomUp[i][j] = 0; 
			} 
			else if (j == 0) {
				bottomUp[i][j] = 1;
			} 
			else if (arr[i-1] <= j) {
				int a = bottomUp[i-1][j-arr[i-1]];
				int b = bottomUp[i-1][j];
				bottomUp[i][j] = a + b;
			}
			else {
				bottomUp[i][j] = bottomUp[i-1][j];
			}
		}
	}
		
	return bottomUp[length][target];
		
}

}

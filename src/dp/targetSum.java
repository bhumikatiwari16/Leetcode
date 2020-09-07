package dp;

import java.util.Arrays;
import java.util.Collections;

public class targetSum {

	/*
	 * TARGET SUM PROBLEM
	 * https://leetcode.com/problems/target-sum/
	 * 
	 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. 
	 * Now you have 2 symbols + and -. 
	 * For each integer, you should choose one from + and - as its new symbol.
	 * Find out how many ways to assign symbols to make sum of integers equal to target S.
	 * 
	 * 
	 *  Input: nums is [1, 1, 1, 1, 1], S is 3. 
		Output: 5
		Explanation: 

		-1+1+1+1+1 = 3
		+1-1+1+1+1 = 3
		+1+1-1+1+1 = 3
		+1+1+1-1+1 = 3
		+1+1+1+1-1 = 3

	There are 5 ways to assign symbols to make the sum of nums be target 3.
	 */
	
	public static void main(String[] args) {
	
		Integer[] arr = {0,0,0,0,0,0,0,0,1};
		
		Arrays.sort(arr, Collections.reverseOrder());
		
		int targetSum = 1;
		
		if (targetSum > 1000) {
	            System.out.println(0);
	            return;
	    }
		 
		if (arr.length == 1 && Math.abs(arr[0]) != Math.abs(targetSum)) {
			System.out.println(0);			
		}
		
		else  {
			
		int range = 0;
		
		for (int i = 0; i < arr.length; i++) {
			range += arr[i];
		}
		
		int s1 = (targetSum + range)/2;
		
		int[][] dp = new int[arr.length+1][s1+1];
		
		for(int[] row: dp) {
			Arrays.fill(row, -1);
		}
		
		System.out.println(countSubsetsWithGivenSum(dp, arr, s1, arr.length));
		}
	}
	
	public static int countSubsetsWithGivenSum(int[][] dp, Integer[] arr, int targetSum, int length) {
		
		if (length == 0 && targetSum != 0) {
			dp[length][targetSum] = 0;
		}
		
		else if (targetSum == 0) {
			dp[length][targetSum] = 1;
		}
		
		else if (dp[length][targetSum] != -1) {
			
		}
		
		else if(arr[length-1] <= targetSum) {
			int a = countSubsetsWithGivenSum(dp, arr, targetSum-arr[length-1], length-1);
			int b = countSubsetsWithGivenSum(dp, arr, targetSum, length-1);
			int res = a + b;
			dp[length][targetSum] = res;
		}
		
		else {
			dp[length][targetSum] = countSubsetsWithGivenSum(dp, arr, targetSum, length-1);
		}
		
		return dp[length][targetSum];
			
	}

}

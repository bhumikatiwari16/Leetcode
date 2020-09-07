package dp;

import java.util.Arrays;

/*
 
 https://www.youtube.com/watch?v=ot_XBHyqpFc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=11
 
 Find count of subsets with a given difference.
 
 Inputs:
 arr = {1,1,2,3}
 diff = 1
 
 */

public class countNumberOfSubsetWithGivenDiff {

	public static void main(String[] args) {
		
		int[] arr = {1,1,2,3};
		int diff = 1;
		System.out.println(countSubset(arr, diff));

	}
	
	public static int countSubset(int[] arr, int diff) {
		
		//s1 subset + s2 subset = sum of all elements in array
		//s1 subset - s2 subset = provided difference in problem statement
		//2s1 subset = sum of all elements in array + provided difference in problem statement
		//s1 subset = (sum of all elements in array + provided difference in problem statement)/2
		//problem then reduces to finding all subsets with sum = sum of subset s1
		//i.e. countSubsetWithGivenSum problem
		
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		
		int s1 = (sum + diff)/2;
		
		int length = arr.length;
		
		int[][] dp = new int[length+1][s1+1];
		for(int[] row: dp) {
			Arrays.fill(row, -1);
		}
		
		//int res = countSubsetWithGivenSumRecursive(arr, length, s1);
		int res = countSubsetWithGivenSumMemoization(arr, length, s1, dp);
		//int res = countSubsetWithGivenSumBottomUp(arr, length, s1);
		
		return res;
	
	}
	
	public static int countSubsetWithGivenSumRecursive(int[] arr, int length, int target) {
		
		//System.out.println("length" + length + "     target" + target);
		
		if (target == 0) {
				return 1;
			}
		
		else if (length == 0){
			return 0;
		} 
		
		else if (arr[length-1] <= target) {
			int a = countSubsetWithGivenSumRecursive(arr, length-1, target- arr[length-1]);
			int b = countSubsetWithGivenSumRecursive(arr, length-1, target);
			int c = a+ b;
			return c;
		} 
		else {
			return countSubsetWithGivenSumRecursive(arr, length-1, target);
		}
		
	}

	public static int countSubsetWithGivenSumMemoization(int[] arr, int length, int target, int[][] dp) {
		
		/*
		 if (length == 0 && target!=0) {
			dp[length][target] = 0;
		}
		 else if (target == 0) {
			dp[length][target] = 1;
		} 
		*/
		
		if (dp[length][target] !=  -1) {
			return dp[length][target];
		}
		

		else if (target == 0) {
				return 1;
			}
		
		else if (length == 0){
			return 0;
		} 
		
		else if (arr[length-1] <= target) {
			int a = countSubsetWithGivenSumMemoization(arr,length-1,target-arr[length-1],dp);
			int b =countSubsetWithGivenSumMemoization(arr,length-1,target,dp);
			dp[length][target] = a + b;
		} 
		
		else {
			dp[length][target] = countSubsetWithGivenSumMemoization(arr,length-1,target,dp);
		}
		
		return dp[length][target];
	}
	
	public static int countSubsetWithGivenSumBottomUp(int[] arr, int length, int target) {
		
		int[][] bu = new int[length+1][target+1];
		
		for (int i = 0; i < length+1; i++) {
			for(int j = 0; j < target+1; j++) {
				
				if (j == 0) {
					bu[i][j] = 1;
				} 
				
				else if (i == 0) {
					bu[i][j] = 0;
				}
			
				else if (arr[i-1] <= j) {
					int a = bu[i-1][j-arr[i-1]];
					int b = bu[i-1][j];
					bu[i][j] = a + b;
				} else {
					bu[i][j] = bu[i-1][j];
				}
				
			}
		}
		
		return bu[length][target];
		
	}
		
	
}

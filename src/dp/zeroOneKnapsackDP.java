package dp;

import java.util.Arrays;

/*
 * ZERO ONE KNAPSACK-CLASSIC
 * 
 * https://www.youtube.com/watch?v=kvyShbFVaY8&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=3
 * https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
 * 
 * Given weights and values of n items, put these items in a knapsack of capacity W to get the 
 * maximum total value in the knapsack. In other words, given two integer arrays val[0..n-1] 
 * and wt[0..n-1] which represent values and weights associated with n items respectively. 
 * Also given an integer W which represents knapsack capacity, 
 * find out the maximum value subset of val[] 
 * such that sum of the weights of this subset is smaller than or equal to W. 
 * You cannot break an item, either pick the complete item or don’t pick it (0-1 property).
 * 
 */

public class zeroOneKnapsackDP {

	public static void main(String[] args) {
		
		int[] weight = {1,2,3,5};
		int[] value = {1,6,10,16};
		int capacity = 7;
		
		int itemCount = weight.length;
		int[][] dpArr = new int[capacity+1][itemCount+1];
		
		for (int[] row : dpArr) {
            Arrays.fill(row, -1);
		}
		
		System.out.println("Max Value " + zeroOneKnapsack(dpArr, weight, value, capacity, itemCount));
		
	}

	public static int zeroOneKnapsack(int[][] dpArr, int[] weight, int[] value, int capacity, int n) {
	
		//base condition
		if (capacity == 0 || n == 0) {
			dpArr[capacity][n] = 0;
		
		}
	
		//dp array check
		else if (dpArr[capacity][n] != -1) {

		}
		
		// RECURSIVE CALLS
		else if (weight[n-1] > capacity) {
			dpArr[capacity][n] = zeroOneKnapsack(dpArr, weight, value, capacity, n-1);
			
		}
		
		else {
			int a = value[n-1] + zeroOneKnapsack(dpArr, weight, value, capacity-weight[n-1], n-1);
			int b = zeroOneKnapsack(dpArr, weight, value, capacity, n-1);
			int res = Math.max(a, b);
			dpArr[capacity][n] = res;
			
		}
		
		return dpArr[capacity][n];
	
	}
}

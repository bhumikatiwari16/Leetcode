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

public class zeroOneKnapsackBottomup {

	public static void main(String[] args) {
		
		int[] weight = {1,2,3,5};
		int[] value = {1,6,10,16};
		int capacity = 7;
		
		//zeroOneKnapsack(weight, value, capacity);
		System.out.println("Max Value " + zeroOneKnapsack(weight, value, capacity));	

	}
	
	public static int zeroOneKnapsack(int[] weight, int[] value, int capacity) {
		
		// creating a 2d matrix: the two variable dimensions of the memoization
		// solution for this problem are taken as rows and columns
		int[][] dp = new int[weight.length + 1][capacity + 1];

		for (int i = 0; i < weight.length + 1 ; i++) {
			 for (int j = 0; j < capacity + 1; j++) {
				
				 // base condition for memoization
				 // first row and first column for 2d matrix is initialised to 0
				 // profit = 0 when number of items = 0 or bag capacity = 0 
				 if (i == 0 || j == 0) { 
					 dp[i][j] = 0;
				 } 
				 
				 // weight of item under consideration is less than capacity of bag
				 // value of i in 2d matrix corresponds to (i-1)th element in weight and value arrays
				 // hence, weight(i-1) is compared with the corresponding matrix cell capacity(i.e.column)
				 
				 else if (weight[i-1] <= j){
					 
					 // possibility 1: when item having weight(i-1) is added to bag
					 // item having weight(i-1) has value(i-1)
					 // this value added to array value for (i-1)th row and (j-weight[i-1])th column
					 // because :
					 // 1) the total capacity reduced by weight(i-1) after deciding item inclusion
					 // 2) total no.of elements reduced by 1 after deciding item inclusion
					 
					 int a = value[i-1] + dp[i-1][j-weight[i-1]];
					 
					// possibility 1: when item having weight(i-1) is not added to bag
					// 1) the total capacity remains as is after deciding item exclusion
					// 2) total no.of elements reduced by 1 after deciding item exclusion
					 
					 int b = dp[i-1][j];
					 
					 // max of a and b taken to find maximum profit value 
					 dp[i][j] = Math.max(a, b);	 
					 
				 }
				 
				 
				 // weight of item under consideration is more than capacity of bag
				 // hence item having weight(i-1) is not added to bag
				 else {
					 
					// 1) the total capacity remains as is after deciding item exclusion
					// 2) total no.of elements reduced by 1 after deciding item exclusion
					 
					 dp[i][j] = dp[i-1][j];
					 
				 }
			
			}
		}
		
		return dp[weight.length][capacity];
		
	}

}

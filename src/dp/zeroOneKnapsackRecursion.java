package dp;

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

public class zeroOneKnapsackRecursion{

	public static void main(String[] args) {
		
		int[] weight = {1,2,3,5};
		int[] value = {1,6,10,16};
		int capacity = 7;

		System.out.println("Max Value " + zeroOneKnapsack(weight, value, capacity, weight.length));
		
	}
	
	public static int zeroOneKnapsack(int[] weight, int[] value, int capacity, int n) {
		
		// base condition for recursion
		if (capacity == 0 || n == 0) {
			return 0;
		}
		
		
		if(weight[n-1] > capacity) {
			return (zeroOneKnapsack(weight, value, capacity, n-1));
		}
		
		else {
			int a = value[n-1] + zeroOneKnapsack(weight, value, capacity-weight[n-1], n-1);
			int b = zeroOneKnapsack(weight, value, capacity, n-1);
			int answer = Math.max(a, b);
			return answer;
		}
	    
	   
		
		
	}
	
	
	

}

	package dp;

public class subsetSumKnapsack {
	
/*
 * SUBSET SUM PROBLEM
*   https://www.youtube.com/watch?v=_gPcYovP7wc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=7
*    
*  Given a set of positive numbers, 
*  determine if there exists a subset whose sum is equal to a given number ‘S’. 
*  ***************************
*  Input: {1, 2, 3, 7}, S=6
*  Output: True
*  The given set has a subset whose sum is '6': {1, 2, 3}
*  ***************************
*  Input: {1, 3, 4, 8}, S=6
*  Output: False
*  The given set does not have any subset whose sum is equal to '6'.
*/
	public static void main(String[] args) {
		
		int[] arr = {2,3,7,8,10};
		int sum = 14;
		
		System.out.println(subsetSum(arr, sum));
		
	}
	
	public static boolean subsetSum(int[] arr, int sum) {
		
		
		int arrSize = arr.length;
		boolean[][] dp = new boolean[arrSize+1][sum+1];
		
		for(int i = 0; i < arrSize + 1 ; i++) {
			for (int j = 0; j < sum + 1; j++) {
				
				/* ********* Base conditions for first row and first column ********* */
				
				
				
				if (i == 0 && j!= 0) {
					dp[i][j] = false;
				} 
				
				// empty subset possible in all these cases
				else if (j == 0) {
					dp[i][j] = true;
				} 
				
				 // item under consideration in array is less than total sum
				 // value of i in 2d matrix corresponds to (i-1)th element in array
				 // hence, array(i-1) is compared with the corresponding matrix cell capacity(i.e.column)
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
		
		return dp[arrSize][sum];	
	}

}

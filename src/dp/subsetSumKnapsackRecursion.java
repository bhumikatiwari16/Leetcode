package dp;

public class subsetSumKnapsackRecursion {

	/*
	 * SUBSET SUM PROBLEM
	 * https://www.youtube.com/watch?v=_gPcYovP7wc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=7
	 *   
	 *   
	*Given a set of positive numbers, 
	* determine if there exists a subset whose sum is equal to a given number ‘S’. 
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
		
		int[] arr = {};
		int sum = 1;
		
		int n = arr.length;
		
		System.out.println(subsetSum(arr, sum, n));
		
	}
	
	public static boolean subsetSum(int[] arr, int sum, int n) {
	
		if(sum == 0 && n == 0) {
			return true;
		}
		
		else if (sum == 0) {
			return true;
		} 
		
		else if(n == 0) {
			return false;
		}
		
		else if (arr[n-1] <= sum) {
			boolean a = subsetSum(arr, sum-arr[n-1], n-1);
			boolean b = subsetSum(arr, sum, n-1);
			boolean res = a || b;
			return res;
		}
		
		else {
			return subsetSum(arr, sum, n-1);
		}
		
	
	}

}

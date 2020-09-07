package dp;

public class subsetSumPartition {
	
	/*
	 * EQUAL SUM PARTITION PROBLEM
	 * https://www.youtube.com/watch?v=UmMh7xp07kY&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=8
	 * https://www.geeksforgeeks.org/partition-problem-dp-18/
	 * 
	* Given a set of positive numbers, 
	* find if we can partition it into two subsets 
	* such that the sum of elements in both the subsets is equal.
	*  ***************************
	*  	Input: {1, 2, 3, 4}
		Output: True
		Explanation: The given set can be partitioned into two subsets with equal sum: {1, 4} & {2, 3}
	*  ***************************
	*   Input: {2, 3, 4, 6}
		Output: False
		Explanation: The given set cannot be partitioned into two subsets with equal sum.
	*/
	
	static boolean[][] dpArr;
	
	public static void main(String[] args) {
		
		int[] arr = {1,5,11,7,1,8,9};
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		if (sum % 2 != 0) {
			System.out.println(false);
		}
		else {
			System.out.println(subsetSum(arr, sum/2, arr.length));
			dpArr = new boolean[(sum/2)+1][arr.length+1];
			System.out.println(subsetSumMemoization(dpArr, arr, sum/2, arr.length));
		}

	}
	
	public static boolean subsetSum (int[] arr, int sum, int n) {
		
		if(sum == 0) {
			return true;
		} else if (n == 0) {
			return false;
		}
		
		if (arr[n-1] <= sum) {
			boolean a = subsetSum(arr, sum-arr[n-1], n-1);
			boolean b = subsetSum(arr, sum, n-1);
			boolean res = a || b;
			return res;
		} else {
			return subsetSum(arr, sum, n-1);
		}
		
	}
	
	public static boolean subsetSumMemoization (boolean[][] dpArr, int[] arr, int sum, int n) {
		
		if(sum == 0) {
			//System.out.println("sum=0");
			dpArr[sum][n] = true;
		} else if (n == 0) {
			//System.out.println("n=0");
			dpArr[sum][n] = false;
		}
		
		else if (dpArr[sum][n] == true) {
			System.out.println("inside memoization");
			return true;
		}
		
		else if (arr[n-1] <= sum) {
			//System.out.println("inside less than");
			boolean a = subsetSumMemoization (dpArr, arr, sum - arr[n-1], n-1);
			boolean b = subsetSumMemoization (dpArr, arr, sum, n-1);
			dpArr[sum][n] = a || b;
		} 
		
		else {
			//System.out.println("inside greater than");
			dpArr[sum][n] = subsetSumMemoization (dpArr, arr, sum, n-1);
			
		}
		
		return dpArr[sum][n];
		
	}

}

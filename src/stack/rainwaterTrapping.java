package stack;

/*
 * https://leetcode.com/problems/trapping-rain-water/
 * 
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 * compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
In this case, 6 units of rain water (blue section) are being trapped. 

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
 * 
 * 
 */

public class rainwaterTrapping {

	public static void main(String[] args) {
		
		int[] arr = {1};
		
		System.out.println(findTotalWater(arr));

	}
	
	
	public static int findTotalWater(int[] arr) {
		
		int cur = 0, width = 0, curBuildWaterArea = 0, totArea = 0;
		
		//Calculate max left height at each index
		int[] leftGr = findLeftGreatest(arr);
		
		//Calculate max right height at each index
		int[] rightGr = findRightGreatest(arr);
		
		
		//Water at particular index will depend on sum of (Math.min (Max_Left_Height,
		// Max_Right_Height) at Index i - Current Height)
		
		for (int i = 0; i < arr.length; i++) {
			
			cur = arr[i];
			width = Math.min(leftGr[i], rightGr[i]);
			curBuildWaterArea = width - cur;
			totArea += curBuildWaterArea;
		}
		
		return totArea;
		
	}
	
	public static int[] findLeftGreatest(int[] arr) {
		
		int[] leftGr = new int[arr.length];
		int max = 0;
		
		for (int j = 0; j < arr.length; j++) {
			max = Math.max(max, arr[j]);
			leftGr[j] = max;
		}
		
		return leftGr;
		
	}
	
	public static int[] findRightGreatest(int[] arr) {
		
		int[] rightGr = new int[arr.length];
		int max = 0;
		
		for (int j = arr.length - 1; j >= 0; j--) {
			max = Math.max(max, arr[j]);
			rightGr[j] = max;
		}
		
		return rightGr;
		
	}

}

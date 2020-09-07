package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://leetcode.com/problems/3sum/
 * 
 * Given an array nums of n integers, 
 * are there elements a, b, c in nums such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.
 * 
 * 
Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]

 */

public class ThreeSum {

	public static void main(String[] args) {

		// int[] nums = {-1, 0, 1, 2, -1, -4};
		
		int[] nums = {0,0,0,0};
		List<List<Integer>> res = threeSum(nums);

		for(List<Integer> l: res) {
			
			System.out.println(l);
			
		}

	}

	public static List<List<Integer>> threeSum(int[] nums) {

		
		List<List<Integer>> result = new ArrayList<>();

		Arrays.sort(nums);

		int len = nums.length;

		// i pointer fixed from 0 to third last element of the given array
		for (int i = 0; i < len-2; i++) {
			
			// duplicate check for value at Ith index with (I-1)th index
			/* Below code also works....
			while (i > 0 && i < len && nums[i] == nums[i-1]) {
				i++;
			}
			*/
			if (i > 0 && i < len && nums[i] == nums[i-1]) {
				continue;
			}
			

			// j pointer fixed from element next to Ith element
			int j = i + 1;
			// k pointer fixed at last element of array
			int k = len - 1;

			// find other two elements from j to k by reducing the window as per logic 
			// in code below
			while (j < k) {
				
				// make a new inner list every time
				List<Integer> curLst = new ArrayList<>();
				
				int curSum = nums[i] + nums[j] + nums[k];

				// if curSum = 0, add the Ith,Jth and Kth elements of array to inner list
				
				if (curSum == 0) {
					curLst.add(nums[i]);
					curLst.add(nums[j]);
					curLst.add(nums[k]); 
					result.add(curLst);
					
					//increment j pointer by 1 and move k backward by 1
					//because if we keep one of them fix and only move the other one
					// only the value at fixed one found first and added in curLst will be needed to make the sum
					// and that will be a duplicate entry, if at all present in the array
					j++;
					k--;

					//duplicate check for j and k
					while (j < k && nums[j] == nums[j-1] ) {
						j++;
					}
					while (j < k && nums[k] == nums[k+1]) {
						k--;
					}


				}

				// if curSum > 0, we need to reduce the sum, so we need to move 
				// towards lesser elements in the array
				else if (curSum > 0) {
					k--;
				} 

				// if curSum < 0, we need to increase the sum, so we need to move 
				// towards greater elements in the array
				else {
					j++;
				}
			}

		}

		return result;



	}

}

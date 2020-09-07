package BinarySearch;

/*
 * https://www.youtube.com/watch?v=VS0BcOiKaGI&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=20
 * 
 * https://leetcode.com/problems/search-a-2d-matrix/
 * 
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
Example 1:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true
Example 2:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false
 * 
 * 
 */

public class searchRowWiseColumnWiseSortedArray {

	public static void main(String[] args) {
		
		int[][] arr = { 
							{1, 3}
		                    
					  };
		
		int target = 1;
		
		System.out.println(findElem(arr, target));

	}
	
	public static boolean findElem(int[][] arr, int target) {
		
		int row = arr.length;
		int column = arr[0].length;
		
		int i = 0;
		int j = column-1;
	
		
		while (i >= 0 && j >= 0 && i < row && j < column ) {
			
			if (arr[i][j] == target) {
				return true;
			}
			
			else if (target > arr[i][j]) {
				i++;
			}
			
			else {
				j--;
			}
			
		}
		
		return false;
		
	}

}

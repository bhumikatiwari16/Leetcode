package leetcode.Array;

public class MoveZeroes {

	public static void main(String[] args) {
		
		int[] a = new int[] {0,1};
		moveZeroes(a);
		printArray(a);
		
	}
	
	public static void moveZeroes(int[] nums) {
        
		int i = 0;
		int j = 0;
		
		while (i < nums.length) {
			
			if(nums[i] != 0) {
				nums[j] = nums[i];
				j++;
			}
			
			i++;
		}
		
		if (j < nums.length) {
			while (j < nums.length) {
				nums[j] = 0;
				j++;
			}
		}
		
    }
	
	public static void printArray(int[] a) {
		
		int i = 0;
		while(i < a.length) {
			System.out.println(a[i]);
			i++;
		}
		
		
	}

}

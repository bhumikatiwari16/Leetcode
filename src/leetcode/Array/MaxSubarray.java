package leetcode.Array;

public class MaxSubarray {
	
	public static void main(String args[]) {
		
		int[] arrays = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArr(arrays));
		
	}
	
	public static int maxSubArr(int[] a) {
		
		int sum = Integer.MIN_VALUE;
		int i = 0; int j;
		int l = a.length;
		int temp = 0;
		
		while (i < l) {
			
			j = i + 1;
			temp = a[i];
			
			if (sum < temp) {
				sum = temp;
			}
			
			while (j < l) {
				
				temp += a[j];
				
				if (sum < temp) {
					sum = temp;
				}
				
				j++;
			}
			
			
			
			i++;
			
		}
			
		return sum;
		
	}

}

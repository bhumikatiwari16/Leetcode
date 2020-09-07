package leetcode.Array;

public class maxSubArrayKadane {

	public static void main(String args[]) {
		
		
		System.out.println(maxSumArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
		
	}
	
	public static int maxSumArray(int[] a) {
		
		int i = 0;
		int sum = 0, max = 0, maxElem = Integer.MIN_VALUE;
		
		while (i < a.length) {
			
			sum = sum + a[i];
			if (sum < 0)
				sum = 0;
			
			max = Math.max(max, sum);
			maxElem = Math.max(maxElem, a[i]);
			
			i++;
			
		}
		
		if (max == 0) {
			max = maxElem;
		}
		
		return max;
		
	}
	
	
}

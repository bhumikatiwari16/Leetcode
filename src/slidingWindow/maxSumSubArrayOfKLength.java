package slidingWindow;


//fixed length sliding window where fixed length is k

public class maxSumSubArrayOfKLength {

	public static void main(String[] args) {
	
		int[] a = new int[] {1,4,2,10,23,3,1,0,20};
		int k = 4;
		
		System.out.println(maxSum(k,a));
		

	}
	
	static int maxSum (int k, int[] a) {
		
		int currentSum = 0;
		int maxSum = Integer.MIN_VALUE;
		
		for (int i = 0; i < a.length; i++) {
		
			currentSum += a[i];
			
			if (i >= k-1) {
				maxSum = Math.max(maxSum, currentSum);
				currentSum = currentSum - a[i-(k-1)];
			
			}
	
		} 
		
		return maxSum;
	}

}

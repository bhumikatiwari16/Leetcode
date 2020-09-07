package slidingWindow;

// dynamic length sliding window where smallest subarray to be found with sum of elements
// >= given Sum

public class smallestSubArrayWithGivenSum {

	public static void main(String[] args) {
		
		int[] a = new int[] {4,2,2,7,8,1,2,8,10};
		int targetSum = 8;
	
		System.out.println(smallestSubarray(a, targetSum));
	}
	
	static int smallestSubarray(int[] a, int targetSum) {
		
		int curSum = 0;
		int curLength = 0;
		int minLength = Integer.MAX_VALUE;
		int wStart = 0;
		
		for (int wEnd = 0; wEnd < a.length; wEnd++) {
			
			curSum += a[wEnd];
			//curLength = wEnd - wStart + 1;
			
			while (curSum >= targetSum) {
				curLength = wEnd - wStart + 1;
				minLength = Math.min(minLength, curLength);
				curSum -= a[wStart];
				wStart++;
			}
			
		}
		
		return minLength;
	}
	
	
}

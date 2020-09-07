package dynamicProgramming;

public class minHopsToArrayEnd {

	public static void main(String[] args) {
		
		int[] arr = new int[] {1, 1, 3, 6, 9, 3, 0, 1, 3};
		System.out.println(minHopCount(arr));
	}
	
	static int minHopCount (int[] arr) {
		int[] dp = new int[arr.length];
		return minHopCountMain(arr, dp, 0);
	}
	
	static int minHopCountMain (int[] arr, int[]dp, int cur) {
		
		if (cur == arr.length-1) {
			return 0;
		} 
		
		int minOverallJump = Integer.MAX_VALUE;
		
		if (arr[cur] == 0) {
			return minOverallJump; 
		}
		
		if(dp[cur] != 0) {
			return dp[cur];
		}
		
		int start = cur + 1;
		int end = cur + arr[cur];
		
		while (start <= end && start <= arr.length-1) {
			
			int minJumpAtThisPos = minHopCountMain(arr, dp, start);
			start++;
			if (minJumpAtThisPos != Integer.MAX_VALUE) {
			minOverallJump = Math.min(minOverallJump, minJumpAtThisPos+1);
			}
		}
		
		dp[cur] = minOverallJump;
		
		return minOverallJump;
	
	}

}

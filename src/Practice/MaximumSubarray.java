package Practice;

public class MaximumSubarray {

	public static void main(String[] args) {
		
		int[] a = new int[] {-1};
		
		System.out.println(maxSubArray(a));
		
	}
	
	public static int maxSubArray(int[] nums) {
		
		int sum = 0;
		
		if (nums.length == 1) {
			return nums[0];
		}
		
        
		for (int i = 0; i < nums.length; i++) {
			
			sum = sum + nums[i];
			
			if (sum < 0) {
				sum = 0;
			}
			
			nums[i] = Math.max(nums[i], sum);
			
		}
		
		int max = 0;
		
		for (int i = 0; i < nums.length; i++) {
			
			if (max < nums[i]) {
				
				max = nums[i];
				
			}
			
		}
		
		return max;
		
    }

}

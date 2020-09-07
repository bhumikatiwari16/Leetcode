package leetcode.Array;

public class arrayMultiply2 {

	public static void main(String[] args) {
		
		int[] i = {1,2,3,4};
		
		int l = 0;
		
		int[] o = productExceptSelf (i);
		
		while(l < o.length) {
			System.out.println(o[l]);
			l++;
		}

	}

	 public static int[] productExceptSelf(int[] nums) {
		 
		 int[] l = new int[nums.length];
		 int[] r = new int[nums.length];
		 
		 int[] o = new int[nums.length];
		 
		 l[0] = 1;
		 r[nums.length - 1] = 1;
		 
		 for(int i = 1; i <= nums.length-1; i++) {
			
			 l[i] = l[i-1] * nums[i-1];
			 
		 }
		 
		 for(int j = nums.length-2; j >= 0; j--) {
			 
			 r[j] = r[j+1] * nums[j+1];
			 
		 }
		 
		 for(int k = 0; k < nums.length; k++) {
			 
			 o[k] = l[k] * r[k];
			 
		 }
		 
		 return o;
	 }
}

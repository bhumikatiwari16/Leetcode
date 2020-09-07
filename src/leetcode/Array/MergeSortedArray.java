package leetcode.Array;

public class MergeSortedArray {

	public static void main(String[] args) {
		
		int[] nums1 = {2,0};
				
		int[] nums2 = {1}; 
		
		int m = 1, n = 1;
		
		merge(nums1,m,nums2,n);
		
		print(nums1);
		
		
	}
	
	 public static void merge(int[] nums1, int m, int[] nums2, int n) {
		 
		 int k = m + n - 1;
		 int i = m - 1;
		 int j = n - 1;
		 
		 while(i >= 0 && j >= 0) {
			 
			 if (nums1[i] > nums2[j]) {
				 nums1[k] = nums1[i];
				 k--;
				 i--;
			 }
			 
			 else  {
				 nums1[k] = nums2[j];
				 k--;
				 j--;
			 }
		 }
		 
		 while (j >= 0){
	            nums1[k] = nums2[j];
	            k--;
	            j--;
	        }
		 
	 }
	 
	 public static void print(int[] nums1) {
		 
		 //System.out.println(nums1.length);
		 
		 for (int i = 0; i < nums1.length; i++) {
			 
			 System.out.println(nums1[i]);
			 
		 }
	 }

}





package hashtable;

public class twoSum {

	public static void main(String[] args) {
		int[] a = new int[] {2,7,11,15};
		
		int[] r = twoSumFind(a, 9);
		for (int l = 0; l < r.length; l++ ) {
			System.out.println(r[l]);
		}

	}	
	
	public static int[] twoSumFind(int[] nums, int target) {

		       int len = nums.length, start = 0;
				while (start < len) {
					//if (nums[start] > target) {
					//	//System.out.println("start>target");
					//	start++;
				//	} else {
						//System.out.println("start<target");
						int j = start + 1;
						while (j < len) {
							if (nums[start] + nums[j] == target) {
								//System.out.println("start+j=target");
								int[] res = {start,j};
								return res;
								
							} else {
								//System.out.println("start+j!=target");
								j++;
							}
						}
				//	}
					start++;
				}
				return null; 
		   
		
	}

}

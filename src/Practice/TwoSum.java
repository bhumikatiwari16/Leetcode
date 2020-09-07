package Practice;

import java.util.HashMap;

public class TwoSum {

	public static void main(String[] args) {
		
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		
		int[] res = twoSum(nums, target);
		
		//System.out.println(res[0]);
		//System.out.println(res[1]);
		
		printArray(res);

	}
	
	public static int[] twoSum(int[] nums, int target) {
     
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer> ();
		int[] res = new int[2];
		
		for (int i = 0; i < nums.length; i++) {
			
			if(hm.containsKey(nums[i])) {
				res[0] = i;
				res[1] = hm.get(nums[i]);
				return res;
			} else {
				hm.put(target - nums[i], i);
			}
		}
			
			return res;		
			
	}

	
	public static void printArray(int[] res) {
     
		int j = 0;
		while (j < res.length) {
			System.out.println(res[j]);
			j++;
		}
		
    }


}

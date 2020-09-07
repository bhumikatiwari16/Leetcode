package amazonManish;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Amazon1 {

	public static void main(String[] args) {
		
		int[] movieDurations = {6};
		int d = 6;
		
		int[] res = maxMovieDuration(movieDurations, d);
		
		for(int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
		

	}
	
	
	static int[] maxMovieDuration(int[] nums, int d) {
		
	    int[] ans = new int[2];
	    
	    int target = d - 30;
	    if (target <= 0) return ans;

	    // use a dynamic array list
	    List<Pair> sorted = new ArrayList<>();
	    for (int i = 0; i < nums.length; i++) {
	        sorted.add(new Pair(i, nums[i]));
	    }
	    
	    Collections.sort(sorted, (i, j) -> (i.val - j.val));

	    int closestSum = 0;

	    // two pointers
	    int left = 0, right = nums.length - 1;
	    
	    while (left < right) {
	    	
	        Pair leftPair = sorted.get(left);
	        Pair rightPair = sorted.get(right);
	        
	        int sum = leftPair.val + rightPair.val;
	        if (sum > target) {
	            right--;
	        } else {
	            // found duplicates
	            if (sum == closestSum) {
	                int currentLongestMovie = nums[ans[1]];
	                if (rightPair.val > currentLongestMovie) {
	                    // found longer movie
	                    ans[0] = leftPair.index;
	                    ans[1] = rightPair.index;
	                }
	            } else if (sum > closestSum) {
	                closestSum = sum;
	                ans[0] = leftPair.index;
	                ans[1] = rightPair.index;
	            }
	            left++;
	        }
	    }
	    return ans;
	}
	
	public static class Pair {
	    int index;
	    int val;
	    Pair(int index ,int val) {
	        this.index = index;
	        this.val = val;
	    }
	}

	
}





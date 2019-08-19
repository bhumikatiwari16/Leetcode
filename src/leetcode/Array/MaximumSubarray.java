package leetcode.Array;

import java.sql.Array;

public class MaximumSubarray {

    public static void main(String[] args) {
        int[] arr = {-2,1};
       System.out.println(maxSubArray(arr));

    }

    public static int maxSubArray(int[] nums) {

        int max = Integer.MIN_VALUE;
        int sum = 0;

        if (nums == null) {
            return -1;
        } else if (nums.length == 1) {
            return nums[0];
        }

        for(int i = 0; i < nums.length; i++) {
            sum = nums[i];
            if (Math.max(max,sum) == sum) {
                max = sum;
            }
         //   System.out.println(sum);
            for (int j = i+1; j < nums.length; j++) {
                sum += nums[j];
                System.out.println(sum);
                if (Math.max(max,sum) == sum) {
                    max = sum;
                }
            }
        }

        return max;

    }


}

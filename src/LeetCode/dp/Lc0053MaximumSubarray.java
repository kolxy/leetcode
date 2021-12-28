package LeetCode.dp;

import LeetCode.LcTemplate;

public class Lc0053MaximumSubarray implements LcTemplate {
    @Override
    public void run() {

    }

    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] memo = new int[nums.length];
        memo[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            memo[i] = Math.max(memo[i-1] + nums[i], nums[i]);
        }
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, memo[i]);
        }
        return max;
    }
}

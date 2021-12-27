package LeetCode.dp;

import LeetCode.LcTemplate;

public class Lc0300LongestIncreasingSubsequence implements LcTemplate {
    @Override
    public void run() {

    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int globalMax = 1;
        for (int i = 1; i < nums.length; i++) {
            int localMax = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] > localMax) {
                        localMax = dp[j];
                    }
                }
            }
            dp[i] = localMax + 1;
            if (dp[i] > globalMax) {
                globalMax = dp[i];
            }
        }
        return globalMax;
    }
}

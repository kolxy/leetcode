package LeetCode.dp;

import LeetCode.LcTemplate;

import java.util.Arrays;

public class Lc0322CoinChange implements LcTemplate {
    @Override
    public void run() {

    }

    public int coinChange(int[] coins, int amount) {
        int MAX = amount + 1;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, MAX);
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == MAX ? -1 : dp[amount];
    }
}

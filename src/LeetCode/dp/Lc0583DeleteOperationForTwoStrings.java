package LeetCode.dp;

import LeetCode.LcTemplate;

import java.util.Arrays;

public class Lc0583DeleteOperationForTwoStrings implements LcTemplate {
    @Override
    public void run() {

    }

    int[][] memo;
    String w1;
    String w2;
    public int minDistance(String word1, String word2) {
        memo = new int[word1.length() + 1][word2.length() + 1];
        w1 = word1;
        w2 = word2;
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }
        memo[0][0] = 0;
        return dp(word1.length(), word2.length());
    }

    public int dp(int i, int j) {
        if (memo[i][j] != Integer.MAX_VALUE) {
            return memo[i][j];
        }
        if (i == 0) {
            memo[i][j] = j;
            return j;
        }
        if (j == 0) {
            memo[i][j] = i;
            return i;
        }
        int min = min(dp(i-1, j), dp(i, j-1)) + 1;
        if (w1.charAt(i-1) == w2.charAt(j-1)) {
            min = memo[i-1][j-1];
        }
        memo[i][j] = min;
        return min;
    }

    public int min(int a, int b) {
        return Math.min(a, b);
    }
}

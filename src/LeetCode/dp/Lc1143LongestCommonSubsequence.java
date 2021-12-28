package LeetCode.dp;

import LeetCode.LcTemplate;

public class Lc1143LongestCommonSubsequence implements LcTemplate {
    @Override
    public void run() {

    }

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] memo = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i < text1.length() + 1; i++) {
            char c1 = text1.charAt(i-1);
            for (int j = 1; j < text2.length() + 1; j++) {
                char c2 = text2.charAt(j-1);
                if (c1 == c2) {
                    memo[i][j] = memo[i-1][j-1] + 1;
                } else {
                    memo[i][j] = Math.max(memo[i-1][j], memo[i][j-1]);
                }
            }
        }
        return memo[text1.length()][text2.length()];
    }
}

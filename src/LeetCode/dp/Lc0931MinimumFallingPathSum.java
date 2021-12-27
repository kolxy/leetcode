package LeetCode.dp;

import LeetCode.LcTemplate;

import java.util.Arrays;

public class Lc0931MinimumFallingPathSum implements LcTemplate {
    @Override
    public void run() {

    }

    private int[][] memo;
    public int minFallingPathSum(int[][] matrix) {
        memo = new int[matrix.length][matrix.length];
        memo[0] = matrix[0];
        for (int i = 1; i < matrix.length; i++) {
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            memo[matrix.length-1][i] = dp(matrix, matrix.length-1, i);
        }
        for (int i = 0; i < matrix.length; i++) {
            if (memo[matrix.length-1][i] < min) {
                min = memo[matrix.length-1][i];
            }
        }
        return min;
    }
    public int dp(int[][] matrix, int i, int j) {
        int left = Math.max(0, j-1);
        int right = Math.min(matrix.length - 1, j+1);
        if (memo[i][j] != Integer.MAX_VALUE) {
            return memo[i][j];
        }
        memo[i][j] = matrix[i][j] + Math.min(Math.min(dp(matrix, i-1, left), dp(matrix, i-1, j)), dp(matrix, i-1, right));
        return memo[i][j];
    }
}

package LeetCode.dp;

import LeetCode.LcTemplate;

import java.util.Arrays;
import java.util.Comparator;

public class Lc0354RussianDollEnvelopes implements LcTemplate {
    @Override
    public void run() {

    }

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0] != b[0] ? a[0] - b[0] : b[1] - a[1];
            }
        });
        int[] memo = new int[envelopes.length];
        memo[0] = 1;

        int globalMax = 1;
        for (int i = 1; i < memo.length; i++) {
            int localMax = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[j][1] < envelopes[i][1]) {
                    localMax = Math.max(memo[j]+1, localMax);
                }
            }
            memo[i] = localMax;
            globalMax = Math.max(globalMax, localMax);
        }
        return globalMax;
    }
}

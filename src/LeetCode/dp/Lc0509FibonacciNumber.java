package LeetCode.dp;

import LeetCode.LcTemplate;

public class Lc0509FibonacciNumber implements LcTemplate {

    @Override
    public void run() {

    }

    int[] table;
    public int fib(int n) {
        table = new int[Math.max(2, n+1)];
        table[0] = 0;
        table[1] = 1;
        for (int i = 2; i <= n; i++) {
            table[i] = table[i-1] + table[i-2];
        }
        return table[n];
    }
}

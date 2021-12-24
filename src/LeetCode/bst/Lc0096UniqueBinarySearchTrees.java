package LeetCode.bst;

import LeetCode.LcTemplate;

import java.util.ArrayList;
import java.util.List;

public class Lc0096UniqueBinarySearchTrees implements LcTemplate {
    @Override
    public void run() {

    }

    private int[] table;
    public int numTrees(int n) {
        table = new int[n+1];
        return count(n);
    }

    public int count(int n) {
        if (n <= 1) {
            return 1;
        }
        if (table[n] != 0) {
            return table[n];
        }
        int c = 0;
        for (int i = 1; i <= n; i++) {
            c += count(i-1) * count(n-i);
        }
        table[n] = c;
        return c;
    }
}

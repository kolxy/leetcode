package LeetCode.graph;

import LeetCode.LcTemplate;

import java.util.ArrayList;
import java.util.List;

public class Lc0797AllPathsFromSourceToTarget implements LcTemplate {
    @Override
    public void run() {

    }

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> list = new ArrayList<>();
        traverse(graph, 0, list);
        return ans;
    }

    private void traverse(int[][] graph, int v, List<Integer> path) {
        path.add(v);
        if (v == graph.length - 1) {
            ans.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }

        for (int n : graph[v]) {
            traverse(graph, n, new ArrayList<>(path));
        }
        path.remove(path.size() - 1);
    }
}

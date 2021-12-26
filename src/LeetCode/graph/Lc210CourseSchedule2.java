package LeetCode.graph;

import LeetCode.LcTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lc210CourseSchedule2 implements LcTemplate {
    @Override
    public void run() {

    }

    private List<Integer> order = new ArrayList<>();

    private int[] visited;
    private int[] onPath;
    private boolean hasLoop;

    private List<List<Integer>> graph;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];
        onPath = new int[numCourses];
        graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] p : prerequisites) {
            graph.get(p[1]).add(p[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            traverse(i);
        }

        Collections.reverse(order);
        if (hasLoop) {
            return new int[0];
        }
        int[] res = new int[numCourses];
        for (int i = 0; i < order.size(); i++) {
            res[i] = order.get(i);
        }
        return res;
    }

    public void traverse(int s) {
        if (onPath[s] == 1) {
            hasLoop = true;
            return;
        }
        if (visited[s] == 1) {
            return;
        }
        visited[s] = 1;
        onPath[s] = 1;
        for (int d : graph.get(s)) {
            traverse(d);
        }
        order.add(s);
        onPath[s] = 0;
    }
}

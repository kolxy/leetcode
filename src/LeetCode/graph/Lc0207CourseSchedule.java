package LeetCode.graph;

import LeetCode.LcTemplate;

import java.util.ArrayList;
import java.util.List;

public class Lc0207CourseSchedule implements LcTemplate {
    @Override
    public void run() {

    }

    private int[] visited;
    private int[] path;
    private List<List<Integer>> graph;
    private boolean hasLoop = false;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        graph = new ArrayList<>();
        visited = new int[numCourses];
        path = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.add(i,new ArrayList<>());
        }
        for (int[] p : prerequisites) {
            graph.get(p[1]).add(p[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            traverse(i);
        }
        return !hasLoop;
    }

    private void traverse(int s) {
        if (path[s] == 1) {
            hasLoop = true;
            return;
        }
        if (visited[s] == 1) {
            return;
        }

        path[s] = 1;
        visited[s] = 1;
        for (int d : graph.get(s)) {
            traverse(d);
        }
        path[s] = 0;
    }
}

package practice.week4;

import java.util.ArrayList;
import java.util.List;

public class Day3_AllPathsFromSource {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, 0, res, path);

        return res;
    }

    private void dfs(int[][] graph, int node, List<List<Integer>> res, List<Integer> path) {
        if (node == graph.length -1) {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int adj : graph[node]) {
            path.add(adj);
            dfs(graph, adj, res, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Day3_AllPathsFromSource().allPathsSourceTarget(new int[][]{{1,2}, {3}, {3}, {}}));
    }
}

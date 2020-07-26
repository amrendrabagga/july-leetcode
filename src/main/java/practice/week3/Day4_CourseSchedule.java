package practice.week3;


import java.util.*;
import java.util.stream.IntStream;

public class Day4_CourseSchedule {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        if (numCourses == 0) return new int[]{};
        if (prerequisites.length == 0) return IntStream.range(0, numCourses).boxed().mapToInt(Integer::intValue).toArray();

        // initialize edge and entering adj list
        List<Integer> edges[] = new ArrayList[numCourses];
        for (int i=0; i<numCourses; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i=0; i < prerequisites.length; i++) {
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        int inDegree[] = new int[numCourses];
        for (int i=0; i<numCourses; i++) {
            List<Integer> tmp = (List<Integer>)edges[i];
            for (int adj : tmp) {
                inDegree[adj]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();

        for (int i=0; i<numCourses; i++) {
            if (inDegree[i] == 0)
                queue.add(i);
        }
        List<Integer> res = new ArrayList<>(numCourses);
        int count = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            res.add(node);
            for (int adj : edges[node]) {
                if (--inDegree[adj] == 0) queue.offer(adj);
            }
            count++;
        }
        if (count != numCourses) return new int[]{}; // means loop exist
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Day4_CourseSchedule().findOrder(2, new int[][]{{0,1}, {0,2}, {1,2}})));
    }
}

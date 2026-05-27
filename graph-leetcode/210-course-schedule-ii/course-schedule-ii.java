import java.util.*;

class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        // build graph
        for (int[] pre : prerequisites) {

            int course = pre[0];
            int prereq = pre[1];

            graph.get(prereq).add(course);

            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        // push indegree 0 nodes
        for (int i = 0; i < numCourses; i++) {

            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] ans = new int[numCourses];

        int index = 0;

        while (!queue.isEmpty()) {

            int node = queue.poll();

            ans[index++] = node;

            for (int neigh : graph.get(node)) {

                indegree[neigh]--;

                if (indegree[neigh] == 0) {
                    queue.offer(neigh);
                }
            }
        }

        // cycle exists
        if (index != numCourses) {
            return new int[0];
        }

        return ans;
    }
}
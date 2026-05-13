class Solution {

    public boolean validPath(int n, int[][] edges,
                             int source, int destination) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] vis = new boolean[n];

        return dfs(source, destination, graph, vis);
    }

    public boolean dfs(int source, int destination,
                       List<List<Integer>> graph,
                       boolean[] vis) {

        if (source == destination) {
            return true;
        }

        vis[source] = true;

        for (int nei : graph.get(source)) {

            if (!vis[nei]) {

                if (dfs(nei, destination, graph, vis)) {
                    return true;
                }
            }
        }

        return false;
    }
}
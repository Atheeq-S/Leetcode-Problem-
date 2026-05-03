import java.util.*;

class Main {

    public static boolean dfs(int node, boolean[] visited, boolean[] recStack, List<List<Integer>> graph) {
        visited[node] = true;
        recStack[node] = true;

        for (int nei : graph.get(node)) {
            if (!visited[nei]) {
                if (dfs(nei, visited, recStack, graph))
                    return true;
            } 
            else if (recStack[nei]) {
                return true;
            }
        }

        recStack[node] = false; // backtrack
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // directed edges
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
        }

        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        boolean hasCycle = false;

        // check all components
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, visited, recStack, graph)) {
                    hasCycle = true;
                    break;
                }
            }
        }

        if (hasCycle)
            System.out.println("Cycle Detected");
        else
            System.out.println("No Cycle");
    }
}

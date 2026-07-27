class Solution {
    static class Dsu {
        int parent[];
        int size[];

        public Dsu(int n) {
            parent = new int[n];
            size = new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
                size[i]=1;
            }

            
        }

        int find(int x) {
            if (parent[x] == x)
                return x;

            return parent[x] = find(parent[x]);
        }

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px == py)
                return;

            if (size[px] < size[py]) {
                parent[px] = py;
                size[py] += size[px];
            } else {
                parent[py] = px;
                size[px] += size[py];
            }
        }

    }

    public int largestIsland(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Dsu dsu = new Dsu(m * n);

        int dr[] = { -1, 1, 0, 0 };
        int dc[] = { 0, 0, -1, 1 };

        // step 1: group a connected components group all one as one group and store their size;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0)
                    continue;

                int node = (i * n) + j;

                for (int k = 0; k < 4; k++) {
                    int nr = i + dr[k];
                    int nc = j + dc[k];
                    int newNode = nr * n + nc;
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n || grid[nr][nc] == 0)
                        continue;

                    else
                        dsu.union(node, newNode);
                }
            }
        }
        // step 2 : parent node store therir size of connected component so take max size so far 
        int ans = 0;
        for (int i = 0; i < m * n; i++) {
            if (dsu.find(i) == i) {
                ans = Math.max(ans, dsu.size[i]);
            }
        }

        // step 3 :convert the zero and find whether the size increse;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1)
                    continue;

                int node = (i * n) + j;
                // to store parent
                Set<Integer> set = new HashSet<>();
                for (int k = 0; k < 4; k++) {
                    int nr = i + dr[k];
                    int nc = j + dc[k];

                    if (nr < 0 || nr >= m || nc < 0 || nc >= n || grid[nr][nc] == 0)
                        continue;

                    

                    int par = dsu.find(nr * n + nc);
                    set.add(par);
                }
                int area = 1;
                for (int s : set) {
                    area += dsu.size[s];
                }

                ans = Math.max(ans, area);

            }
        }

        return ans;

    }
}
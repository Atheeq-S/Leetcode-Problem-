class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        boolean visited[][] = new boolean[n][n];

        int dr[] = { -1, 1, 0, 0 };
        int dc[] = { 0, 0, -1, 1 };

        pq.add(new int[] { grid[0][0], 0, 0 });

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0];
            int row = curr[1];
            int col = curr[2];

            if (visited[row][col])
                continue;

            visited[row][col] = true;

            if (row == n - 1 && col == n - 1)
                return time;

            for (int i = 0; i < 4; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];
                if (nc < 0 || nr < 0 || nc >= n || nr >= n || visited[nr][nc])
                    continue;

                pq.add(new int[] { Math.max(time, grid[nr][nc]), nr, nc });
            }

        }

        return -1;

    }
}
class Solution {

    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int numEnclaves(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        boolean[][] visited = new boolean[row][col];

        // First and last column
        for (int i = 0; i < row; i++) {

            if (grid[i][0] == 1 && !visited[i][0]) {
                dfs(grid, visited, i, 0, row, col);
            }

            if (grid[i][col - 1] == 1 && !visited[i][col - 1]) {
                dfs(grid, visited, i, col - 1, row, col);
            }
        }

        // First and last row
        for (int j = 0; j < col; j++) {

            if (grid[0][j] == 1 && !visited[0][j]) {
                dfs(grid, visited, 0, j, row, col);
            }

            if (grid[row - 1][j] == 1 && !visited[row - 1][j]) {
                dfs(grid, visited, row - 1, j, row, col);
            }
        }

        int count = 0;

        // Count unvisited land cells
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (grid[i][j] == 1 && !visited[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }

    void dfs(int[][] grid, boolean[][] visited,
             int r, int c, int row, int col) {

        visited[r][c] = true;

        for (int k = 0; k < 4; k++) {

            int nr = r + dr[k];
            int nc = c + dc[k];

            if (nr >= 0 && nr < row &&
                nc >= 0 && nc < col &&
                grid[nr][nc] == 1 &&
                !visited[nr][nc]) {

                dfs(grid, visited, nr, nc, row, col);
            }
        }
    }
}
class Solution {

    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int numIslands(char[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        boolean[][] visited = new boolean[row][col];

        int count = 0;

        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {

                if (grid[i][j] == '1' && !visited[i][j]) {

                    count++;

                    dfs(grid, visited, i, j, row, col);
                }
            }
        }

        return count;
    }

    void dfs(char[][] grid, boolean[][] visited,
             int r, int c, int row, int col) {

        visited[r][c] = true;

        for (int k = 0; k < 4; k++) {

            int nr = r + dr[k];
            int nc = c + dc[k];

            if (nr >= 0 && nr < row &&
                nc >= 0 && nc < col &&
                grid[nr][nc] == '1' &&
                !visited[nr][nc]) {

                dfs(grid, visited, nr, nc, row, col);
            }
        }
    }
}
class Solution {

    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public void solve(char[][] board) {

        int row = board.length;
        int col = board[0].length;

        boolean[][] visited = new boolean[row][col];

        // First and last column
        for (int i = 0; i < row; i++) {

            if (board[i][0] == 'O' && !visited[i][0]) {
                dfs(board, visited, i, 0, row, col);
            }

            if (board[i][col - 1] == 'O' && !visited[i][col - 1]) {
                dfs(board, visited, i, col - 1, row, col);
            }
        }

        // First and last row
        for (int j = 0; j < col; j++) {

            if (board[0][j] == 'O' && !visited[0][j]) {
                dfs(board, visited, 0, j, row, col);
            }

            if (board[row - 1][j] == 'O' && !visited[row - 1][j]) {
                dfs(board, visited, row - 1, j, row, col);
            }
        }

        // Flip surrounded regions
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    void dfs(char[][] board, boolean[][] visited,
             int r, int c, int row, int col) {

        visited[r][c] = true;

        for (int k = 0; k < 4; k++) {

            int nr = r + dr[k];
            int nc = c + dc[k];

            if (nr >= 0 && nr < row &&
                nc >= 0 && nc < col &&
                board[nr][nc] == 'O' &&
                !visited[nr][nc]) {

                dfs(board, visited, nr, nc, row, col);
            }
        }
    }
}
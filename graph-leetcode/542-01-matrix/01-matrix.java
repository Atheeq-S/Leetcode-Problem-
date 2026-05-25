import java.util.*;

class Solution {

    static class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int[][] updateMatrix(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        int[][] dist = new int[m][n];

        boolean[][] visited = new boolean[m][n];

        Queue<Pair> queue = new LinkedList<>();

        // Add all 0 cells into queue
        for(int i = 0; i < m; i++) {

            for(int j = 0; j < n; j++) {

                if(mat[i][j] == 0) {

                    queue.offer(new Pair(i, j));

                    visited[i][j] = true;
                }
            }
        }

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        while(!queue.isEmpty()) {

            Pair curr = queue.poll();

            int row = curr.row;
            int col = curr.col;

            for(int i = 0; i < 4; i++) {

                int nrow = row + delRow[i];
                int ncol = col + delCol[i];

                if(nrow >= 0 && nrow < m &&
                   ncol >= 0 && ncol < n &&
                   !visited[nrow][ncol]) {

                    dist[nrow][ncol] = dist[row][col] + 1;

                    visited[nrow][ncol] = true;

                    queue.offer(new Pair(nrow, ncol));
                }
            }
        }

        return dist;
    }
}
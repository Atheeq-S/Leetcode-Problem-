class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        int effort[][]=new int[n][m];

        for(int i=0;i<n;i++){
            Arrays.fill(effort[i],(int)1e9);
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b) -> a[0]-b[0]);
        int[] dr={-1,1,0,0};
        int[] dc={0,0,-1,1};

        pq.offer(new int[]{0,0,0});
        effort[0][0]=0;

        while(!pq.isEmpty()){
            int[] curr= pq.poll();
            int dis=curr[0];
            int row=curr[1];
            int col=curr[2];

            if(row == n-1 && col == m-1){
                return dis;
            }
            for(int i=0;i<4;i++){
                int nr=row+dr[i];
                int nc=col+dc[i];
                
                if(nr>=0 && nr<n && nc >=0 && nc < m){
                    int newEffort =
                        Math.max(
                            dis,
                            Math.abs(
                                heights[row][col]
                                - heights[nr][nc]
                            )
                        );

                    if(newEffort<effort[nr][nc]){
                        effort[nr][nc]=newEffort;
                        pq.offer(new int[]{newEffort,nr,nc});
                    }
                }

                
            }
        }
        return 0;

    }
}
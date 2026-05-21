class Solution {
    static class Pair{
        int row;
        int col;
        int time;
        public Pair(int row,int col,int time){
            this.row=row;
            this.col=col;
            this.time=time;
        }
    }
    public int orangesRotting(int[][] grid) {
        
        int row=grid.length;
        int col=grid[0].length;

        Queue<Pair> queue=new LinkedList<>();
        int fresh=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==2)
                {
                    queue.offer(new Pair(i,j,0));
                }
                if(grid[i][j]==1)
                fresh ++;

            }
        }
        int[] dr={-1,1,0,0};
        int[] dc ={0,0,-1,1};

        int min=0;

        while(!queue.isEmpty())
        {
            Pair curr=queue.poll();
            int r=curr.row;
            int c=curr.col;
            int time=curr.time;

            min=Math.max(min,time);

            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr>=0 && nr<row && nc>=0 && nc<col && grid[nr][nc]==1 )
                {
                    grid[nr][nc]=2;
                    fresh--;
                    queue.offer(new Pair(nr,nc,time+1));

                }
            }
        }

        return fresh >0 ? -1 : min;
    }
}
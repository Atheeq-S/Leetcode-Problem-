class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int dist[][]=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }

        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            int w=e[2];

            dist[u][v]=w;
            dist[v][u]=w;
        }

        //Self loop distance is set to zero

        for(int i=0;i<n;i++){
            dist[i][i]=0;
        }

        for(int val=0;val<n;val++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][val]== Integer.MAX_VALUE || dist[val][j]== Integer.MAX_VALUE)
                    continue;
                    dist[i][j]=Math.min(dist[i][j],dist[i][val]+dist[val][j]);
                }
            }
        }

        int minCity =-1;
        int minCount=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<n;j++)
            {
                if(dist[i][j]<=distanceThreshold)
                count++;
            }
            if(count<=minCount)
            {
                minCount=count;
                minCity=i;

            }

        }

        return minCity;

    }
}

class Solution {
    class Dsu{
        int [] parent;
        int [] rank;
        public Dsu(int n){
            parent=new int[n];
            rank=new int[n];
            
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
            Arrays.fill(rank,0);
        }

        public int find(int x){
            if(parent[x]==x)
            return x;
            return parent[x]=find(parent[x]);
        }

        public void union(int x,int y){
            int px=find(x);
            int py=find(y);

            if(px==py){
                return;
            }

            if (rank[px] < rank[py]) {
                parent[px] = py;
            } else if (rank[px] > rank[py]) {
                parent[py] = px;
            } else {
                parent[py] = px;
                rank[px]++;
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        Dsu dsu=new Dsu(n);
        if(connections.length< n-1)
        return -1;

        int extra = 0;

    for (int[] edge : connections) {
        int u = edge[0];
        int v = edge[1];

        if (dsu.find(u) == dsu.find(v))
            extra++;
        else
            dsu.union(u, v);
    }
        int com=0;
        for(int i=0;i<n;i++){
            if(dsu.find(i)==i)
            com++;

        }

        return extra>=com-1 ? com-1 : -1 ;
        
    }
}
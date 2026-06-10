class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        List<List<int[]>> adj=new ArrayList<>();

        for(int i=0;i<=n;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int[] t: times ){
            int u=t[0];
            int v=t[1];
            int w=t[2];

            adj.get(u).add(new int[]{v,w});
        }

        int dist[]=new int[n+1];
        Arrays.fill(dist,(int)1e9);
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);

        pq.add(new int[]{k,0});
        dist[k]=0;

        //int steps=0;

        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int node= curr[0];
            int time=curr[1];

            for(int[] nei:adj.get(node)){
                int nNode=nei[0];
                int wei=nei[1];
                if(wei+time<dist[nNode])
                {
                    dist[nNode]=wei+time;
                     pq.add(new int[]{nNode, dist[nNode]});
                }
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            if(dist[i]==(int) 1e9)
            return -1;
            else 
            max=Math.max(max,dist[i]);
        }

        return max;

    }
}
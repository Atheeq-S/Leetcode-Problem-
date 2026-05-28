class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adjRev=new ArrayList<>();
        int V=graph.length;
        for(int i=0;i<V;i++){
            adjRev.add(new ArrayList<>());
        }
        int indegree[]=new int[V];

        for(int i=0;i<V;i++){
            for(int it:graph[i]){
                adjRev.get(it).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> queue=new LinkedList<>();
        List<Integer> safenode=new ArrayList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int curr=queue.poll();
            
            safenode.add(curr);
            
            for(int nei: adjRev.get(curr)){
                indegree[nei]--;
                if(indegree[nei]==0)
                {
                    queue.add(nei);
                }
            }
        }
        Collections.sort(safenode);

        return safenode;

        
    }
}
class Solution {

    static class Dsu{
        int[] parent;

        public Dsu(int n){
            parent=new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
        }
        public int find(int i)
        {
            if(parent[i]==i)
            return i;

            return parent[i]=find(parent[i]);
        }

        public void union(int x,int y){
            int px=find(x);
            int py=find(y);
            if(px==py)
            return;

            parent[px]=py;

        }
    }

    Map<String,Integer> emailToAccount=new HashMap<>();

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        int n=accounts.size();

        Dsu dsu=new Dsu(n);

        // first we union the same email id 
        /*
            [["John","johnsmith@mail.com","john_newyork@mail.com"],
            ["John","johnsmith@mail.com","john00@mail.com"],
            ["Mary","mary@mail.com"],
            ["John","johnnybravo@mail.com"]]

            1 and 2 row got union because both have same email id
        */

        for(int i=0;i<n;i++){
            List<String> acc=accounts.get(i);
            for(int j=1;j<acc.size();j++){
                if(!emailToAccount.containsKey(acc.get(j)))
                emailToAccount.put(acc.get(j),i);
                else{
                    dsu.union(i,emailToAccount.get(acc.get(j)));
                }
            }
        }

        //parent -> email 
        /*
            Assign the parent to email which is available at emailToAccount 

            ---> index value store the parent , so find index of email in emailToAccountn and find their parent


        */
        // Map<Parent, emails>
        Map<Integer,TreeSet<String>> merged=new HashMap<>();

        for(String email : emailToAccount.keySet() ){
            int index= emailToAccount.get(email);
            int parent=dsu.find(index);
            merged.computeIfAbsent(parent,k -> new TreeSet<>()).add(email);
        }
        
        /*
            Above we connect the parent with eamil and next we need to add name with the result set 
        */
    

        List<List<String>> result=new ArrayList<>();
        for(int parent : merged.keySet()){
            List<String> res=new ArrayList<>();
            res.add(accounts.get(parent).get(0));
            res.addAll(merged.get(parent));

            result.add(res);
        }

        return result;

    }
    

}
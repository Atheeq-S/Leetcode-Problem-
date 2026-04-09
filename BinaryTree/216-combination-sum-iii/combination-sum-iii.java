class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> result=new ArrayList<>();
        backtrack(1,k,n,new ArrayList<>(),result);
        return result;
        
    }

    public void backtrack(int index,int k,int target,List<Integer> curr,List<List<Integer>> result){

        if( target==0 && curr.size()==k )
        {
            result.add(new ArrayList<>(curr));
            return;
        }
         // ❌ Stop conditions
        if (target < 0 || curr.size() > k) return;
        for(int i=index;i<=9;i++)
        {
            curr.add(i);
            backtrack(i +1 ,k,target-i,curr,result);
            curr.remove(curr.size() -1 );

        }
    }
}
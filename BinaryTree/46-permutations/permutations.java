class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        boolean[] used =new boolean[nums.length];
        backtrack(0,nums,new ArrayList<>(),result,used);
        return result;
    }

    public void backtrack(int index,int [] nums,List<Integer> curr,List<List<Integer>> result,boolean[] used)
    {
        //base condition
        if(curr.size() == nums.length)
        {
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i=index ; i < nums.length;i++ )
        {
            if(used[i]) continue;

            curr.add(nums[i]);
            used[i]=true;

            backtrack(index,nums,curr,result,used);

            curr.remove(curr.size()-1);
            used[i]=false;
            
        }
    }

}
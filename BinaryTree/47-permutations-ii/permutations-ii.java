class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used=new boolean[nums.length];
        backtrack(0,nums,new ArrayList<>(),result,used);
        return result;
    }

    public void backtrack(int index,int [] nums,List<Integer> curr,List<List<Integer>> result,boolean [] used){

        if(curr.size()==nums.length){
            result.add(new ArrayList<>(curr));
            return ;
        }

        for(int i=index; i< nums.length;i++){
            if(used[i])
            continue;

            if(i> index && nums[i]==nums[i-1] && !used[i-1]) continue;

            used[i]=true;
            curr.add(nums[i]);

            backtrack(index,nums,curr,result,used);
            curr.remove(curr.size()-1);
            used[i]=false; 
        }
    }

}
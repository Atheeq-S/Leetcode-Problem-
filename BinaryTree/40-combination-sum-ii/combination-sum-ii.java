class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(0,candidates,new ArrayList<>(),result,target);
        return result;
    }

    public void backTrack(int index,int[] arr, List<Integer> curr,List<List<Integer>> result,int target){
        // base 
        if(target==0)
        {
            result.add(new ArrayList<>(curr));
            return;
        }
        if(index >= arr.length)
        return;
        
         if (arr[index] <= target) {
            curr.add(arr[index]);
            backTrack(index + 1, arr,  curr, result,target - arr[index]);
            curr.remove(curr.size() - 1);
        }

        int nextIndex=index+1;
        while(nextIndex<arr.length && arr[nextIndex]==arr[index])
        nextIndex++;

        backTrack(nextIndex, arr, curr, result,target);


    }
}
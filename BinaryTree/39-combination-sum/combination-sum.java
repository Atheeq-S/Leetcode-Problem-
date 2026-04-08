class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, candidates, new ArrayList<>(), result, target);
        return result;
    }

    public void backtrack(int index, int[] arr, List<Integer> curr,
                          List<List<Integer>> result, int target) {

        // Base case
        if (target == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }

        if (index >= arr.length) return;

        // Pick (stay at same index ✅)
        if (arr[index] <= target) {
            curr.add(arr[index]);
            backtrack(index, arr, curr, result, target - arr[index]);
            curr.remove(curr.size() - 1); // backtrack
        }

        // Not pick
        backtrack(index + 1, arr, curr, result, target);
    }
}
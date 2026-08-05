class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        Deque<Integer> deque=new ArrayDeque<>();
        int ind=0;
        int ans[]=new int[nums.length - k + 1];

        for(int i=0;i<nums.length;i++){
            // check whether the element belong to ciurrent window or else remove from right
            while(!deque.isEmpty() && deque.peekFirst()<=i-k){
                deque.pollFirst();
            }
            while(!deque.isEmpty() && nums[deque.peekLast()]<nums[i])
            {
                deque.pollLast();
            }

            deque.addLast(i);

            if(i>=k-1)
            ans[ind++]=nums[deque.peekFirst()];



        }
        return ans;
    }
}
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        int n = temperatures.length;
        Stack<Integer> st = new Stack<>();// index store 
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() &&i > 0 && temperatures[i] > temperatures[st.peek()]) {
                int pre = st.pop();
                ans[pre] = i - pre;
            }
            st.push(i);

        }
        return ans;

    }

}
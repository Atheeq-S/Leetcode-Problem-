import java.util.*;

class Solution {

    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int ans = 0;

        for (int right = 0; right < nums.length; right++) {

            // Add current element
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            // New distinct element
            if (map.get(nums[right]) == 1) {
                k--;
            }

            // Shrink window until it has at most k distinct elements
            while (k < 0) {
                map.put(nums[left], map.get(nums[left]) - 1);

                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                    k++;
                }

                left++;
            }

            // Count all valid subarrays ending at 'right'
            ans += right - left + 1;
        }

        return ans;
    }
}
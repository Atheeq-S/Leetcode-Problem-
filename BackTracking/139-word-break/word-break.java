import java.util.*;

class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {

        Boolean[] dp = new Boolean[s.length()];

        return solve(s, wordDict, 0, dp);
    }

    public boolean solve(String s,
                         List<String> wordDict,
                         int index,
                         Boolean[] dp) {

        // Reached end
        if (index == s.length()) {
            return true;
        }

        // Already calculated
        if (dp[index] != null) {
            return dp[index];
        }

        for (int i = index; i < s.length(); i++) {

            String word = s.substring(index, i + 1);

            if (wordDict.contains(word)) {

                if (solve(s, wordDict, i + 1, dp)) {

                    dp[index] = true;

                    return true;
                }
            }
        }

        dp[index] = false;

        return false;
    }
}
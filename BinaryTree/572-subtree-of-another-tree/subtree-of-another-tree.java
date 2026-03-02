/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */



 /*

 TIME AND SPACE COMPLEXITY

 Serialization takes O(N)

Substring check takes O(N + M) (average)

Overall ≈ O(N + M) average case

Better than O(N × M)

*/


class Solution {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        String rootStr = serialize(root);
        String subStr = serialize(subRoot);

        return rootStr.contains(subStr);
    }

    private String serialize(TreeNode node) {
        if (node == null) {
            return "null,";
        }

        return "," + node.val + "," +
               serialize(node.left) +
               serialize(node.right);
    }
}
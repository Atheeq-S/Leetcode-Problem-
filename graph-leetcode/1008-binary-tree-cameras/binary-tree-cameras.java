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
class Solution {

    int cameras = 0;

    public int minCameraCover(TreeNode root) {

        if (dfs(root) == 0) {
            cameras++;
        }

        return cameras;
    }

    public int dfs(TreeNode node) {

        if (node == null) {
            return 2;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        // If child needs camera
        if (left == 0 || right == 0) {

            cameras++;
            return 1;
        }

        // If child has camera
        if (left == 1 || right == 1) {
            return 2;
        }

        // Current node needs camera
        return 0;
    }
}
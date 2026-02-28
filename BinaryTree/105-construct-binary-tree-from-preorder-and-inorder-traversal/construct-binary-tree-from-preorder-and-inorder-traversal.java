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
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = buildUniqueTree(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length -1 ,
                map);

        return root;
    }

    public TreeNode buildUniqueTree(int[] preorder, int preStart, int preEnd,
            int[] inorder, int inStart, int inEnd,
            Map<Integer, Integer> map) {

        if (preStart > preEnd || inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int inRow = map.get(root.val);
        int left = inRow - inStart;

        root.left = buildUniqueTree(preorder, preStart + 1, preStart + left,
                inorder, inStart, inRow - 1, map);
        root.right = buildUniqueTree(preorder, preStart + left + 1, preEnd,
                inorder, inRow + 1, inEnd, map);

        return root;
    }
}
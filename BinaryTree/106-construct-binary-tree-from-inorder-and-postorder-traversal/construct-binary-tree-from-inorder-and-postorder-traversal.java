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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);

        }
        TreeNode root=buildUniqueTree(postorder,0,postorder.length-1,
                                    inorder,0,inorder.length-1,map);
        return root;
        
    }

    public TreeNode buildUniqueTree(int[] postorder,int posStart,int posEnd,
                                    int[] inorder,int inStart,int inEnd,
                                    Map<Integer,Integer> map)
    {

        if(posStart>posEnd || inStart>inEnd)
        return null;
        TreeNode root=new TreeNode(postorder[posEnd]);
        int rootIndex=map.get(root.val);
        int leftSize=rootIndex-inStart;

        root.left=buildUniqueTree(postorder,posStart,posStart+leftSize - 1,
                                inorder,inStart,rootIndex-1,map);
        root.right=buildUniqueTree(postorder,posStart+leftSize ,posEnd-1,
                                    inorder,rootIndex+1,inEnd,map);

                                    return root;
    }
}
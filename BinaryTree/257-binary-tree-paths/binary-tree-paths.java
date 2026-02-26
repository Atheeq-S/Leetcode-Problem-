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
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> ans=new ArrayList<>();
        pathToLeaf(root,new ArrayList<>(),ans);
        return ans;
    }
    public void pathToLeaf(TreeNode root,ArrayList<Integer> temp,ArrayList<String> res){
        if(root==null)
        return;
        temp.add(root.val);

        if(root.left==null && root.right==null)

        {
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<temp.size();i++){
                sb.append(temp.get(i));
                if(i!=temp.size()-1)
                sb.append("->");
            }
            res.add(sb.toString());
            temp.remove(temp.size()-1);
            return;
        }
        pathToLeaf(root.left,temp,res);
        pathToLeaf(root.right,temp,res);
        temp.remove(temp.size()-1);
    }

}
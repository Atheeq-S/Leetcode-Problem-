/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        //map the parent to the node;

        Map<TreeNode,TreeNode> parentMap=new HashMap<>();
        mapParent(root,null,parentMap);

        //traversal 
        Queue<TreeNode> queue=new LinkedList<>();
        Set<TreeNode> visited=new HashSet<>();
        int count=0;
        queue.offer(target);
        visited.add(target);

        while(!queue.isEmpty()){
            int size=queue.size();
            if(count == k)
            break;
            count++;
            
            for(int i=0;i<size;i++){
                TreeNode curr=queue.poll();
                if(curr.left!=null && !visited.contains(curr.left))
                {
                    queue.offer(curr.left);
                    visited.add(curr.left);
                }
                if(curr.right!=null && !visited.contains(curr.right))
                {
                    queue.offer(curr.right);
                    visited.add(curr.right);
                }

                TreeNode parent=parentMap.get(curr);

                if(parent!=null && !visited.contains(parent)){
                    visited.add(parent);
                    queue.offer(parent);
                }

            }
        }

        List<Integer> list=new LinkedList<>();
        while(!queue.isEmpty()){
            list.add(queue.poll().val);

        }
        return list;    
    }

    public void mapParent(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> parentMap) {
        if(root==null) return;
        parentMap.put(root, parent);
        mapParent(root.left, root, parentMap);
        mapParent(root.right, root, parentMap);
    }
}
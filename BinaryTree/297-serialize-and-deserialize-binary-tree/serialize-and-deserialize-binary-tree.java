/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root ==null )
        return "";

        Queue<TreeNode>queue=new LinkedList<>();
        StringBuilder sb =new StringBuilder();

        queue.add(root);

        while(!queue.isEmpty())
        {
            TreeNode curr=queue.poll();
            if(curr==null){
                sb.append("n ");
                continue;
            }
            

            sb.append(curr.val + " ");
            queue.offer(curr.left);
            queue.offer(curr.right);
        }

        return sb.toString();

        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "")
        return null;
        Queue<TreeNode> queue=new LinkedList<>();
        String[] values=data.split(" ");
        TreeNode root=new TreeNode(Integer.parseInt(values[0]));
        queue.offer(root);

        for(int i=1;i<values.length;i++){
            TreeNode parent=queue.poll();


            if(!values[i].contains("n")){
                TreeNode left=new TreeNode(Integer.parseInt(values[i]));
                parent.left=left;
                queue.offer(left);

            }
            if(!values[++i].contains("n")){
                TreeNode right=new TreeNode(Integer.parseInt(values[i]));
                parent.right=right;
                queue.offer(right);
            }
        }
        return root;

    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
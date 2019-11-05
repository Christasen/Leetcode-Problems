/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// BFS -> O(n)
// Space ->  O(width) where width is the max width of the tree
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // edge cases
        if (root == null) {
            return "";
        }
        // bsf + queue, dfs->stack
        // string builder to save results
        // !!! syntax of sb
        StringBuilder sb = new StringBuilder();
        // should be linkedlists here
        Queue<TreeNode> q = new LinkedList<>();

        // append the root to queue
        q.offer(root);
        while (q.isEmpty() == false) {
            // mistake here!!!!!!!
            TreeNode parent = q.poll();
            // mistake here!!!!
            if (parent == null) {
                sb.append("null");
            } else { // else, add the value to the sb and add its children to the queue
                sb.append(parent.val);
                // !!!!!!mistake here
                q.offer(parent.left);
                q.offer(parent.right);
            }
            sb.append(",");
        }
        // remove the last extra , syntax for deleting an element in a certain position
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.

    public TreeNode deserialize(String data) {
        // mistake here!!!!!
        if (data == "") {
            return null;
        }
        // we can use , to do the split
        String[] array = data.split(",");
        // create treenode
        // connect to parent node
        // add to queue
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        // syntax for sparseInt
        // Integer.parseInt(value)!!!!!! -> 将str 转成int
        TreeNode root = new TreeNode(Integer.parseInt(array[0]));
        q.offer(root);
        for (int i = 1; i < array.length - 1; i++) {
            TreeNode parent = q.poll();
            // left cases;
            if (array[i].equals("null") == false) {
                TreeNode left = new TreeNode(Integer.parseInt(array[i]));
                parent.left = left;
                q.offer(left);
            } // null case?
            if (array[++i].equals("null") == false) {
                TreeNode right = new TreeNode(Integer.parseInt(array[i]));
                parent.right = right;
                q.offer(right);
            }
        }
        return root;

    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

// check the minimum depth of a bs

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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }
        int min_depth = Integer.MAX_VALUE;

        // consider the case that left root is null
        if (root.left != null) {
            int temp1 = minDepth(root.left);
            min_depth = Math.min(temp1, min_depth);
        }

        // consider the case that right root is null
        if (root.right != null) {
            int temp2 = minDepth(root.right);
            min_depth = Math.min(temp2, min_depth);

        }

        return min_depth + 1;
    }
}

class Solution1 {
  public int minDepth(TreeNode root) {

    if (root == null) {
      return 0;
    }

    // parenthesis should appear after the "<>" sign
    Stack<TreeNode> tree = new Stack<TreeNode>();
    Stack<Integer> value = new Stack<Integer>();

    int min_depth = Integer.MAX_VALUE;
    tree.push(root);
    value.push(min_depth);

    while(tree.isEmpty() == false) {
      TreeNode temp = tree.pop();
      int local_value = value.pop();

      // here you have to consider the condition that
      // you only reach the leaf node to get the
      // depth value
      if (temp.left == null && temp.right == null){
        min_depth = Math.min(min_depth);
      }

      if (temp.left != null) {
        tree.push(temp.left);
        value.push(local_value + 1);
      }

      if (temp.right != null) {
        tree.push(temp.right);
        value.push(local_value + 1);
      }

    }

    return min_depth;

  }
}

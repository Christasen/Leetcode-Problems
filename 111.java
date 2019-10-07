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

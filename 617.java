// merge two binary trees
// recursive Solution
// O(m) time, m = minumun number of nodes from the two given trees
// o(m) space, the depth of the recursion tree of the worst case,
// in average would be logn

class Solution{
  public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    // egde cases
    if (t1 == null) {
      return t2;
    }
    if (t2 == null) {
      return t1;
    }

    t1.val += t2.val;
    t1.left = mergeTrees(t1.left, t2.left);
    t1.right = mergeTrees(t1.right, t2.right);

    return t1;
  }

}

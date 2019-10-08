// invert binary trees
// swap all the lefts and rights for bt

// recursive
class SolutionRecursive {

  public TreeNode invertTree(TreeNode root) {

    // check egde cases
    if (root == null) {
      return null;
    }

    TreeNode left = invertTree(root.left);
    TreeNode right = invertTree(root.right);

    // swap here
    root.left = right;
    root.right = left;

    return root;
  }

}

// non-recursive version

class SolutionBFS {
  public TreeNode invertTree(TreeNode root) {

    if (root == null) {
      return null;
    }
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);

    while(queue.isEmpty() == false) {
      TreeNode current = queue.poll();
      TreeNode temp = current.left;
      current.left = current.right;
      current.right = temp;

      if(current.left!= null) {
        queue.add(current.left);
      }

      if(current.right != null) {
        queue.add(current.right);
      }

    }

    return root;

  }


}

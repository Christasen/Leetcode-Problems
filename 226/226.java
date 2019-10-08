// invert binary trees
// swap all the lefts and rights for bt

// recursive
class SolutionRecursive {

  public TreeNode invertTree(TreeNode root) {

    // check egde cases
    if (root == null) {
      return null;
    }

    // class solve methods
    TreeNode left = invertTree(root.left);
    TreeNode right = invertTree(root.right);

    // swap here
    root.left = right;
    root.right = left;

    return root;
  }

}

// non-recursive version

/**

Time complexity  O(n), all nodes will be added to the queue once
Space complexity O(n) worst case would be the queue only contain all nodes in
one level of binary tree


*/

class SolutionBFS{
  public TreeNode invertTree(TreeNode root) {

    if (root == null) {
      return null;
    }
    // we want to create this quere here
    // the function of this queue is to store nodes
    // whose lkeft and right child have not been swapped yet
    // while the queue is here, we want to swap the child
    // and delete it and then add new child
    // once the queue is empty, the whole tree has been swapped
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

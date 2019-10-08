// leetcode 104

// recrusive solution

class Solution1{

  class TreeNode{
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
      this.val = val;
    }
  }

  public int maxDepth(TreeNode root) {
    if(root == null) {
      return 0;
    }
    // divide the tree here
    if (root.left == null && root.right == null) {
      return 1;
    }

    int left = maxDepth(root.left);
    int right =  maxDepth(root.right);

    return Math.max(left, right) + 1;
  }

}

// DFS + stack
class Solution2{

  public int maxDepth(TreeNode root) {
    if(root == null) {
      return 0;
    }
    // new stack here to check the values
    // LIFO
    Stack<TreeNode> tree = new Stack<TreeNode>();
    Stack<Integer> value = new Stack<Integer>();
    int local_max = Integer.MIN_VALUE;
    // add the root first into the stack
    tree.push(root);
    value.push(1);

    while(tree.isEmpty() == false) {
      // this is how you
      TreeNode node = tree.pop();
      int temp = value.pop();
      
      local_max = Math.max(local_max, temp);

      if(node.left != null) {
        tree.push(node.left);
        val.push(temp + 1);
      }

      if(node.right != null) {
        tree.push(node.right);
        val.push(temp + 1);
      }
    }

    return local_max;

  }
}

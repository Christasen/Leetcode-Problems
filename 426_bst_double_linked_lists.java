/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
// from the output we can see that we want to get all node from bst
// and sort them in ascending order
// this is very similar to our BST inorder traversal -> left -> middle -> right
// by observing this pattern, we will use recursion to solve this problem

// create a head of a linked list

// store all the nodes into another list -> tail -> global variable here

// connect head and tail
// O(n), traverse the tree for few times
// O(n) -> worst case. best case O(logn) -? recursion stack of size tree height;
// 如何把头尾相连 -》 处理一次
// 如何把每个node当作root的时候，将左右相连 -》 hepler function
class Solution {
    Node previous = null; // store the result of the nodes list
    public Node treeToDoublyList(Node root) {
        // edge cases
        if (root == null) return null;

        Node dummy = new Node(0, null, null); // 记录最初的node是什么， dummy。right 存第一个node
        previous = dummy;

        // store nodes in the previous nodes by using helper function
        // 将nodes全部连起来
        helper(root);

        // 将头尾相连，形成环
        previous.right = dummy.right;
        dummy.right.left = previous;

        return dummy.right;
    }
    // 将头尾相连，先处理左边，在处理中间，在处理右边
    public void helper(Node current) {
        if (current == null) return;
        // left
        helper(current.left);
        // middle
        previous.right = current;
        current.left = previous;
        // 将当前的current往右边移
        previous = current;
        // right
        helper(current.right);
    }
}

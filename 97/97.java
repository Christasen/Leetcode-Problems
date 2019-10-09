// for this problem. math deduction way
// first you have to understand the property of BST
// Root > all left numbers
// Root < all right numbers
// thus, given n nodes, the way to form bst would be a Catalan numbers
// given c0 = 1; cn+1 = 2*(2n+1)/(n+2)*Cn
// time complexity O(n)
// space complexity O(1)
// solution 1

class Solution1{
  public int numTree(int nodes) {
    long c = 1;
    for (int i = 0; i < nodes; i++) {
      c = c * 2 *(2*i + 1)/(i + 2);
    }
    return (int) c;
  }
}

// alternative way is to use dynamic programming
// first we assume a function G[n]: the number of unique BST for a sequence
// of length n
// F(i, n) = the number of unique BST, where the number i is served as the
// root of BST (1<= i <= n)
// here you have the time complexity of o(n^2) since you have two for loops
// the space would be O(n) as well since you created a new array

class Solution2{
  public int numTress(int nodes) {
    int[] G = new int[n+1];
    // zero nodes, generate null
    G[0] = 1;
    // 1 nodes, only 1 case
    G[1] = 1;

    for (int i = 2; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        G[i] = G[j-1] * G[i-j];
      }
    }
    return G[i];
  }

}

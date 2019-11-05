// two pointer approach
// to find out the product except one element self;
// first, find its left sum without itself;
// then find its right sum without itself;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] result = new int[nums.length];
        result[0] = 1;
        // calculate the left product
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i-1] * nums[i-1];
        }
        // calculate the right product;
        int right = 1;
        // here you have to remember that i could be equal to 00000
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = result[i] * right;
            right = right * nums[i];
        }

        return result;
    }
}

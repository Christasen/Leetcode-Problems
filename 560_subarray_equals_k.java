// Input:nums = [1,1,1], k = 2
// Output: 2
// 1. brute force： 三层for loop， 遍历 i - j 之间的sum是否为k o（n2）
// 2. prefix sum
class Solution {
    public int subarraySum(int[] nums, int k) {
        // hashmap problem
        // Nums        1 1 1
        // Index       0 1 2
        // PrefixSum 0 1 2 3
        // PrefixSum[i, j] = PrefixSum[j] - PrefixSum[i-1]
        // now that we want to know the sum equals K = PrefixSum[i, j]
        // Which is Prefix[i-1] = PrefixSum[j] - K,
        // Key： PrefixSum[j] - K,
        // value：Prefix[i-1]
        // Thus, we construct a hashmap to store values for (Sum, times of sum)
        // corner case
        // O(n) entire array is traversed once
        // O(n) hashmap contains n keys
        if(nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> hash = new HashMap<>();
        int prefixSum = 0;
        int count = 0;

        // initialize the very first pair of sum and this
        // means that 0 only appears once in his hash map
        hash.put(0, 1);

        // traverse
        // 如果找到了两个相同的difference 就是count
        for(int i = 0; i < nums.length; i++) {
            prefixSum = prefixSum + nums[i];
            // if we found the following sum
            if (hash.containsKey(prefixSum - k)){
                // mistakes here
                count = count + hash.get(prefixSum-k);
            }
            hash.put(prefixSum, hash.getOrDefault(prefixSum, 0) + 1);
        }

        return count;

    }
}

// Input: points = [[3,3],[5,-1],[-2,4]], K = 2
// Output: [[3,3],[-2,4]]
// (The answer [[-2,4],[3,3]] would also be accepted.)
// initial thought -> calculate each element's distance, store
// everything into a new array
// o(NlogN) -> sorting
// -> optimization: construct a min heap
// int[][] declaration should be like this
// also, construct pq -> change((a, b) -> ()(a[1]*a[1]) - (b[1]*b[1])))

// 时间复杂度为O(NlogK) 空间复杂度为O(K), N 为points的个数，K为要找出的points个数
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        // priority queue since the question is asking the smallest elements
        // thus we use a min heap in this case;
        if(points == null || points.length == 0 || points[0].length == 0) {
            return null;
        }
        int[][] result = new int[K][2];
        // construct a min heap
        Queue<int[]> minHeap = new PriorityQueue<>(
                (a, b) -> ((a[0]*a[0] + a[1] * a[1])- (b[0] * b[0] + b[1] * b[1])));

        for (int[] pts: points) {
            minHeap.add(pts);
        }
        for (int i = 0; i < K; i++) {
            result[i] = minHeap.poll();
        }
        return result;
    }
}

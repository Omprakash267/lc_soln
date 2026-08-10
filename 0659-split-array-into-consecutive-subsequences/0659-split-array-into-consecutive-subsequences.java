class Solution {
    public boolean isPossible(int[] nums) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(
                (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        for (int num : nums) {
            while (!heap.isEmpty() && heap.peek()[0] < num - 1) {
                if (heap.poll()[1] < 3) {
                    return false;
                }
            }
            if (!heap.isEmpty() && heap.peek()[0] == num - 1) {
                int[] top = heap.poll();
                heap.offer(new int[] { num, top[1] + 1 });
            } else {
                heap.offer(new int[] { num, 1 });
            }
        }
        while (!heap.isEmpty()) {
            if (heap.poll()[1] < 3) {
                return false;
            }
        }
        return true;
    }
}
class Solution {
    public int minMoves(int[] nums) {
        long sum = 0;
        int min = Integer.MAX_VALUE;
        
        for (int num : nums) {
            sum += num;
            if (num < min) {
                min = num;
            }
        }
        
        long moves = sum - (long) min * nums.length;
        return (int) moves;
    }
}
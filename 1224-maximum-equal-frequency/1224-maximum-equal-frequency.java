class Solution {
    public int maxEqualFreq(int[] nums) {
        int maxElement = 0;
        for (int el : nums) {
            maxElement = Math.max(maxElement, el);
        }
        int totalNums = nums.length;
        int[] frequencyMap = new int[maxElement + 1];
        int[] inverseFrequencyMap = new int[totalNums + 1];
        int minFreq = Integer.MAX_VALUE, maxFreq = 0;
        int bestLength = 1;
        int count = 0; 
        for (int i = 0; i < totalNums; i++) {
            int currentNumber = nums[i];
            int existingFreq = frequencyMap[currentNumber];
            frequencyMap[currentNumber]++;

            if (existingFreq > 0) {
                inverseFrequencyMap[existingFreq]--;
                if (inverseFrequencyMap[existingFreq] == 0) {
                    if (existingFreq == minFreq) {
                        minFreq = existingFreq + 1;
                    }
                    count--;
                }
            }
            int newFreq = existingFreq + 1;
            if (inverseFrequencyMap[newFreq] == 0) {
                count++;
            }
            inverseFrequencyMap[newFreq]++;
            minFreq = Math.min(minFreq, newFreq);
            maxFreq = Math.max(maxFreq, newFreq);
            if (count == 1 && (maxFreq == 1 || inverseFrequencyMap[maxFreq] == 1)) {
                bestLength = i + 1;
            } else if (count == 2) {
                if (inverseFrequencyMap[1] == 1 
                        || inverseFrequencyMap[maxFreq] == 1 && maxFreq == minFreq + 1) {
                    bestLength = i + 1;
                }
            }
        }
        return bestLength;
    }
}
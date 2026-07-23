class Solution {
    public String customSortString(String order, String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        StringBuilder result = new StringBuilder();
        for (char c : order.toCharArray()) {
            int idx = c - 'a';
            while (count[idx] > 0) {
                result.append(c);
                count[idx]--;
            }
        }
        for (int i = 0; i < 26; i++) {
            while (count[i] > 0) {
                result.append((char) ('a' + i));
                count[i]--;
            }
        }
        
        return result.toString();
    }
}
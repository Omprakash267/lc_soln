class Solution {

    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {

        backtrack("", 0, 0, n);
        return ans;
    }

    private void backtrack(String current, int open, int close, int n) {

        if (current.length() == 2 * n) {
            ans.add(current);
            return;
        }

        if (open < n) {
            backtrack(current + "(", open + 1, close, n);
        }

        if (close < open) {
            backtrack(current + ")", open, close + 1, n);
        }
    }
}
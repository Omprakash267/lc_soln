class Solution {
    public boolean checkIfPangram(String sentence) {

        boolean[] letters = new boolean[26];

        for(int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
            letters[ch - 'a'] = true;
        }

        for(boolean b : letters) {
            if(!b)
                return false;
        }

        return true;
    }
}